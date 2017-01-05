package pallav.example.com.galleryapp.retro_controller;


import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroGenerator {
    private static Retrofit retrofit;

    public static void init(Context context) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        RetroInterceptor retroInterceptor = new RetroInterceptor();
        retroInterceptor.setContext(context);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).addNetworkInterceptor(retroInterceptor).connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).build();

//        String url = "http://www.omdbapi.com/"; //dev url
        String url = "http://www.omdbapi.com/"; // stagging url

        retrofit = new Retrofit.Builder().baseUrl(url/*BuildConfig.HOST*/).
                addConverterFactory(GsonConverterFactory.create()).client(client)
                .build();
    }

    public static IRetroServices getService(Context context){
        if (retrofit==null)
            init(context);
        return retrofit.create(IRetroServices.class);
    }
}

package pallav.example.com.galleryapp.retro_controller;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;


public class RetroInterceptor implements Interceptor {

    private static final String TAG = RetroInterceptor.class.getName();
    private Context mContext;

    private Context getContext() {
        return mContext;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {


        return null;
    }

}

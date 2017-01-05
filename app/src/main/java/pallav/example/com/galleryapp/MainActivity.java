package pallav.example.com.galleryapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  implements Callback<MovieResponse>{
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        GetMethodDemo demo = new GetMethodDemo();
        demo.execute();
       /* RetroGenerator.getService(this);

        // prepare call in Retrofit 2.0
        IRetroServices iRetroServices = RetroGenerator.getService(this);

        Call<MovieResponse> call = iRetroServices.getMovieData("jumanji","","short","json");
        //asynchronous call
        call.enqueue(this);*/

    }


    @Override
    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
        Log.d("TAG", response.body().toString());
        Toast.makeText(this, response.body().getDirector(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(Call<MovieResponse> call, Throwable t) {
        Toast.makeText(this, "Failure", Toast.LENGTH_LONG).show();
    }


    private void hitApi(){
        URL url;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL("http://www.omdbapi.com/");

            urlConnection = (HttpURLConnection) url
                    .openConnection();

            InputStream in = urlConnection.getInputStream();

            InputStreamReader isw = new InputStreamReader(in);

            int data = isw.read();
            while (data != -1) {
                char current = (char) data;
                data = isw.read();
                System.out.print(current);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }


    public class GetMethodDemo extends AsyncTask<Void , Void ,String> {
        String server_response;


        @Override
        protected String doInBackground(Void... params) {

            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL("http://www.omdbapi.com/?t=jumanji&y=t&r=json&plot=short");
                urlConnection = (HttpURLConnection) url.openConnection();

                int responseCode = urlConnection.getResponseCode();

                if(responseCode == HttpURLConnection.HTTP_OK){
                    server_response = readStream(urlConnection.getInputStream());
                    Log.v("CatalogClient", server_response);
                    return  server_response;
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.e("Response", "" + server_response);


        }
    }

// Converting InputStream to String

    private String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuffer response = new StringBuffer();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response.toString();
    }
}

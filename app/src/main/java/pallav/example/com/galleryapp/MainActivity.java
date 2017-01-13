package pallav.example.com.galleryapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<MovieResponse> {
    Toolbar toolbar;
    @BindView(R.id.cl_main)
    CoordinatorLayout cl_main;
    @BindView(R.id.iv_wall_thumb)
    ImageView iv_wall_thumb;
    @BindView(R.id.lv_details)
    ListView lv_details;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        GetMethodDemo demo = new GetMethodDemo();
        demo.execute();

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

    private MovieResponse parseResponse(String server_response) throws JSONException {
        JsonParser parser = new JsonParser();
        JsonElement mJson = parser.parse(server_response);
        Gson gson = new Gson();
        MovieResponse object = gson.fromJson(mJson, MovieResponse.class);
        return object;
    }

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

// Converting InputStream to String

    public class GetMethodDemo extends AsyncTask<Void, Void, String> {
        String server_response;


        @Override
        protected String doInBackground(Void... params) {

            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL("http://www.omdbapi.com/?t=jumanji&y=t&r=json&plot=short");
                urlConnection = (HttpURLConnection) url.openConnection();

                int responseCode = urlConnection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    server_response = readStream(urlConnection.getInputStream());
                    Log.v("CatalogClient", server_response);
                    final MovieResponse response = parseResponse(server_response);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Glide.with(MainActivity.this)
                                    .load(response.getPoster())
                                    .placeholder(R.drawable.ic_camera_enhance_white_24dp)
                                    /*.animate(R.anim.move)*/
                                    .crossFade()
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                                    .into(iv_wall_thumb);
                        }
                    });

                    Snackbar.make(cl_main, response.getDirector(), Snackbar.LENGTH_SHORT).show();
                    return server_response;
                } else {
                    Snackbar.make(cl_main, "Fail", Snackbar.LENGTH_SHORT).show();
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
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
}

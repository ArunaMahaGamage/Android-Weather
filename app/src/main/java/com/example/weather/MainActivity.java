package com.example.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.weather.apicall.ApiClient;
import com.example.weather.beans.Weather;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageSize;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiClient apiClient;
    Call call;
    Weather weather;

    ImageView iv_weather_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        apiClient = new ApiClient();
        call = apiClient.getAPICall();
        result();
    }

    public void initUI() {
        iv_weather_icon = (ImageView) findViewById(R.id.iv_weather_icon);
    }

    private void result() {
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                weather = (Weather) response.body();

                if (weather.getCod().equals("200")) {
                    Toast.makeText(MainActivity.this, " Success : " + weather.getCod(), Toast.LENGTH_LONG).show();
                    setData();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }

    private void setData() {
        String imageUri = "http://openweathermap.org/img/w/10d.png";

        // Create global configuration and initialize ImageLoader with this config
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
			.build();
        ImageLoader.getInstance().init(config);

        ImageSize targetSize = new ImageSize(100, 100);
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(imageUri, iv_weather_icon,targetSize);
    }

    /*private void getAPICall() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        Service client = retrofit.create(Service.class);

        Call <Weather> call = client.repoForUser();

        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {

                String cod = response.body().getCod();
                Toast.makeText(MainActivity.this," Success : " + cod , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Toast.makeText(MainActivity.this,"error : " + t, Toast.LENGTH_LONG).show();
            }
        });
    }*/
}

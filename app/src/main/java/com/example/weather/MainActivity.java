package com.example.weather;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weather.adapters.MyAdapter;
import com.example.weather.apicall.ApiClient;
import com.example.weather.beans.ListMain;
import com.example.weather.beans.ListWeather;
import com.example.weather.beans.Lists;
import com.example.weather.beans.Weather;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageSize;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    ApiClient apiClient;
    Call call;
    Weather weather;

    ImageView iv_weather_icon;
    TextView tv_current_weather_description;
    TextView tv_current_temp;
    TextView tv_current_temp_heigh;
    TextView tv_current_temp_low;
    TextView tv_location;

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
        tv_current_weather_description = (TextView) findViewById(R.id.tv_current_weather_description);
        tv_current_temp = (TextView) findViewById(R.id.tv_current_temp);
        tv_current_temp_heigh = (TextView) findViewById(R.id.tv_current_temp_heigh);
        tv_current_temp_low = (TextView) findViewById(R.id.tv_current_temp_low);
        tv_location = (TextView) findViewById(R.id.tv_location);
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

        // Create global configuration and initialize ImageLoader with this config
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .build();
        ImageLoader.getInstance().init(config);

        ImageSize targetSize = new ImageSize(100, 100);

        // Retrofit Data
        List list = weather.getList();
        Lists lists = (Lists) list.get(0);
        ListWeather listWeather = lists.getWeather().get(0);


        double temp = lists.getMain().getTemp();

        double currentTempDouble = temp - 273.15;
        Integer currentTemp = new Integer((int) currentTempDouble);

        String icon = listWeather.getIcon ();

        String imageUri = "http://openweathermap.org/img/w/" + icon + ".png";

        double temp_heigh = lists.getMain().getTemp_max();
        double current_temp_heigh = temp_heigh - 273.15;

        double temp_low = lists.getMain().getTemp_min();
        double current_temp_low = temp_low - 273.15;


        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(imageUri, iv_weather_icon,targetSize);

        String location = " Country " + (weather.getCity().getCountry()) + " City " + (weather.getCity().getName());


        tv_current_weather_description.setText(listWeather.getMain());
        tv_current_weather_description.setTextColor(Color.WHITE);
        tv_current_temp.setText(String.valueOf(currentTemp) + "°" + "C");
        tv_current_temp.setTextSize(60f);
        tv_current_temp.setTextColor(Color.WHITE);

        tv_current_temp_heigh.setText("H " + String.valueOf((int) current_temp_heigh) + "°" + "C");
        tv_current_temp_heigh.setTextSize(20f);
        tv_current_temp_heigh.setTextColor(Color.WHITE);

        tv_current_temp_low.setText("L " + String.valueOf((int) current_temp_low) + "°" + "C");
        tv_current_temp_low.setTextSize(20f);
        tv_current_temp_low.setTextColor(Color.WHITE);

        tv_location.setText(location);
        tv_location.setTextColor(Color.WHITE);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        String[] myDataset = {"A","B","C","D","E","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
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

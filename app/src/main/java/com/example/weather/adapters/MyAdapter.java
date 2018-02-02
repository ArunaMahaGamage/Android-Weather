package com.example.weather.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weather.R;
import com.example.weather.beans.ListWeather;
import com.example.weather.beans.Lists;
import com.example.weather.beans.Weather;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;

import java.util.Date;
import java.util.List;

/**
 * Created by aruna on 12/25/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Weather weather;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        public TextView lv_date;
        public TextView tv_time;
        public TextView tv_temp;
        public ImageView iv_icon;

        public ViewHolder(View v) {
            super(v);
            lv_date = v.findViewById(R.id.lv_date);
            tv_time = v.findViewById(R.id.tv_time);
            iv_icon = v.findViewById(R.id.iv_icon);
            tv_temp = v.findViewById(R.id.tv_temp);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Weather weather) {
        this.weather = weather;
    }


    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {

        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        List list = weather.getList();
        Lists lists = (Lists) list.get(position);

        String apiDate = lists.getDt_txt();
        String [] date_time = apiDate.split(" ");

        double temp = lists.getMain().getTemp();
        double currentTempDouble = temp - 273.15;
        Integer currentTemp = new Integer((int) currentTempDouble);

        Date date = new Date();

        holder.lv_date.setText(date_time[0]);
        holder.lv_date.setTextColor(Color.WHITE);

        holder.tv_time.setText(date_time[1]);
        holder.tv_time.setTextColor(Color.WHITE);

        ImageSize targetSize = new ImageSize(100, 100);
        ListWeather listWeather = lists.getWeather().get(0);
        String icon = listWeather.getIcon ();
        String imageUri = "http://openweathermap.org/img/w/" + icon + ".png";
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(imageUri, holder.iv_icon,targetSize);

        holder.tv_temp.setText(String.valueOf(currentTemp) + "°" + "C");
        holder.tv_temp.setTextColor(Color.WHITE);
    }

    @Override
    public int getItemCount() {
        return weather.getList().size();
    }
}

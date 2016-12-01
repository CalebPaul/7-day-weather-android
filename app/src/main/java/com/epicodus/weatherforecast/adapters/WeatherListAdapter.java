package com.epicodus.weatherforecast.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.weatherforecast.R;
import com.epicodus.weatherforecast.models.Weather;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 11/30/16.
 */
public class WeatherListAdapter {
    private ArrayList<Weather> mWeather = new ArrayList<>();
    private Content mContent;

    public WeatherListAdapter(Context context, ArrayList<Weather> restaurants) {
        mContext = context;
        mWeather = weather;
    }

    @Override
    public WeatherListAdapter.WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_list_item, parent, false);
        WeatherViewHolder viewHolder = new WeatherViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WeatherListAdapter.WeatherViewHolder holder, int position) {
        holder.bindWeather(mWeather.get(position));
    }

    @Override
    public int getItemCount() {
        return mWeather.size();
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.weatherImageView)
        ImageView mRestaurantImageView;
        @Bind(R.id.weatherNameTextView)
        TextView mNameTextView;
        @Bind(R.id.categoryTextView) TextView mCategoryTextView;
        @Bind(R.id.ratingTextView) TextView mRatingTextView;
        private Context mContext;


        public RestaurantViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindRestaurant(Weather weather) {
            Picasso.with(mContext).load(weather.getImageUrl()).into(mRestaurantImageView);
            mNameTextView.setText(weather.getName());
            mCategoryTextView.setText(weather.getCategories().get(0));
            mRatingTextView.setText("Rating: " + weather.getRating() + "/5");
        }
    }
}

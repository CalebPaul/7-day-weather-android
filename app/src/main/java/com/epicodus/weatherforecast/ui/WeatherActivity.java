package com.epicodus.weatherforecast.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.epicodus.weatherforecast.R;
import com.epicodus.weatherforecast.models.Weather;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WeatherActivity extends AppCompatActivity {
    @Bind(R.id.listView)
    ListView mListView;

    public ArrayList<Weather> mWeather = new ArrayList<>();

    public static final String TAG = WeatherActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
    }

//    private void getWeather(String location) {
//        final WeatherService weatherService = new WeatherService();
//
//        weatherService.findWeather(location, new Callback() {
//
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response){
//                mWeather = weatherService.processResults(response);
//
//                WeatherActivity.this.runOnUiThread(new Runnable() {
//
//                    @Override
//                    public void run() {
//                        String[] restaurantNames = new String[mWeather.size()];
//                        for (int i = 0; i < restaurantNames.length; i++) {
//                            restaurantNames[i] = mWeather.get(i).getName();
//                        }
//
//
//                        ArrayAdapter adapter = new ArrayAdapter(WeatherActivity.this, android.R.layout.simple_list_item_1, restaurantNames);
//                        mListView.setAdapter(adapter);
//
//                        for (Weather restaurant : mWeather) {
//                            Log.d(TAG, "Name: " + restaurant.getName());
//                        }
//                    }
//                });
//            }
//
//        });
//    }
}

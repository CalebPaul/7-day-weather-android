package com.epicodus.weatherforecast.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.epicodus.weatherforecast.R;
import com.epicodus.weatherforecast.models.Weather;
import com.epicodus.weatherforecast.services.WeatherService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {


    public ArrayList<Weather> mWeather = new ArrayList<>();

    public static final String TAG = WeatherActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");

        getWeather(location);
    }

    private void getWeather(String location) {
        final WeatherService weatherService = new WeatherService();
        weatherService.findWeather(location, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
//                try {
//                    String jsonDataaa = response.body().string();
//                    Log.v(TAG, "JSON: " + jsonDataaa);
//                    if (response.isSuccessful()) {
                        Log.v(TAG, "Successful Response");
                        mWeather = weatherService.processResults(response);
//                    }
//            } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }

        });
    }
}

package com.epicodus.weatherforecast.services;

import android.util.Log;

import com.epicodus.weatherforecast.Constants;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Guest on 11/29/16.
 */
public class WeatherService {

    public static void findWeather(String location, Callback callback){
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.YOUR_QUERY_PARAMETER, location);
        urlBuilder.addQueryParameter(Constants.DATA_QUERY_PARAMETER, Constants.DATA_TYPE);
        urlBuilder.addQueryParameter(Constants.UNITS_QUERY_PARAMETER, Constants.UNITS);
        urlBuilder.addQueryParameter("cnt", "7");
        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.API_KEY);
        String url = urlBuilder.build().toString();

        Log.v("Weather Service", "url: " + url);
        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }


//    public ArrayList<Weather> processResults(Response response) {
//        ArrayList<Weather> forecasts = new ArrayList<>();
//    }
}

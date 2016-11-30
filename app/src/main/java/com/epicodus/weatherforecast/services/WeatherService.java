package com.epicodus.weatherforecast.services;

import android.util.Log;

import com.epicodus.weatherforecast.Constants;
import com.epicodus.weatherforecast.models.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherService {

    public static final String TAG = WeatherService.class.getSimpleName();

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


    public ArrayList<Weather> processResults(Response response) {

        ArrayList<Weather> forecasts = new ArrayList<>();

        try {
            Log.v(TAG, "Spot Test 1");
            String jsonData = response.body().string();
            Log.v(TAG, "Spot Test 2");

            Log.v(TAG, "RESPONSE LOG: " + jsonData);

            if (response.isSuccessful()) {
                JSONObject weatherJSON = new JSONObject(jsonData);
                JSONArray listJSON = weatherJSON.getJSONArray("list");

                String name = weatherJSON.getJSONObject("city").getString("name");

                for (int i = 0; i < listJSON.length(); i++){

                    JSONObject forecastJSON = listJSON.getJSONObject(i);
                    String date = forecastJSON.getString("dt");
                    double maxTemperature = forecastJSON.getJSONObject("temp").getDouble("max");
                    double minTemperature = forecastJSON.getJSONObject("temp").getDouble("min");
                    String weatherDescription = forecastJSON.getJSONArray("weather").getJSONObject(0).getString("description");

                    Weather weather = new Weather(name, date, maxTemperature, minTemperature, weatherDescription);
                    Log.v(TAG, "Weather Object: " + weather);
                    forecasts.add(weather);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.v(TAG, "Forecast Array: " + forecasts);
        return forecasts;
    }
}

package com.epicodus.weatherforecast;

/**
 * Created by Guest on 11/29/16.
 */
public class Constants {
    public static final String API_KEY = BuildConfig.API_KEY;
    public static final String API_BASE_URL = "http://www.api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=imperial&cnt=7&q=London";
    public static final String YOUR_QUERY_PARAMETER = "location"; //Example: "location"
    public static final String API_KEY_QUERY_PARAMETER = "ApiKey";
}

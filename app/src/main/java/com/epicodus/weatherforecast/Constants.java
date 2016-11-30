package com.epicodus.weatherforecast;

/**
 * Created by Guest on 11/29/16.
 */
public class Constants {
    public static final String API_KEY = BuildConfig.API_KEY;
    public static final String API_BASE_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?";
    public static final String YOUR_QUERY_PARAMETER = "q";
    public static final String DATA_QUERY_PARAMETER = "mode";
    public static final String DATA_TYPE = "json";
    public static final String UNITS_QUERY_PARAMETER = "units";
    public static final String UNITS = "imperial";
    public static final String API_KEY_QUERY_PARAMETER = "APPID";
}

//http://www.api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=imperial&location=Chicago&APPID=5d7d13b1e12e37ae41e3a0660e0d9f5d

//api.openweathermap.org/data/2.5/forecast/daily?q=Portland&mode=json&units=imperial&cnt=7&APPID=5d7d13b1e12e37ae41e3a0660e0d9f5d
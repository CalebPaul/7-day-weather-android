package com.epicodus.weatherforecast.models;

/**
 * Created by Guest on 11/29/16.
 */
public class Weather {
    private String mCity;
    private double mLongitude;
    private double mLatitude;
    private String mDate;
    private double mMaxTemperature;
    private double mMinTemperature;
    private String mWeatherDescription;
    //get icon from arraylist

    public Weather(String city, String date, double maxTemperature, double minTemperature, String mWeatherDescription){
        this.mCity = city;

        this.mDate = date;
        this.mMaxTemperature = maxTemperature;
        this.mMinTemperature = minTemperature;
        this.mWeatherDescription = mWeatherDescription;
    }

    public String getCity() {
        return mCity;
    }


    public String getDate() {
        return mDate;
    }

    public double getMaxTemperature() {
        return mMaxTemperature;
    }

    public double getMinTemperature() {
        return mMinTemperature;
    }

    public String getmWeatherDescription() {
        return mWeatherDescription;
    }
}

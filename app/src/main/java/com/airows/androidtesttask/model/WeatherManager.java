package com.airows.androidtesttask.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class WeatherManager {
    private static WeatherManager sInstance;

    private List<CityWeather> mCityWeatherList;

    public static WeatherManager getInstance() {
        if (sInstance == null) {
            sInstance = new WeatherManager();
        }

        return sInstance;
    }

    private WeatherManager() {
        mCityWeatherList = new ArrayList<>();
    }

    public void addWeatherToList(CityWeather cityWeather) {
        mCityWeatherList.add(cityWeather);
    }

    public List<CityWeather> getWeatherList() {
        return mCityWeatherList;
    }
}

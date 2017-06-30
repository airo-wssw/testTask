package com.airows.androidtesttask.network;

import android.os.AsyncTask;
import android.util.Log;

import com.airows.androidtesttask.model.CityWeather;
import com.airows.androidtesttask.model.WeatherManager;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OpenWeatherTask extends AsyncTask<String, Void, Void> {

    @Override
    protected Void doInBackground(String... params) {
        OpenWeatherDataFetchr weatherDataFetchr = new OpenWeatherDataFetchr();

        String cityName = params[0];

        CityWeather cityWeather = new CityWeather();

        try {
            cityWeather = weatherDataFetchr.getCityWeather(cityName);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        WeatherManager.getInstance().addWeatherToList(cityWeather);


        Log.i("IGOR", WeatherManager.getInstance().getWeatherList().size() + "");

        return null;
    }
}

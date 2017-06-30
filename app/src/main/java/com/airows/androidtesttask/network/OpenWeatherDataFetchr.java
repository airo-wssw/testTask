package com.airows.androidtesttask.network;

import android.net.Uri;
import android.util.Log;

import com.airows.androidtesttask.model.CityWeather;
import com.airows.androidtesttask.model.Clouds;
import com.airows.androidtesttask.model.Coord;
import com.airows.androidtesttask.model.MainData;
import com.airows.androidtesttask.model.Sys;
import com.airows.androidtesttask.model.Weather;
import com.airows.androidtesttask.model.Wind;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenWeatherDataFetchr {
    private static final String OPEN_WEATHER_MAP_ENDPOINT = "http://api.openweathermap.org/data/2.5/weather";
    private static final String QUERY_PARAM_BY_CITY_NAME = "q";
    private static final String QUERY_PARAM_API_KEY = "appid";
    private static final String OPEN_WEATHER_MAP_API_KEY = "b4730c99456cda4a3243d0ab01435f8c";

    public CityWeather getCityWeather(String cityName) throws IOException, JSONException {
        JSONObject jsonBody = getResponseBody(getUrl(cityName));
        if (jsonBody == null) return null;

        int id = jsonBody.getInt("id");
        String name = jsonBody.getString("name");
        int cod = jsonBody.getInt("cod");
        String base = jsonBody.getString("base");
        long dataTime = jsonBody.getLong("dt");



        Weather weather = parseWeatherJSON(jsonBody.getJSONArray("weather").getJSONObject(0));
        Wind wind = parseWindJSON(jsonBody.getJSONObject("wind"));
        Coord coord = parseCoordJSON(jsonBody.getJSONObject("coord"));
        MainData mainData = parseMainDataJSON(jsonBody.getJSONObject("main"));
        Clouds clouds = parseCloudsJSON(jsonBody.getJSONObject("clouds"));
        Sys sys = parseSysJSON(jsonBody.getJSONObject("sys"));

        return new CityWeather(id, name, cod, dataTime, base, coord, weather, wind, clouds, mainData, sys);

    }

    private String getUrl(String cityName) {
        return Uri.parse(OPEN_WEATHER_MAP_ENDPOINT)
                .buildUpon()
                .appendQueryParameter(QUERY_PARAM_BY_CITY_NAME, cityName)
                .appendQueryParameter(QUERY_PARAM_API_KEY, OPEN_WEATHER_MAP_API_KEY)
                .build().toString();
    }

    private JSONObject getResponseBody(String urlSpec) throws IOException {
        URL url = new URL(urlSpec);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try {
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                StringBuilder builder = new StringBuilder();

                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;

                    while ((line = reader.readLine()) != null) {
                        builder.append(line);
                    }
                } catch (IOException e) {
                    e.getMessage();
                }

                return new JSONObject(builder.toString());
            } else {
                Log.i("DataFetchr", "Connection error");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }

        return null;
    }

    private Weather parseWeatherJSON(JSONObject weatherJsonObject) throws JSONException {
        int id = weatherJsonObject.getInt("id");
        String main = weatherJsonObject.getString("main");
        String description = weatherJsonObject.getString("description");
        String icon = weatherJsonObject.getString("icon");

        return new Weather(id, main, description, icon);
    }

    private Coord parseCoordJSON(JSONObject coordJsonObject) throws JSONException {
        double lon = coordJsonObject.getDouble("lon");
        double lat = coordJsonObject.getDouble("lat");

        return new Coord(lon, lat);
    }

    private MainData parseMainDataJSON(JSONObject mainDataJsonObject) throws JSONException {
        double temp = mainDataJsonObject.getDouble("temp");
        double pressure = mainDataJsonObject.getDouble("pressure");
        int humidity = mainDataJsonObject.getInt("humidity");
        double tempMin = mainDataJsonObject.getDouble("temp_min");
        double tempMax = mainDataJsonObject.getDouble("temp_max");
        double seaLevel = mainDataJsonObject.getDouble("sea_level");
        double grndLevel = mainDataJsonObject.getDouble("grnd_level");

        return new MainData(temp, pressure, humidity, tempMin, tempMax, seaLevel, grndLevel);

    }

    private Wind parseWindJSON(JSONObject windJsonObject) throws JSONException {
        double speed = windJsonObject.getDouble("speed");
        double deg = windJsonObject.getDouble("deg");

        return new Wind(speed, deg);
    }

    private Sys parseSysJSON(JSONObject sysJsonObject) throws JSONException {
        double message = sysJsonObject.getDouble("message");
        String country = sysJsonObject.getString("country");
        long surise = sysJsonObject.getLong("sunrise");
        long sunset = sysJsonObject.getLong("sunset");

        return new Sys(message, country, surise, sunset);
    }

    private Clouds parseCloudsJSON(JSONObject cloudsJsonObject) throws JSONException {
        int all = cloudsJsonObject.getInt("all");
        return new Clouds(all);
    }
}

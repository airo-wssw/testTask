package com.airows.androidtesttask.model;

/**
 * Created by airow on 30.06.2017.
 */

public class CityWeather {
    private int mId;
    private String mName;
    private int mCod;
    private long mDataTime;
    private String mBase;
    private Coord mCoord;
    private Weather mWeather;
    private Wind mWind;
    private Clouds mClouds;
    private MainData mMainData;
    private Sys mSys;

    public CityWeather() {}

    public CityWeather(int id, String name, int cod, long dataTime, String base, Coord coord, Weather weather, Wind wind, Clouds clouds, MainData mainData, Sys sys) {
        mId = id;
        mName = name;
        mCod = cod;
        mDataTime = dataTime;
        mBase = base;
        mCoord = coord;
        mWeather = weather;
        mWind = wind;
        mClouds = clouds;
        mMainData = mainData;
        mSys = sys;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getCod() {
        return mCod;
    }

    public void setCod(int cod) {
        mCod = cod;
    }

    public long getDataTime() {
        return mDataTime;
    }

    public void setDataTime(long dataTime) {
        mDataTime = dataTime;
    }

    public String getBase() {
        return mBase;
    }

    public void setBase(String base) {
        mBase = base;
    }

    public Coord getCoord() {
        return mCoord;
    }

    public void setCoord(Coord coord) {
        mCoord = coord;
    }

    public Weather getWeather() {
        return mWeather;
    }

    public void setWeather(Weather weather) {
        mWeather = weather;
    }

    public Wind getWind() {
        return mWind;
    }

    public void setWind(Wind wind) {
        mWind = wind;
    }

    public Clouds getClouds() {
        return mClouds;
    }

    public void setClouds(Clouds clouds) {
        mClouds = clouds;
    }

    public MainData getMainData() {
        return mMainData;
    }

    public void setMainData(MainData mainData) {
        mMainData = mainData;
    }

    public Sys getSys() {
        return mSys;
    }

    public void setSys(Sys sys) {
        mSys = sys;
    }
}

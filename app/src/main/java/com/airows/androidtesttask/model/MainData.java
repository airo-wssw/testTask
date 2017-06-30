package com.airows.androidtesttask.model;


public class MainData {
    private double mTemp;
    private double mPressure;
    private int mHumidity;
    private double mTempMin;
    private double mTempMax;
    private double mPressureSeaLevel;
    private double mPressureGrndLevel;

    public MainData() {
    }

    public MainData(double temp, double pressure, int humidity, double tempMin, double tempMax, double pressureSeaLevel, double pressureGrndLevel) {
        mTemp = temp;
        mPressure = pressure;
        mHumidity = humidity;
        mTempMin = tempMin;
        mTempMax = tempMax;
        mPressureSeaLevel = pressureSeaLevel;
        mPressureGrndLevel = pressureGrndLevel;
    }

    public double getTemp() {
        return mTemp;
    }

    public void setTemp(double temp) {
        mTemp = temp;
    }

    public double getPressure() {
        return mPressure;
    }

    public void setPressure(double pressure) {
        mPressure = pressure;
    }

    public int getHumidity() {
        return mHumidity;
    }

    public void setHumidity(int humidity) {
        mHumidity = humidity;
    }

    public double getTempMin() {
        return mTempMin;
    }

    public void setTempMin(double tempMin) {
        mTempMin = tempMin;
    }

    public double getTempMax() {
        return mTempMax;
    }

    public void setTempMax(double tempMax) {
        mTempMax = tempMax;
    }

    public double getPressureSeaLevel() {
        return mPressureSeaLevel;
    }

    public void setPressureSeaLevel(double pressureSeaLevel) {
        mPressureSeaLevel = pressureSeaLevel;
    }

    public double getPressureGrndLevel() {
        return mPressureGrndLevel;
    }

    public void setPressureGrndLevel(double pressureGrndLevel) {
        mPressureGrndLevel = pressureGrndLevel;
    }
}

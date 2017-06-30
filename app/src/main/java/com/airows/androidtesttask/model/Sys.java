package com.airows.androidtesttask.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sys {
    private double mMessage;
    private String mCountry;
    private String mSunrise;
    private String mSunset;

    public Sys() {
    }

    public Sys(double message, String country, long sunrise, long sunset) {
        mMessage = message;
        mCountry = country;
        mSunrise = toStringFormat(sunrise);
        mSunset = toStringFormat(sunset);
    }

    public double getMessage() {
        return mMessage;
    }

    public void setMessage(double message) {
        mMessage = message;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public String getSunrise() {
        return mSunrise;
    }

    public void setSunrise(long sunrise) {
        mSunrise = toStringFormat(sunrise);
    }

    public String getSunset() {
        return mSunset;
    }

    public void setSunset(long sunset) {
        mSunset = toStringFormat(sunset);
    }

    private String toStringFormat(long ms) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(ms));
    }
}

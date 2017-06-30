package com.airows.androidtesttask.model;

public class Coord {
    private double mLon;
    private double mLat;

    public Coord() {
    }

    public Coord(double lon, double lat) {
        mLon = lon;
        mLat = lat;
    }

    public double getLon() {
        return mLon;
    }

    public void setLon(double lon) {
        mLon = lon;
    }

    public double getLat() {
        return mLat;
    }

    public void setLat(double lat) {
        mLat = lat;
    }
}

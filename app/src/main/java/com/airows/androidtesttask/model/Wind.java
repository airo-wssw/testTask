package com.airows.androidtesttask.model;

public class Wind {
    private double mSpeed;
    private double mDeg;

    public Wind() {
    }

    public Wind(double speed, double deg) {
        mSpeed = speed;
        mDeg = deg;
    }

    public double getSpeed() {
        return mSpeed;
    }

    public void setSpeed(double speed) {
        mSpeed = speed;
    }

    public double getDeg() {
        return mDeg;
    }

    public void setDeg(double deg) {
        mDeg = deg;
    }
}

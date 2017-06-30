package com.airows.androidtesttask.model;

import android.graphics.Bitmap;

public class Weather {
    private int mId;
    private String mMain;
    private String mDescription;
    private String mIconName;

    public Weather() {
    }

    public Weather(int id, String main, String description, String iconName) {
        mId = id;
        mMain = main;
        mDescription = description;
        mIconName = iconName;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getMain() {
        return mMain;
    }

    public void setMain(String main) {
        mMain = main;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getIconName() {
        return mIconName;
    }

    public void setIconName(String iconName) {
        mIconName = iconName;
    }
}

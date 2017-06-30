package com.airows.androidtesttask.ui.activities;

import android.support.v4.app.Fragment;

import com.airows.androidtesttask.ui.fragments.CityListFragment;

public class CityListActivity extends SingleActivity {
    @Override
    protected Fragment createFragment() {
        return new CityListFragment();
    }
}

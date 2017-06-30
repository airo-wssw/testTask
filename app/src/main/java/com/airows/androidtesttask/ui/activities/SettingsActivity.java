package com.airows.androidtesttask.ui.activities;

import android.support.v4.app.Fragment;

import com.airows.androidtesttask.ui.fragments.SettingsFragment;

public class SettingsActivity extends SingleActivity {
    @Override
    protected Fragment createFragment() {
        return new SettingsFragment();
    }
}

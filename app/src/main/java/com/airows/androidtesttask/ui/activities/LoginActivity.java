package com.airows.androidtesttask.ui.activities;


import android.support.v4.app.Fragment;

import com.airows.androidtesttask.ui.fragments.LoginFragment;

public class LoginActivity extends SingleActivity {

    @Override
    protected Fragment createFragment() {
        return new LoginFragment();
    }
}

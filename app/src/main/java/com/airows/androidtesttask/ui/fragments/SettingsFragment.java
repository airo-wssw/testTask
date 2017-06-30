package com.airows.androidtesttask.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airows.androidtesttask.R;
import com.airows.androidtesttask.ui.activities.LoginActivity;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;

public class SettingsFragment extends Fragment {

    private LoginButton mLoginButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*
        * Из задания получается, что экран авторизации и экран настроек выглядят одинаково,
        * поэтому я использую одно представление для обеих фрагментов
        * */
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        initViews(rootView);

        logoutFromFacebookAccount();
        return rootView;
    }

    private void initViews(View rootView) {
        mLoginButton = (LoginButton) rootView.findViewById(R.id.login_button);
        mLoginButton.setFragment(this);
    }

    private void logoutFromFacebookAccount() {
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                displayLoginScreen();
            }
        });
    }

    private void displayLoginScreen() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}

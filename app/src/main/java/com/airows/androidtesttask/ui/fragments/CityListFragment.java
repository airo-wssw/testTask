package com.airows.androidtesttask.ui.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.airows.androidtesttask.R;
import com.airows.androidtesttask.model.CityWeather;
import com.airows.androidtesttask.model.WeatherManager;
import com.airows.androidtesttask.network.FirebaseHandler;
import com.airows.androidtesttask.network.OpenWeatherTask;
import com.facebook.Profile;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class CityListFragment extends Fragment {

    private EditText mCityNameEditText;
    private Button mAddCityButton;
    private TextView mCitiesTextView;

    private ArrayList<String> mCityNames;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCityNames = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cities_list, container, false);
        initViews(rootView);

        final DatabaseReference userRef = FirebaseDatabase
                .getInstance()
                .getReference("users")
                .child(Profile.getCurrentProfile().getId());

        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() != null) {

                    List<String> cityNames;
                    GenericTypeIndicator<ArrayList<String>> t = new GenericTypeIndicator<ArrayList<String>>() {};
                    cityNames = dataSnapshot.getValue(t);

                    for (String cityName : cityNames) {

                        new OpenWeatherTask().execute(cityName);

                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mAddCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WeatherManager.getInstance().getWeatherList().clear();
                mCityNames.add(mCityNameEditText.getText().toString());
                userRef.setValue(mCityNames);
            }
        });

        return rootView;
    }

    private void initViews(View rootView) {
        mCityNameEditText = (EditText) rootView.findViewById(R.id.city_name_edit_text);
        mAddCityButton = (Button) rootView.findViewById(R.id.add_city_button);
        mCitiesTextView = (TextView) rootView.findViewById(R.id.cities);
    }

    @Override
    public void onResume() {
        super.onResume();
    }


}

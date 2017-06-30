package com.airows.androidtesttask.network;

import android.util.Log;

import com.facebook.Profile;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseHandler {
    private List<String> mCityNames;

    private DatabaseReference mUserReference;

    public FirebaseHandler() {
        mUserReference = FirebaseDatabase.getInstance()
                .getReference("users")
                .child(Profile.getCurrentProfile().getId());

        mCityNames = getCitiesFromFirebase();

    }

    public List<String> getCitiesFromFirebase() {
        mUserReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<List<String>> t = new GenericTypeIndicator<List<String>>() {};
                List<String> cities = dataSnapshot.getValue(t);
                mCityNames = cities;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return mCityNames;
    }

    public void addNameToFirebase(String cityName) {
        mCityNames.add(cityName);
        mUserReference.setValue(mCityNames);
    }
}

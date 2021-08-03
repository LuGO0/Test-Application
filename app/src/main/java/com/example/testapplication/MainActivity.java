package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;


import com.openmrs.android_sdk.library.OpenmrsAndroid;
import com.openmrs.android_sdk.library.models.Provider;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize the OpenMRS-SDK

        OpenmrsAndroid.initializeSdk(this);
        OpenmrsAndroid.setServerUrl("https://qa-refapp.openmrs.org/openmrs");
        OpenmrsAndroid.setUsername("admin");
        OpenmrsAndroid.setPasswordAndHashedPassword("Admin123");


        //setting up the listView for displaying the fetched data from the server

        ListView listView = (ListView) findViewById(R.id.list);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);
        MainViewModel model = ViewModelProviders.of(this).get(MainViewModel.class);
        model.getProviderList().observe(this, providerList -> {
            ProviderAdapter adapter = new ProviderAdapter(this, (ArrayList<Provider>) providerList);
            listView.setAdapter(adapter);
            progressBar.setVisibility(View.GONE);
        });

    }
}
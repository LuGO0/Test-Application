package com.example.testapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import com.openmrs.android_sdk.library.api.repository.ProviderRepository;
import com.openmrs.android_sdk.library.models.Provider;

import java.util.List;

public class MainViewModel extends ViewModel {

    private LiveData<List<Provider>> providerList;
    private ProviderRepository repository = new ProviderRepository();

    LiveData<List<Provider>> getProviderList() {
        if (providerList == null) {
            providerList = repository.getProviders();
        }
        return providerList;
    }

}
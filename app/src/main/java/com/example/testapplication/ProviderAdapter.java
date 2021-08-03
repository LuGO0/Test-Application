package com.example.testapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.openmrs.android_sdk.library.models.Provider;

import java.util.ArrayList;

public class ProviderAdapter extends ArrayAdapter<Provider> {

        public ProviderAdapter(Context context, ArrayList<Provider> providers) {
            super(context, 0, providers);
        }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Get the data item for this position
        Provider provider = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.provider_list_item, parent, false);
        }
        // Lookup view for data population
        TextView providerName = (TextView) convertView.findViewById(R.id.providerName);
        providerName.setText(provider.getDisplay());

        // Return the completed view to render on screen
        return convertView;

    }
}

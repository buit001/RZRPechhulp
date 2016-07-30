package com.example.tan.rzrpechhulpgo;

import android.graphics.Color;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import java.util.Locale;

/**
 * Created by Tan on 30-7-2016.
 */
public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
    LayoutInflater inflater = null;


    CustomInfoWindowAdapter(LayoutInflater inflater){
        this.inflater = inflater;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        View view = inflater.inflate(R.layout.info_window, null);

        TextView title = (TextView) view.findViewById(R.id.titleInfoWindow);
        TextView snippet = (TextView) view.findViewById(R.id.snippet);
        TextView description = (TextView) view.findViewById(R.id.description);

        title.setText(marker.getTitle());
        title.setTextColor(Color.WHITE);

        snippet.setText(marker.getSnippet());
        snippet.setTextColor(Color.WHITE);

        description.setText(R.string.google_maps_address_window_description);
        description.setTextColor(Color.WHITE);

        return view;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
}

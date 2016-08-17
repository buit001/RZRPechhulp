package com.example.tan.rzrpechhulpgo;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

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

        snippet.setText(marker.getSnippet());

        description.setText(R.string.google_maps_address_window_description);

        return view;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
}

package com.example.tan.rzrpechhulpgo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by Tan on 11-8-2016.
 */
public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //checks gps enabled
        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();
        }
        //check if internet connection can be established
        if (!isOnline()) {
            buildAlertMessageNoConnection();
        }


    }

    public abstract int getLayoutResource();


    @Override
    protected void onResume() {
        super.onResume();
        final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();

            if (!isOnline()) {
                buildAlertMessageNoConnection();
            }
        }
    }


    //checks if internet connection is available
    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    private void buildAlertMessageNoGps() {
        String gpsDisabledMessage = getString(R.string.gps_disabled_popup_message);
        String gpsMessageConfirm = getString(R.string.gps_disabled_popup_message_confirm);
        String gpsMessageDecline = getString(R.string.gps_disabled_popup_message_decline);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(gpsDisabledMessage)
                .setCancelable(false)
                .setPositiveButton(gpsMessageConfirm, new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton(gpsMessageDecline, new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        finish();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    private void buildAlertMessageNoConnection() {
        String internetDisabledMessage = getString(R.string.internet_disabled_popup_message);
        String internetMessageConfirm = getString(R.string.internet_disabled_popup_message_confirm);
        String internetMessageDecline = getString(R.string.internet_disabled_popup_message_decline);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(internetDisabledMessage)
                .setCancelable(false)
                .setPositiveButton(internetMessageConfirm, new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        onResume();
                    }
                })
                .setNegativeButton(internetMessageDecline, new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        finish();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }
}

package com.example.tan.rzrpechhulpgo;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DetailsRZRActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.info_back_button);


        toolbar.setNavigationOnClickListener(   new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_details_rzr;
    }

}

package com.example.tan.rzrpechhulpgo;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DetailsRZRActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setNavigationIcon(R.drawable.menu_arrow);
        toolbar.setTitle(getResources().getString(R.string.back_button_description_details));
        setSupportActionBar(toolbar);

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

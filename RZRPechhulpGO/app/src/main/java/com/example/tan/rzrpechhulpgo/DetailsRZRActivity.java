package com.example.tan.rzrpechhulpgo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import butterknife.BindDrawable;
import butterknife.BindString;

public class DetailsRZRActivity extends BaseActivity {

    @BindDrawable(R.drawable.menu_arrow)
    Drawable backArrow;

    @BindString(R.string.back_button_description_details)
    String backButtonTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        customizeToolbar();
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_details_rzr;
    }

    @Override
    public void customizeToolbar() {
        getSupportActionBar().setTitle(backButtonTitle);
        toolbar.setNavigationIcon(backArrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}

package com.example.tan.rzrpechhulpgo;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import butterknife.BindDrawable;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindDrawable(R.drawable.selector)
    Drawable selector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.rsr_pechhulp_button)
    public void RSRPechhulp(Button rsrPechhulpButton) {
        rsrPechhulpButton.setBackground(selector);
        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
        startActivity(intent);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    public void customizeToolbar() {
        //toolbar code added here
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_info) {
            Intent intent = new Intent(MainActivity.this, DetailsRZRActivity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }


}

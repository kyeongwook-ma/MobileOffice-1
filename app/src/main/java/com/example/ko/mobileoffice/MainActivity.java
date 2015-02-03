package com.example.ko.mobileoffice;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.GridView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.gridView);
        GridAdapter gridAdapter = new GridAdapter(this);
        gridView.setAdapter(gridAdapter);

    }

}

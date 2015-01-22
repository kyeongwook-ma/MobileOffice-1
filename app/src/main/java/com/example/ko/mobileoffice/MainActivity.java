package com.example.ko.mobileoffice;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;

import com.example.ko.mobileoffice.officeposition.Position;
import com.example.ko.mobileoffice.officeposition.PositionInfo;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new GridAdapter(this));

    }
    private static class GridAdapter extends BaseAdapter{


        ArrayList<PositionInfo> items;



        private final Context context;
        public GridAdapter(Context context)
        {
            this.context = context;
            items = new ArrayList<>();
            items.add(new PositionInfo(26, 60, 65, "", false, true, false, true));
            items.add(new PositionInfo(26, 60, 65, "", false, false, false, true));
            items.add(new PositionInfo(26, 60, 65, "Hong Kil Dong", false, false, false, true));
            items.add(new PositionInfo(26, 60, 65, "", false, true, false, true));

            items.add(new PositionInfo(26, 60, 65, "", false, false, true, false));
            items.add(new PositionInfo(26, 60, 65, "", true, false, true, false));
            items.add(new PositionInfo(26, 60, 65, "", false, false, true, false));
            items.add(new PositionInfo(26, 60, 65, "", true, false, true, false));

            items.add(new PositionInfo(26, 60, 65, "", false, false, false, false));
            items.add(new PositionInfo(26, 60, 65, "", false, true, false, false));
            items.add(new PositionInfo(26, 60, 65, "Lee Tak Jin", false, true, false, false));
            items.add(new PositionInfo(26, 60, 65, "", false, false, false, false));

            items.add(new PositionInfo(26, 60, 65, "", false, true, true, false));
            items.add(new PositionInfo(26, 60, 65, "", true, false, true, false));
            items.add(new PositionInfo(26, 60, 65, "", false, false, true, false));
            items.add(new PositionInfo(26, 60, 65, "", true, true, true, false));

        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = LayoutInflater.from(context).inflate(R.layout.position,parent,false);

            ((Position)convertView).apply(getItem(position));
            return convertView;
        }

        @Override
        public PositionInfo getItem(int position) {
            return items.get(position);

        }

        @Override
        public long getItemId(int position) {
            return position;
        }
    }

}

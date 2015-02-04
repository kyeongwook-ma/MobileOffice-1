package com.example.ko.mobileoffice;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.example.ko.mobileoffice.httprest.RestClient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {
    GridAdapter gridAdapter;
    Button sendRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridAdapter = new GridAdapter(this);
        gridView.setAdapter(gridAdapter);

        sendRequest = (Button)findViewById(R.id.send_request);
        sendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*RestClient restClient = new RestClient();
                HttpResponse httpResponse =  restClient.execute();
                HttpEntity responseEntity = httpResponse.getEntity();
                try {
                    String responseString = EntityUtils.toString(responseEntity);

                }
                catch (IOException e)
                {
                    e.printStackTrace();;
                }
*/



            }
        });


    }
    public GridAdapter getGridAdapter()
    {
        return gridAdapter;
    }


}

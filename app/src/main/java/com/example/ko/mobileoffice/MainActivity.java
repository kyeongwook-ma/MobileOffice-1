package com.example.ko.mobileoffice;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.example.ko.mobileoffice.httprest.RestClient;
import com.example.ko.mobileoffice.officeposition.PositionInfo;
import com.example.ko.mobileoffice.xmlparser.OfficeParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.util.Map;


public class MainActivity extends ActionBarActivity {
    GridAdapter gridAdapter;
    Button sendRequest;
    private static MainActivity activityInstance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.activityInstance = this;

        final GridView gridView = (GridView) findViewById(R.id.gridView);
        gridAdapter = new GridAdapter(this);
        gridView.setAdapter(gridAdapter);


        sendRequest = (Button)findViewById(R.id.send_request);
        sendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RestClient restClient = new RestClient();
                HttpResponse httpResponse =  restClient.execute();
                HttpEntity responseEntity = httpResponse.getEntity();
                try {
                    String responseString = EntityUtils.toString(responseEntity);
                    String jsonToXmlResponse = XML.toString(new JSONObject(responseString));
                    OfficeParser officeParser = new OfficeParser(responseString);
                    for(int x=0;x<4;x++)
                        for(int y=0;y<4;y++)
                        {
                            Map<String,String> blockData = officeParser.getBlock(x,y);
                            PositionInfo item = gridAdapter.getItem(y * 4 + x);
                            item.setTemperature(Double.parseDouble(blockData.get("temperature")));
                            item.setBrightness(Double.parseDouble(blockData.get("brightness")));
                            item.setHumidity(Double.parseDouble(blockData.get("humidity")));
                            if(blockData.get("id") != null)
                            {
                                item.setAccupiedName(blockData.get("name"));
                            }
                        }
                    gridAdapter.notifyDataSetChanged();
                }
                /*try{
                    String responseString = EntityUtils.toString(responseEntity);
                    PositionParser positionParser = new PositionParser(responseString);
                    gridAdapter.getItem(positionParser.getCol()+positionParser.getRow()*4).setAccupiedName("reqeustPerson");
                }*/
                catch (IOException e)
                {
                    e.printStackTrace();;
                }
                catch (JSONException e)
                {
                    e.printStackTrace();;
                }
          }
        });
    }

    public static MainActivity getActivityInstance()
    {
        return activityInstance;
    }

    public GridAdapter getGridAdapter()
    {
        return gridAdapter;
    }


}

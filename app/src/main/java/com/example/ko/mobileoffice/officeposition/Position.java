package com.example.ko.mobileoffice.officeposition;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ko.mobileoffice.R;

/**
 * Created by ko on 2015-01-22.
 */
public class Position extends LinearLayout {
    private ImageView[] devices;
    private TextView[] environments;
    private ImageView person;

   public Position(Context context)
   {
       super(context);
       devices = new ImageView[6];
       environments = new TextView[4];
   }
   public Position(Context context, AttributeSet attrs)
   {
       super(context,attrs);
       devices = new ImageView[6];
       environments = new TextView[4];
   }
   public Position(Context context, AttributeSet attrs, int defStyle)
   {
       super(context,attrs,defStyle);
       devices = new ImageView[6];
       environments = new TextView[4];
   }

   @Override
   protected void onFinishInflate(){
       super.onFinishInflate();
       environments[0] = (TextView)findViewById(R.id.temperature);
       environments[1] = (TextView)findViewById(R.id.humidity);
       environments[2] = (TextView)findViewById(R.id.brightness);
       environments[3] = (TextView)findViewById(R.id.name);
       devices[0] = (ImageView)findViewById(R.id.aircondition);
       devices[1] = (ImageView)findViewById(R.id.humidifier);
       devices[2] = (ImageView)findViewById(R.id.light_stand);
       devices[3] = (ImageView)findViewById(R.id.lamp);
       devices[4] = (ImageView)findViewById(R.id.fan);
       devices[5] = (ImageView)findViewById(R.id.blind);
       person = (ImageView)findViewById(R.id.person);
   }

    public void apply(PositionInfo positionInfo){

        environments[0].setText(" Temperature : "+positionInfo.getTemperature());
        environments[1].setText(" Humidity : " +positionInfo.getHumidity());
        environments[2].setText(" Brightness : "+ positionInfo.getBrightness());
        environments[3].setText(" Occupied by : " + positionInfo.getAccupiedName());
        if(!positionInfo.getAccupiedName().equals(""))
            person.setImageResource(R.drawable.person);
        if(positionInfo.getAircondition())
            devices[0].setImageResource(R.drawable.aircondition);
        if(positionInfo.getHumidifier())
            devices[1].setImageResource(R.drawable.humidifier);
        if(positionInfo.getLamp())
            devices[3].setImageResource(R.drawable.lamp);
        if(positionInfo.getWindow())
            devices[5].setImageResource(R.drawable.blind);


        devices[2].setImageResource(R.drawable.light_stand);
        devices[4].setImageResource(R.drawable.fan);

    }


}

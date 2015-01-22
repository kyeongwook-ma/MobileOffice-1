package com.example.ko.mobileoffice.officeposition;

/**
 * Created by ko on 2015-01-22.
 */
public class PositionInfo {
    private int temperature;
    private int humidity;
    private int brightness;
    private String accupiedName;
    private boolean aircondition;
    private boolean humidifier;
    private boolean lamp;
    private boolean window;
    public PositionInfo(int temperature,int humidity,int brigtness,String accupiedName,boolean aircondition,boolean humidifier,boolean lamp,boolean window)
    {
        this.temperature = temperature;
        this.humidity = humidity;
        this.brightness = brigtness;
        this.accupiedName = accupiedName;
        this.aircondition = aircondition;
        this.humidifier = humidifier;
        this.lamp = lamp;
        this.window = window;
    }

    public int getBrightness() {
        return brightness;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getTemperature() {
        return temperature;
    }

    public String getAccupiedName() {
        return accupiedName;
    }
    public boolean getAircondition(){
        return  aircondition;
    }
    public boolean getHumidifier(){
        return humidifier;
    }
    public boolean getLamp(){
        return lamp;
    }
    public boolean getWindow()
    {
        return window;
    }

}

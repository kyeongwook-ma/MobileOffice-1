package com.example.ko.mobileoffice.officeposition;

/**
 * Created by ko on 2015-01-22.
 */
public class PositionInfo {

    private double temperature;
    private double humidity;
    private double brightness;
    private String accupiedName;
    private boolean aircondition;
    private boolean humidifier;
    private boolean lamp;
    private boolean window;
    public PositionInfo(double temperature,double humidity,double brigtness,String accupiedName,boolean aircondition,boolean humidifier,boolean lamp,boolean window)
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

    public double getBrightness() {
        return brightness;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getTemperature() {
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

    public void setAccupiedName(String accupiedName) {
        this.accupiedName = accupiedName;
    }

    public void setAircondition(boolean aircondition) {
        this.aircondition = aircondition;
    }

    public void setBrightness(double brightness) {
        this.brightness = brightness;
    }

    public void setHumidifier(boolean humidifier) {
        this.humidifier = humidifier;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public void setLamp(boolean lamp) {
        this.lamp = lamp;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setWindow(boolean window) {
        this.window = window;
    }

}

package com.testweatherboot2.entity;


import com.testweatherboot2.entity.weather_ent.Current;
import com.testweatherboot2.entity.weather_ent.Hourly;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultWeather {

    private Current current;
    private List<Hourly> hourly;
    private String latAndLon;
    private String measurement;
    private String name;
    private String windDirection;

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public void setNameFromLatAndLon() {
        name = cityList.get(latAndLon);
    }

    public void setWindDirection() {
        int windDeg = current.getWind_deg();
        if(windDeg > 315 && windDeg <= 360 || windDeg >= 0 && windDeg <= 45) windDirection = "north";
        if(windDeg > 45 && windDeg <= 135) windDirection = "eastern";
        if(windDeg > 135 && windDeg <= 225) windDirection = "south";
        if(windDeg > 225 && windDeg <= 315) windDirection = "west";
    }

    public String getWindDirection() {
        return windDirection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Map<String, String> cityList = new HashMap<>();
    {cityList.put("lat=55.75&lon=37.61", "Moscow");
     cityList.put("lat=51.50&lon=-0.11", "London");
     cityList.put("lat=40.73&lon=-73.93", "New York");
     cityList.put("lat=35.65&lon=139.83", "Tokyo");
     cityList.put("lat=45.04&lon=38.98", "Krasnodar");}

    public String getLatAndLon() {
        return latAndLon;
    }

    public void setLatAndLon(String latAndLon) {
        this.latAndLon = latAndLon;
    }

    public Map<String, String> getCityList() {
        return cityList;
    }

    public void setCityList(Map<String, String> cityList) {
        this.cityList = cityList;
    }

    public ResultWeather() {
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public List<Hourly> getHourly() {
        return hourly;
    }

    public void setHourly(List<Hourly> hourly) {
        this.hourly = hourly;
    }
}

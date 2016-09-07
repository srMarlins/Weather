package com.srmarlins.weather.network.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jared on 9/6/2016.
 */

public class WeatherItem {
    private String title;
    private String lat;
    private String Long;
    private String pubDate;
    private List<Forecast> forecast = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLong() {
        return Long;
    }

    public void setLong(String aLong) {
        Long = aLong;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }
}

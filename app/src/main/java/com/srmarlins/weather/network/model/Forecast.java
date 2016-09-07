package com.srmarlins.weather.network.model;

public class Forecast {
    private String date;
    private int code;
    private int high;
    private int low;
    private String forecastConditionIconURL;
    private String text;

    public String getDate() {
        return date;
    }

    protected void setDate(String date) {
        this.date = date;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
        forecastConditionIconURL = "http://l.yimg.com/a/i/us/we/52/" + code + ".gif";
    }

    public int getHigh() {
        return high;
    }

    protected void setHigh(int high) {
        this.high = high;
    }

    public int getLow() {
        return low;
    }

    protected void setLow(int low) {
        this.low = low;
    }

    public String getForecastConditionIconURL() {
        return forecastConditionIconURL;
    }

    public String getText() {
        return text;
    }

    protected void setText(String text) {
        this.text = text;
    }
}
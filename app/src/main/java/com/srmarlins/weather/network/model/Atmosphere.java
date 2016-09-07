package com.srmarlins.weather.network.model;

/**
 * Created by Jared on 9/6/2016.
 */

public class Atmosphere {
    private String humidity;
    private String pressure;
    private String visibility;

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
}

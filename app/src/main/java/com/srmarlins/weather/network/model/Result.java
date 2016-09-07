package com.srmarlins.weather.network.model;

import com.squareup.moshi.Json;

public class Result {
    @Json(name = "channel")
    private WeatherInfo weatherInfo;

    public WeatherInfo getWeatherInfo() {
        return weatherInfo;
    }

    public void setWeatherInfo(WeatherInfo weatherInfo) {
        this.weatherInfo = weatherInfo;
    }
}
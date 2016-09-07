package com.srmarlins.weather.network.model;

import com.squareup.moshi.Json;

/**
 * Created by Jared on 9/6/2016.
 */

public class WeatherResponse {
    private Result results;

    public Result getResults() {
        return results;
    }

    public void setResults(Result results) {
        this.results = results;
    }
}

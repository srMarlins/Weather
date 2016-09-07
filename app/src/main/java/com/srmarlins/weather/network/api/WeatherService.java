package com.srmarlins.weather.network.api;

import com.srmarlins.weather.network.model.WeatherInfo;


import retrofit2.adapter.rxjava.Result;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Jared on 9/6/2016.
 */

public interface WeatherService {
    String WEATHER = "/v1/public/yql";

    @GET(WEATHER)
    Observable<Result<WeatherInfo>> getWeather(@Query("q") String query);
}

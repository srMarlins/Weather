package com.srmarlins.weather.network;

import com.google.android.gms.maps.model.LatLng;
import com.srmarlins.weather.network.api.WeatherService;
import com.srmarlins.weather.network.model.Location;
import com.srmarlins.weather.network.model.WeatherInfo;
import com.srmarlins.weather.network.model.WeatherResponse;
import com.srmarlins.weather.network.model.WeatherResponseWrapper;

import java.util.Observable;

import javax.inject.Inject;

import retrofit2.adapter.rxjava.Result;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Jared on 9/6/2016.
 */

public class WeatherManager {

    WeatherService weatherService;

    @Inject
    public WeatherManager(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public Subscription getWeather(String query, final Subscriber<WeatherInfo> subscriber) {
        return weatherService.getWeather(query, "json")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Result<WeatherResponseWrapper>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Result<WeatherResponseWrapper> weatherResult) {
                        WeatherResponseWrapper wrapper = weatherResult.response().body();
                        if(wrapper == null) {
                            return;
                        }
                        WeatherResponse weatherResponse = wrapper.getQuery();
                        if(weatherResponse == null) {
                            return;
                        }
                        com.srmarlins.weather.network.model.Result result = weatherResponse.getResults();
                        if(result == null) {
                            return;
                        }
                        WeatherInfo weatherInfo = result.getWeatherInfo();
                        subscriber.onNext(weatherInfo);
                    }
                });
    }

    public Subscription getWeather(LatLng latLng, final Subscriber<WeatherInfo> subscriber) {
        String query = "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"(" + latLng.latitude + "," + latLng.longitude + ")\")";
        return getWeather(query, subscriber);
    }

    public Subscription getWeather(Location location, Subscriber<WeatherInfo> subscriber) {
        String query = "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"" + location.getCity() + ", " + location.getRegion() + "\")";
        return getWeather(query, subscriber);
    }
}

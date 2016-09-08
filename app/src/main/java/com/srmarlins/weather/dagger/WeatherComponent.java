package com.srmarlins.weather.dagger;

import com.srmarlins.weather.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {WeatherModule.class})
public interface WeatherComponent {
    void inject(MainActivity mainActivity);
}
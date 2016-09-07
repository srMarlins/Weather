package com.srmarlins.weather.ui;

import android.os.Bundle;

import com.srmarlins.weather.R;
import com.srmarlins.weather.dagger.DaggerWeatherComponent;
import com.srmarlins.weather.dagger.WeatherComponent;
import com.srmarlins.weather.dagger.WeatherModule;
import com.srmarlins.weather.network.api.WeatherService;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    WeatherService weatherService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.activity_main_title));
        initWeatherComponent();
    }

    private WeatherComponent initWeatherComponent() {
        return DaggerWeatherComponent.builder()
                .weatherModule(new WeatherModule(getApplication()))
                .build();
    }
}

package com.srmarlins.weather.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.srmarlins.weather.network.model.WeatherInfo;

/**
 * Created by Jared on 9/6/2016.
 */

public class DetailActivity extends BaseActivity{

    public static final String WEATHER_TAG = "weather_tag";

    public static Intent newIntent(Context context, WeatherInfo weatherInfo) {
        Intent intent =  new Intent(context, DetailActivity.class);
        intent.putExtra(WEATHER_TAG, weatherInfo);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}

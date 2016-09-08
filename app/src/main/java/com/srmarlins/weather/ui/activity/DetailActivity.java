package com.srmarlins.weather.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.srmarlins.weather.R;
import com.srmarlins.weather.network.WeatherConsts;
import com.srmarlins.weather.network.model.Forecast;
import com.srmarlins.weather.network.model.WeatherInfo;
import com.srmarlins.weather.ui.fragment.ForecastBarFragment;

import butterknife.BindView;

/**
 * Created by Jared on 9/6/2016.
 */

public class DetailActivity extends BaseActivity implements ForecastBarFragment.ForecastDetailListener {

    public static final String WEATHER_TAG = "weather_tag";

    @BindView(R.id.textView_high)
    TextView high;
    @BindView(R.id.textView_low)
    TextView low;
    @BindView(R.id.textView_date)
    TextView date;
    @BindView(R.id.textView_desc)
    TextView desc;
    @BindView(R.id.imageView_weather)
    ImageView weatherImage;


    private ForecastBarFragment forecastBarFragment;
    private WeatherInfo weatherInfo;
    private Forecast currentForecast;

    public static Intent newIntent(Context context, WeatherInfo weatherInfo) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(WEATHER_TAG, weatherInfo);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            weatherInfo = extras.getParcelable(WEATHER_TAG);
            currentForecast = weatherInfo.getItem().getForecast().get(0);
            updateViews();
        }

        forecastBarFragment = (ForecastBarFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_bottom);
        if (forecastBarFragment != null && weatherInfo != null) {
            forecastBarFragment.updateForecastDetails(weatherInfo.getItem().getForecast());
            setTitle(weatherInfo.getLocation().getCity());
        }
    }

    @Override
    public void onForecastSelected(Forecast forecast) {
        this.currentForecast = forecast;
        updateViews();
    }

    private void updateViews() {
        high.setText(currentForecast.getHigh() + "\u00B0");
        low.setText(currentForecast.getLow() + "\u00B0");
        Picasso.with(this).load(currentForecast.getForecastConditionIconURL()).into(weatherImage);
        date.setText(currentForecast.getDate());
        desc.setText(WeatherConsts.CONDITIONS[currentForecast.getCode()]);
    }
}

package com.srmarlins.weather.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.srmarlins.weather.R;
import com.srmarlins.weather.dagger.DaggerWeatherComponent;
import com.srmarlins.weather.dagger.WeatherComponent;
import com.srmarlins.weather.dagger.WeatherModule;
import com.srmarlins.weather.network.WeatherManager;
import com.srmarlins.weather.network.model.WeatherInfo;
import com.srmarlins.weather.ui.adapter.WeatherRecyclerAdapter;
import com.srmarlins.weather.util.PlacesUtil;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

public class MainActivity extends BaseActivity {

    @BindView(R.id.recycler_weather_cards)
    RecyclerView recyclerView;

    @Inject
    WeatherManager weatherManager;

    private Observable<View> weatherObservable;
    private WeatherRecyclerAdapter weatherRecyclerAdapter;
    private LinearLayoutManager linearLayoutManager;
    private Subscriber<WeatherInfo> weatherSubscriber;
    private Subscription lastCall;
    private MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.activity_main_title));
        initWeatherComponent().inject(this);
        initCards();
    }

    private void initCards() {
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        weatherRecyclerAdapter = new WeatherRecyclerAdapter();
        recyclerView.setAdapter(weatherRecyclerAdapter);
        weatherSubscriber = new Subscriber<WeatherInfo>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(WeatherInfo weatherInfoResult) {
                weatherRecyclerAdapter.addItem(weatherInfoResult);
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        weatherRecyclerAdapter.notifyItemInserted(0);
                        linearLayoutManager.scrollToPosition(0);
                    }
                });
            }
        };

        weatherObservable = weatherRecyclerAdapter.getPositionClicks();
        weatherObservable.subscribe(new Subscriber<View>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(View view) {
                WeatherInfo info = (WeatherInfo) view.getTag();
                Intent intent = DetailActivity.newIntent(MainActivity.this, info);
                Pair<View, String> p1 = Pair.create(view.findViewById(R.id.weather_image), "weather_image");
                Pair<View, String> p2 = Pair.create(view.findViewById(R.id.textView_weather_type), "weather_text");
                Pair<View, String> p3 = Pair.create(view.findViewById(R.id.textView_degrees), "high");
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, p1, p2, p3);
                startActivity(DetailActivity.newIntent(MainActivity.this, info), optionsCompat.toBundle());
            }
        });
    }

    private WeatherComponent initWeatherComponent() {
        return DaggerWeatherComponent.builder()
                .weatherModule(new WeatherModule(getApplication()))
                .build();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                menuItem = item;
                PlacesUtil.showPlacePicker(this);
                item.setEnabled(false);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PlacesUtil.PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(this, data);
                if (place.getLatLng() != null) {
                    lastCall = weatherManager.getWeather(place.getLatLng(), weatherSubscriber);
                }
            }
            if (menuItem != null) {
                menuItem.setEnabled(true);
            }
        }
    }
}

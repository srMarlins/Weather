package com.srmarlins.weather.dagger;

import android.app.Application;

import com.squareup.moshi.Moshi;
import com.srmarlins.weather.network.api.WeatherService;

import java.io.File;
import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by JaredFowler on 8/11/2016.
 */

@Module
public final class WeatherModule {
    public static final HttpUrl BASE_URL = HttpUrl.parse("https://query.yahooapis.com");
    //50 MB cache
    public static final int CACHE_SIZE = 52428800;

    Application application;

    public WeatherModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    HttpUrl provideBaseUrl() {
        return BASE_URL;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Application application) {
        File cacheDir = new File(application.getCacheDir(), "http");
        Cache cache = new Cache(cacheDir, CACHE_SIZE);
        return new OkHttpClient.Builder()
                .cache(cache)
                .build();
    }

    @Provides
    @Singleton
    Moshi provideMoshi() {
        return new Moshi.Builder().build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(HttpUrl baseUrl, OkHttpClient client, Moshi converter) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create(converter))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    WeatherService provideWeatherService(Retrofit retrofit) {
        return retrofit.create(WeatherService.class);
    }

    @Provides
    @Singleton
    Application provideApplication(){
        return this.application;
    }
}
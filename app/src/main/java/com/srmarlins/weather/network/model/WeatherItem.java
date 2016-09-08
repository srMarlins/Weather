package com.srmarlins.weather.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.squareup.moshi.Json;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jared on 9/6/2016.
 */

public class WeatherItem implements Parcelable {
    public static final Parcelable.Creator<WeatherItem> CREATOR = new Parcelable.Creator<WeatherItem>() {
        @Override
        public WeatherItem createFromParcel(Parcel source) {
            return new WeatherItem(source);
        }

        @Override
        public WeatherItem[] newArray(int size) {
            return new WeatherItem[size];
        }
    };
    private String title;
    private String lat;
    @Json(name = "long")
    private String lon;
    private String pubDate;
    private Condition condition;
    private List<Forecast> forecast = new ArrayList<>();

    public WeatherItem() {
    }

    protected WeatherItem(Parcel in) {
        this.title = in.readString();
        this.lat = in.readString();
        this.lon = in.readString();
        this.pubDate = in.readString();
        this.condition = in.readParcelable(Condition.class.getClassLoader());
        this.forecast = in.createTypedArrayList(Forecast.CREATOR);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.lat);
        dest.writeString(this.lon);
        dest.writeString(this.pubDate);
        dest.writeParcelable(this.condition, flags);
        dest.writeTypedList(this.forecast);
    }
}

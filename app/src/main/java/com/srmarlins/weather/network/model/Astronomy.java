package com.srmarlins.weather.network.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jared on 9/6/2016.
 */

public class Astronomy implements Parcelable {
    public static final Parcelable.Creator<Astronomy> CREATOR = new Parcelable.Creator<Astronomy>() {
        @Override
        public Astronomy createFromParcel(Parcel source) {
            return new Astronomy(source);
        }

        @Override
        public Astronomy[] newArray(int size) {
            return new Astronomy[size];
        }
    };
    private String sunset;
    private String sunrise;

    public Astronomy() {
    }

    protected Astronomy(Parcel in) {
        this.sunset = in.readString();
        this.sunrise = in.readString();
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.sunset);
        dest.writeString(this.sunrise);
    }
}

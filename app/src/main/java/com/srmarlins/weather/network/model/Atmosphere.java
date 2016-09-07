package com.srmarlins.weather.network.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jared on 9/6/2016.
 */

public class Atmosphere implements Parcelable {
    private String humidity;
    private String pressure;
    private String visibility;

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.humidity);
        dest.writeString(this.pressure);
        dest.writeString(this.visibility);
    }

    public Atmosphere() {
    }

    protected Atmosphere(Parcel in) {
        this.humidity = in.readString();
        this.pressure = in.readString();
        this.visibility = in.readString();
    }

    public static final Parcelable.Creator<Atmosphere> CREATOR = new Parcelable.Creator<Atmosphere>() {
        @Override
        public Atmosphere createFromParcel(Parcel source) {
            return new Atmosphere(source);
        }

        @Override
        public Atmosphere[] newArray(int size) {
            return new Atmosphere[size];
        }
    };
}

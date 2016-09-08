package com.srmarlins.weather.network.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jared on 9/6/2016.
 */

public class Location implements Parcelable {
    public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel source) {
            return new Location(source);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };
    private String city;
    private String country;
    private String region;

    public Location() {
    }

    protected Location(Parcel in) {
        this.city = in.readString();
        this.country = in.readString();
        this.region = in.readString();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.city);
        dest.writeString(this.country);
        dest.writeString(this.region);
    }
}

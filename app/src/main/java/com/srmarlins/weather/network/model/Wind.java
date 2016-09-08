package com.srmarlins.weather.network.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jared on 9/6/2016.
 */

public class Wind implements Parcelable {

    public static final Parcelable.Creator<Wind> CREATOR = new Parcelable.Creator<Wind>() {
        @Override
        public Wind createFromParcel(Parcel source) {
            return new Wind(source);
        }

        @Override
        public Wind[] newArray(int size) {
            return new Wind[size];
        }
    };
    private String chill;
    private String direction;
    private String speed;

    public Wind() {
    }

    protected Wind(Parcel in) {
        this.chill = in.readString();
        this.direction = in.readString();
        this.speed = in.readString();
    }

    public String getChill() {
        return chill;
    }

    public void setChill(String chill) {
        this.chill = chill;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.chill);
        dest.writeString(this.direction);
        dest.writeString(this.speed);
    }
}

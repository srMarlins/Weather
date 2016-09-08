package com.srmarlins.weather.network.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jared on 9/6/2016.
 */

public class Condition implements Parcelable {
    public static final Parcelable.Creator<Condition> CREATOR = new Parcelable.Creator<Condition>() {
        @Override
        public Condition createFromParcel(Parcel source) {
            return new Condition(source);
        }

        @Override
        public Condition[] newArray(int size) {
            return new Condition[size];
        }
    };
    private String code;
    private String date;
    private String temp;
    private String text;

    public Condition() {
    }

    protected Condition(Parcel in) {
        this.code = in.readString();
        this.date = in.readString();
        this.temp = in.readString();
        this.text = in.readString();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.code);
        dest.writeString(this.date);
        dest.writeString(this.temp);
        dest.writeString(this.text);
    }
}

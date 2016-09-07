package com.srmarlins.weather.network.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Forecast implements Parcelable {
    private String date;
    private int code;
    private int high;
    private int low;
    private String forecastConditionIconURL;
    private String text;

    public String getDate() {
        return date;
    }

    protected void setDate(String date) {
        this.date = date;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
        forecastConditionIconURL = "http://l.yimg.com/a/i/us/we/52/" + code + ".gif";
    }

    public int getHigh() {
        return high;
    }

    protected void setHigh(int high) {
        this.high = high;
    }

    public int getLow() {
        return low;
    }

    protected void setLow(int low) {
        this.low = low;
    }

    public String getForecastConditionIconURL() {
        return forecastConditionIconURL;
    }

    public String getText() {
        return text;
    }

    protected void setText(String text) {
        this.text = text;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.date);
        dest.writeInt(this.code);
        dest.writeInt(this.high);
        dest.writeInt(this.low);
        dest.writeString(this.forecastConditionIconURL);
        dest.writeString(this.text);
    }

    public Forecast() {
    }

    protected Forecast(Parcel in) {
        this.date = in.readString();
        this.code = in.readInt();
        this.high = in.readInt();
        this.low = in.readInt();
        this.forecastConditionIconURL = in.readString();
        this.text = in.readString();
    }

    public static final Parcelable.Creator<Forecast> CREATOR = new Parcelable.Creator<Forecast>() {
        @Override
        public Forecast createFromParcel(Parcel source) {
            return new Forecast(source);
        }

        @Override
        public Forecast[] newArray(int size) {
            return new Forecast[size];
        }
    };
}
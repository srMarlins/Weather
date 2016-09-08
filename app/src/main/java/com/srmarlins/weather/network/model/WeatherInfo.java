package com.srmarlins.weather.network.model;


import android.os.Parcel;
import android.os.Parcelable;

public class WeatherInfo implements Parcelable {

    public static final Parcelable.Creator<WeatherInfo> CREATOR = new Parcelable.Creator<WeatherInfo>() {
        @Override
        public WeatherInfo createFromParcel(Parcel source) {
            return new WeatherInfo(source);
        }

        @Override
        public WeatherInfo[] newArray(int size) {
            return new WeatherInfo[size];
        }
    };
    private String title;
    private String description;
    private String language;
    private String lastBuildDate;
    private Location location;
    private Wind wind;
    private Atmosphere atmosphere;
    private Astronomy astronomy;
    private WeatherItem item;

    public WeatherInfo() {
    }

    protected WeatherInfo(Parcel in) {
        this.title = in.readString();
        this.description = in.readString();
        this.language = in.readString();
        this.lastBuildDate = in.readString();
        this.location = in.readParcelable(Location.class.getClassLoader());
        this.wind = in.readParcelable(Wind.class.getClassLoader());
        this.atmosphere = in.readParcelable(Atmosphere.class.getClassLoader());
        this.astronomy = in.readParcelable(Astronomy.class.getClassLoader());
        this.item = in.readParcelable(WeatherItem.class.getClassLoader());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    public Astronomy getAstronomy() {
        return astronomy;
    }

    public void setAstronomy(Astronomy astronomy) {
        this.astronomy = astronomy;
    }

    public WeatherItem getItem() {
        return item;
    }

    public void setItem(WeatherItem item) {
        this.item = item;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.language);
        dest.writeString(this.lastBuildDate);
        dest.writeParcelable(this.location, flags);
        dest.writeParcelable(this.wind, flags);
        dest.writeParcelable(this.atmosphere, flags);
        dest.writeParcelable(this.astronomy, flags);
        dest.writeParcelable(this.item, flags);
    }
}
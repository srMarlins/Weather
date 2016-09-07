package com.srmarlins.weather.network.model;

import android.graphics.Bitmap;
import android.location.Address;

import java.util.ArrayList;
import java.util.List;

public class WeatherInfo {

	private String title;
	private String description;
	private String language;
	private String lastBuildDate;
	private String locationCity;
	private String locationRegion;
	private String locationCountry;
	private String windChill;
	private String windDirection;
	private String windSpeed = "";
	private String atmosphereHumidity = "";
	private String atmosphereVisibility = "";
	private String atmospherePressure = "";
	private String atmosphereRising = "";
	private String astronomySunrise = "";
	private String astronomySunset = "";
	private String conditionTitle = "";
	private String conditionLat = "";
	private String conditionLon = "";
	private int currentCode = 0;
	private String currentText = "";
	private int currentTemp = 0;
	private String currentConditionIconURL = "";
	private Bitmap currentConditionIcon = null;
	private String currentConditionDate = "";
	private List<Forecast> forecastList = new ArrayList<>();
	private Address address = null;
	
	public WeatherInfo() {
		
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

	public String getLocationCity() {
		return locationCity;
	}

	public void setLocationCity(String locationCity) {
		this.locationCity = locationCity;
	}

	public String getLocationRegion() {
		return locationRegion;
	}

	public void setLocationRegion(String locationRegion) {
		this.locationRegion = locationRegion;
	}

	public String getLocationCountry() {
		return locationCountry;
	}

	public void setLocationCountry(String locationCountry) {
		this.locationCountry = locationCountry;
	}

	public String getWindChill() {
		return windChill;
	}

	public void setWindChill(String windChill) {
		this.windChill = windChill;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	public String getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}

	public String getAtmosphereHumidity() {
		return atmosphereHumidity;
	}

	public void setAtmosphereHumidity(String atmosphereHumidity) {
		this.atmosphereHumidity = atmosphereHumidity;
	}

	public String getAtmosphereVisibility() {
		return atmosphereVisibility;
	}

	public void setAtmosphereVisibility(String atmosphereVisibility) {
		this.atmosphereVisibility = atmosphereVisibility;
	}

	public String getAtmospherePressure() {
		return atmospherePressure;
	}

	public void setAtmospherePressure(String atmospherePressure) {
		this.atmospherePressure = atmospherePressure;
	}

	public String getAtmosphereRising() {
		return atmosphereRising;
	}

	public void setAtmosphereRising(String atmosphereRising) {
		this.atmosphereRising = atmosphereRising;
	}

	public String getAstronomySunrise() {
		return astronomySunrise;
	}

	public void setAstronomySunrise(String astronomySunrise) {
		this.astronomySunrise = astronomySunrise;
	}

	public String getAstronomySunset() {
		return astronomySunset;
	}

	public void setAstronomySunset(String astronomySunset) {
		this.astronomySunset = astronomySunset;
	}

	public String getConditionTitle() {
		return conditionTitle;
	}

	public void setConditionTitle(String conditionTitle) {
		this.conditionTitle = conditionTitle;
	}

	public String getConditionLat() {
		return conditionLat;
	}

	public void setConditionLat(String conditionLat) {
		this.conditionLat = conditionLat;
	}

	public String getConditionLon() {
		return conditionLon;
	}

	public void setConditionLon(String conditionLon) {
		this.conditionLon = conditionLon;
	}

	public int getCurrentCode() {
		return currentCode;
	}

	public void setCurrentCode(int currentCode) {
		currentCode = currentCode;
		currentConditionIconURL = "http://l.yimg.com/a/i/us/we/52/" + currentCode + ".gif";
	}

	public String getCurrentText() {
		return currentText;
	}

	public void setCurrentText(String currentText) {
		this.currentText = currentText;
	}

	public int getCurrentTemp() {
		return currentTemp;
	}

	public void setCurrentTemp(int currentTemp) {
		this.currentTemp = currentTemp;
	}

	public String getCurrentConditionIconURL() {
		return currentConditionIconURL;
	}

	public void setCurrentConditionIconURL(String currentConditionIconURL) {
		this.currentConditionIconURL = currentConditionIconURL;
	}

	public Bitmap getCurrentConditionIcon() {
		return currentConditionIcon;
	}

	public void setCurrentConditionIcon(Bitmap currentConditionIcon) {
		this.currentConditionIcon = currentConditionIcon;
	}

	public String getCurrentConditionDate() {
		return currentConditionDate;
	}

	public void setCurrentConditionDate(String currentConditionDate) {
		this.currentConditionDate = currentConditionDate;
	}

	public List<Forecast> getForecastList() {
		return forecastList;
	}

	public void setForecastList(List<Forecast> forecastList) {
		this.forecastList = forecastList;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


}
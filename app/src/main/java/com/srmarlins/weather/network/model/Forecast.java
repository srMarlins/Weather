package com.srmarlins.weather.network.model;

import android.graphics.Bitmap;

public class Forecast {
	private String forecastDay;
		private String forecastDate;
		private int forecastCode;
		private int forecastTempHigh;
		private int forecastTempLow;
		private String forecastConditionIconURL;
		private Bitmap forecastConditionIcon;
		private String forecastText;

		public Bitmap getForecastConditionIcon() {
			return forecastConditionIcon;
		}

		protected void setForecastConditionIcon(Bitmap forecastConditionIcon) {
			this.forecastConditionIcon = forecastConditionIcon;
		}

		public String getForecastDay() {
			return forecastDay;
		}

		protected void setForecastDay(String forecastDay) {
			this.forecastDay = forecastDay;
		}

		public String getForecastDate() {
			return forecastDate;
		}

		protected void setForecastDate(String forecastDate) {
			this.forecastDate = forecastDate;
		}

		public int getForecastCode() {
			return forecastCode;
		}

		protected void setForecastCode(int forecastCode) {
			this.forecastCode = forecastCode;
			forecastConditionIconURL = "http://l.yimg.com/a/i/us/we/52/" + forecastCode + ".gif";
		}

		public int getForecastTempHigh() {
			return forecastTempHigh;
		}

		protected void setForecastTempHigh(int forecastTempHigh) {
			this.forecastTempHigh = forecastTempHigh;
		}

		public int getForecastTempLow() {
			return forecastTempLow;
		}

		protected void setForecastTempLow(int forecastTempLow) {
			this.forecastTempLow = forecastTempLow;
		}

		public String getForecastConditionIconURL() {
			return forecastConditionIconURL;
		}

		public String getForecastText() {
			return forecastText;
		}

		protected void setForecastText(String forecastText) {
			this.forecastText = forecastText;
		}
		
	}
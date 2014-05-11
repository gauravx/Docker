package com.example.docker;

public class XMLDataCollected {

	float maxt=0,mint=0,windspeed=0,hum=0;
	String windtype;
	String view;
	public void setMaxT(float tempmax) {
		maxt = tempmax;
		
	}

	public void setWindSpeed(float windsp) {
		windspeed=windsp;
		
	}

	public void setWindType(String t) {
		windtype = t;
		
	}


	public void setHumidity(float humid) {
		hum = humid;
	}

	
	
	public String MaxT() {
		
		float maxtocel=maxt-273;
		return ((int) maxtocel + "C") ;
	}

	public String windSpeed() {
		
		return (windspeed+"m/s");
	}

	public String windtype() {
		
		return (windtype);
	}

	public String humid() {
		
		return (hum+"%");
	}

	public String weatherview() {
		
		return (view);
	}

	public void setWeather_view(String t) {
		view=t;
		
	}





}

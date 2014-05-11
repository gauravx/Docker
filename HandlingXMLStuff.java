package com.example.docker;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class HandlingXMLStuff extends DefaultHandler {
	 
	XMLDataCollected info = new XMLDataCollected();
	
	public String getMaxT() {
		
		return info.MaxT();
	}
	public String getWindSpeed() {
		
		return info.windSpeed();
	}

	public String getWindType() {
		
		return info.windtype();
	}

	public String getHumidity() {
		
		return info.humid();
	}
	public String getWeatherView() {
	
		return info.weatherview();
	}


	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if(localName.equals("temperature"))
		{
			String t = attributes.getValue("value");
			float temp = Float.parseFloat(t);
			info.setMaxT(temp);
		}
		if(localName.equals("speed"))
		{
			String t = attributes.getValue("value");
			float windsp = Float.parseFloat(t);
			info.setWindSpeed(windsp);
		}
		if(localName.equals("speed"))
		{
			String t = attributes.getValue("name");
			info.setWindType(t);
		}
		if(localName.equals("humidity"))
		{
			String t = attributes.getValue("value");
			float humid = Float.parseFloat(t);
			info.setHumidity(humid);
		}
		if(localName.equals("clouds"))
		{
			String t = attributes.getValue("name");
		
			info.setWeather_view(t);
		}
		
	}
	
	


}

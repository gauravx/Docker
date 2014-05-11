package com.example.docker;




import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;




import android.app.Activity;
import android.app.ProgressDialog;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.format.Time;

import android.widget.AnalogClock;
import android.widget.ImageView;
import android.widget.TextView;


public class FullscreenActivity extends Activity {
	 	 
		static String fullURL="http://api.openweathermap.org/data/2.5/weather?q=pune&mode=xml";
		
	
		TextView cal_1,cal_2,cal_3,cal_4,cal_5;
		TextView month,day;
		TextView city,country,windspeed,windtype,humidity,maxtemp;
		ImageView weather_type;
		AnalogClock ag;
		
		
		
		
		@Override
	 	protected void onCreate(Bundle savedInstanceState) {
	 		super.onCreate(savedInstanceState);
	 		setContentView(R.layout.activity_fullscreen);
	 		initialize();
	 		changetypeface();
	 		getdate();
	 		new LoadData().execute(new String[] { fullURL });
	 		
	 	}

		
		class LoadData extends AsyncTask<String, Void, String>
		{
			private ProgressDialog dialog = new ProgressDialog(FullscreenActivity.this);
			
			String wind_speed= null;
			String wind_type = null;
			String weather_view=null;
			String maxt= null;
			String humid=null;
			protected String doInBackground(String ...urls )
			{
				try
				{	
					getXmlFromUrl();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				return null;
			}
			
			
			
			@Override
			protected void onProgressUpdate(Void... values) {
				// TODO Auto-generated method stub
				super.onProgressUpdate(values);
			}

			@Override
			protected void onPreExecute() {
				this.dialog.setMessage("Loading");
				this.dialog.show();
			}
			
			@Override
			protected void onPostExecute(String result) {
				
				
			   dialog.dismiss();
			   
			   windspeed.setText(wind_speed);
				maxtemp.setText(maxt);
				humidity.setText(humid);
				windtype.setText(wind_type);
				
				if(weather_view.equals("overcast clouds"))
				{
					
					weather_type.setImageDrawable(getResources().getDrawable(R.drawable.sunny));
				}
			}
			
			private void getXmlFromUrl()
			{
				try
				{
					URL website = new URL(fullURL);
					SAXParserFactory spf = SAXParserFactory.newInstance();
					SAXParser sp = spf.newSAXParser();
					XMLReader xr = sp.getXMLReader();
					HandlingXMLStuff doingwork = new HandlingXMLStuff();
					xr.setContentHandler(doingwork);
					xr.parse(new InputSource(website.openStream()));
					maxt=doingwork.getMaxT();
					wind_speed=doingwork.getWindSpeed();
					wind_type=doingwork.getWindType();
					humid=doingwork.getHumidity();
					weather_view=doingwork.getWeatherView();
				}catch(Exception e)
				{
					maxt="Content Error";
					
				}
			
			
			
				
			}
		}
		
		
		private void getdate() {
		
			Calendar cal=Calendar.getInstance();
			int dd = cal.get(Calendar.DAY_OF_MONTH);
			cal_1.setText(""+dd);
			
			SimpleDateFormat month_date = new SimpleDateFormat("MMMMMMMMM"); //month eg January
			month.setText(month_date.format(cal.getTime()));
			SimpleDateFormat sdf = new SimpleDateFormat("EEEE"); //day eg Monday
			Date d = new Date();
			day.setText(sdf.format(d));
		
		}


		private void changetypeface() {
			Typeface font_light = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Light.ttf");
			Typeface font_regular = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Regular.ttf");
			Typeface font_thin = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Thin.ttf");
			
			cal_1.setTypeface(font_thin);
			cal_2.setTypeface(font_thin);
			cal_3.setTypeface(font_thin);
			cal_4.setTypeface(font_thin);
			cal_5.setTypeface(font_thin);
			
			month.setTypeface(font_light);
			day.setTypeface(font_thin);
			
			
			city.setTypeface(font_light);
			country.setTypeface(font_regular);
			windspeed.setTypeface(font_thin);
			windtype.setTypeface(font_thin);
			humidity.setTypeface(font_thin);
		
			maxtemp.setTypeface(font_light);
		}

		private void initialize() {
			cal_1 = (TextView) findViewById(R.id.tv_cal_1);
			cal_2 = (TextView) findViewById(R.id.tv_cal_2);
			cal_3 = (TextView) findViewById(R.id.tv_cal_3);
			cal_4 = (TextView) findViewById(R.id.tv_cal_4);
			cal_5 = (TextView) findViewById(R.id.tv_cal_5);
			month = (TextView) findViewById(R.id.tv_month);
			day = (TextView) findViewById(R.id.tv_day);
			
			ag = (AnalogClock) findViewById(R.id.analogClock);
			city = (TextView) findViewById(R.id.tv_location_city);
			country = (TextView) findViewById(R.id.tv_location_country);
			windspeed = (TextView) findViewById(R.id.tv_wind_speed);
			windtype= (TextView) findViewById(R.id.tv_wind_type);
			humidity = (TextView) findViewById(R.id.tv_humudity);
			
			maxtemp=(TextView) findViewById(R.id.tv_max_temp);
			
			weather_type=(ImageView) findViewById(R.id.iv_weather_type);
		}
	
	
	
}

package com.example.longitudewatch;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.location.*;
import android.content.*;
import android.util.Log;
import android.widget.TextView;

public class Clock extends Activity implements LocationListener{
	LocationManager locmanG;
	LocationManager locmanN;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_clock);
		Button timerButton=(Button)findViewById(R.id.timer);
		timerButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(Clock.this,Timer.class);
				startActivity(intent);
			}
		});
		Button stopwatchButton=(Button)findViewById(R.id.stopwatch);
		stopwatchButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(Clock.this,StopWatch.class);
				startActivity(intent);
			}
		});
		Button worldclockButton=(Button)findViewById(R.id.worldclock);
		worldclockButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(Clock.this,WorldClock.class);
				startActivity(intent);
			}
		});
		locmanG =(LocationManager)getSystemService(Context.LOCATION_SERVICE);
		locmanN =(LocationManager)getSystemService(Context.LOCATION_SERVICE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.clock, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onResume() {

		super.onResume();
	}

	@Override
	protected void onPause() {
		if (locmanG != null) {
			locmanG.removeUpdates(this);
		}
		if (locmanN != null) {
			locmanN.removeUpdates(this);
		}
		super.onPause();
	}

	@Override
	public void onLocationChanged(Location location) {
		if (location.getProvider().equals(LocationManager.GPS_PROVIDER) == true) {
			TextView textView3 = (TextView) findViewById(R.id.ClockText);
			textView3.setText("GPS Latitude:Longitude - "
					+ String.valueOf(location.getLatitude()) + ":"
					+ String.valueOf(location.getLongitude()));
		}


			Log.v("----------", "----------");
			Log.v("Latitude", String.valueOf(location.getLatitude()));
			Log.v("Longitude", String.valueOf(location.getLongitude()));
			Log.v("Accuracy", String.valueOf(location.getAccuracy()));
			Log.v("Altitude", String.valueOf(location.getAltitude()));
			Log.v("Time", String.valueOf(location.getTime()));
			Log.v("Speed", String.valueOf(location.getSpeed()));
			Log.v("Bearing", String.valueOf(location.getBearing()));
		}
	

	@Override
	public void onProviderDisabled(String provider) {
	}

	@Override
	public void onProviderEnabled(String provider) {
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		switch (status) {
		case LocationProvider.AVAILABLE:
			Log.v("Status", "AVAILABLE");
			break;
		case LocationProvider.OUT_OF_SERVICE:
			Log.v("Status", "OUT_OF_SERVICE");
			break;
		case LocationProvider.TEMPORARILY_UNAVAILABLE:
			Log.v("Status", "TEMPORARILY_UNAVAILABLE");
			break;
		}
	}
}



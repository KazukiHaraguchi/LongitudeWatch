package com.example.longitudewatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Timer extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timer);
		Button clockButton=(Button)findViewById(R.id.clock);
		clockButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(Timer.this,Clock.class);
				startActivity(intent);
			}
		});
		Button stopwatchButton=(Button)findViewById(R.id.stopwatch);
		stopwatchButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(Timer.this,StopWatch.class);
				startActivity(intent);
			}
		});
		Button worldclockButton=(Button)findViewById(R.id.worldclock);
		worldclockButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(Timer.this,WorldClock.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.timer, menu);
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
}

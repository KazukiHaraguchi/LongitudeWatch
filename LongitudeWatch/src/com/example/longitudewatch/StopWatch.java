package com.example.longitudewatch;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;

public class StopWatch extends Activity {
	private boolean cout = false;
	private Button startButton, stopButton;
	private TextView timerText;

	private Timer timer;
	private Handler handler = new Handler();
	private long count = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stop_watch);

		startButton = (Button)findViewById(R.id.start);
		stopButton = (Button)findViewById(R.id.stop);

		timerText = (TextView)findViewById(R.id.ClockText);
		timerText.setText("00:00.0");

		startButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (null != timer) {
					timer.cancel();
					timer = null;
				}

				// Timer インスタンスを生成
				timer = new Timer();

				// カウンター
				count = 0;
				timerText.setText("00:00.0");

				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						// handlerdを使って処理をキューイングする
						handler.post(new Runnable() {
							public void run() {
								count++;
								long mm = count * 100 / 1000 / 60;
								long ss = count * 100 / 1000 % 60;
								long ms = (count * 100 - ss * 1000 - mm * 1000 * 60) / 100;
								timerText.setText(String.format("%1$02d:%2$02d.%3$01d", mm, ss, ms));
							}
						});
					}
				}, 0, 100);
			}
		});


		stopButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(cout == true){
					if (null != timer) {
						// Cancel
						timer.cancel();
						timer = null;
						timerText.setText("00:00.0");
						cout = true;
					}
				}else{
					

				}
			}
		});


		Button clockButton=(Button)findViewById(R.id.clock);
		clockButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(StopWatch.this,Clock.class);
				startActivity(intent);
			}
		});
		Button timerButton=(Button)findViewById(R.id.timer);
		timerButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(StopWatch.this,com.example.longitudewatch.Timer.class);
				startActivity(intent);
			}
		});
		Button worldclockButton=(Button)findViewById(R.id.worldclock);
		worldclockButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(StopWatch.this,WorldClock.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stop_watch, menu);
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

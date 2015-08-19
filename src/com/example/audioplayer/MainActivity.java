package com.example.audioplayer;

import java.io.IOException;

import android.app.Fragment;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	
	TextView title;
	Button play, stop;
	String urlArquivo = "http://cast.onepieceex.com.br/opexcast_37_-_conveses_do_mundo.mp3";
	MediaPlayer media;
	boolean isPlaying = false;
	Fragment fragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		play = (Button)findViewById(R.id.play);
		stop = (Button)findViewById(R.id.stop);
		
	}
	
	public void play(View view){
		if(!isPlaying){
			isPlaying = true;
			
			media = new MediaPlayer();
			media.setAudioStreamType(AudioManager.STREAM_MUSIC);
			
			try {
				media.setDataSource(urlArquivo);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				try {
					media.prepare();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};

			
				
			media.start();
		}
	}
	
	public void stop(View view){
		if(isPlaying){
			isPlaying = false;
			media.stop();
		}
	}
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}
}

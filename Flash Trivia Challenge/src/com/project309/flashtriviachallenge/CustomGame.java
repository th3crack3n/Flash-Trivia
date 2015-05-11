package com.project309.flashtriviachallenge;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import interfaces.GetQuestions;

public class CustomGame extends Activity {

	Button sports, music, movies, technology, geography, history;
	static int playerpointer = 1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_game);
		addListenerOnButton();
	}
	public void addListenerOnButton() {
	   	 
		final Context context = this;
 
		sports = (Button) findViewById(R.id.Sports);
		music = (Button) findViewById(R.id.Music);
		movies = (Button) findViewById(R.id.Movies);
		technology = (Button) findViewById(R.id.Technology);
		geography = (Button) findViewById(R.id.Geography);
		history = (Button) findViewById(R.id.History);
		
		sports.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
 
			    Intent intent = new Intent(context, Gaming.class);
                GetQuestions.GAME_TYPE = 1;
			    startActivity(intent);
			    finish();
 
			}
 
		});
		
		music.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
 
			    Intent intent = new Intent(context, Gaming.class);
			    GetQuestions.GAME_TYPE = 2;
			    startActivity(intent);
			    finish();
 
			}
 
		});

		movies.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
		
			    Intent intent = new Intent(context, Gaming.class);
			    GetQuestions.GAME_TYPE = 3;
			    startActivity(intent);
			    finish();
		
			}
		
		});
		
		technology.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
		
			    Intent intent = new Intent(context, Gaming.class);
			    GetQuestions.GAME_TYPE = 4;
			    startActivity(intent); 
			    finish();
		
			}
		
		});
		
		geography.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
		
			    Intent intent = new Intent(context, Gaming.class);
			    GetQuestions.GAME_TYPE = 5;
			    startActivity(intent); 
			    finish();
		
			}
		
		});
		
		history.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
		
			    Intent intent = new Intent(context, Gaming.class);
			    GetQuestions.GAME_TYPE = 6;
			    startActivity(intent); 
			    finish();
		
			}
		
		});

	}
}

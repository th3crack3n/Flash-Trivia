package com.project309.flashtriviachallenge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import interfaces.GetQuestions;

public class HomeScreen extends Activity {

	Button button1,button2,button3,button4,button5,button6;
	
    @Override
    public void onCreate(Bundle savedInstanceState) { 
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        addListenerOnButton();
  /*      
        new Handler().postDelayed(new Runnbable()
        {
        	@Override
        	public void run()
        	{
        		Intent mainIntent = new Intent(SplashScreen.this, AndroidNews.class);
        		SplashScreen.this.startActivity(mainIntent);
        		SplashScreen.this.finish();
        		
        		overridePendingTransition(R.anim.mainfadein,R.anim.splashfadeout);
        	}
        },3000);
        */
        
       
        
    }
    
    public void addListenerOnButton() {
    	 
		final Context context = this;
 
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		button4 = (Button) findViewById(R.id.button4);
		button5 = (Button) findViewById(R.id.button5);
		button6 = (Button) findViewById(R.id.button6);
 
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
 
			    Intent intent = new Intent(context, MyProfile.class);
                startActivity(intent);   
                
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
			}
 
		});
		
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
 
			    Intent intent = new Intent(context, UsersList.class);
                startActivity(intent);   
                
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
			}
 
		});
		
		button3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
 
			    Intent intent = new Intent(context, CustomGame.class);
                startActivity(intent);   
                
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
			}
 
		});
		
		button4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
 
			    Intent intent = new Intent(context, Gaming.class);
                GetQuestions.GAME_TYPE = 0;
			    startActivity(intent);   
                finish();
                
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
			}
 
		});
		
		button5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
 
			    Intent intent = new Intent(context, HighScores.class);
                startActivity(intent);   
                
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
			}
 
		});
		
		button6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
 
			    Intent intent = new Intent(context, Info.class);
                startActivity(intent);
                
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
			}
 
		});
    }
}
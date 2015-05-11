package com.project309.flashtriviachallenge;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import network.*;


@TargetApi(16)
public class ScoreScreen extends Activity {

	Button goHome, newGame;
	TextView daily, weekly;
	SetHighScore scoreSet,scoreSend,scoreGet;
	MacParser mParse;
	ImageView image;
	int userid = 0, weekHighScore = 0;
	
	/** Called when the activity is first created. */
	@TargetApi(16)
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.activity_score_screen);
	    TextView score = (TextView) findViewById(R.id.score);
	    score.setText(Gaming.score + "");
	    
	    image = (ImageView) findViewById(R.id.score_pic);
	    if(Gaming.score >= 15 )
		{
	    	image.getDrawable().setLevel(20);

		}
		else if(Gaming.score > 5)
		{
			image.getDrawable().setLevel(10);
		}
		else if(Gaming.score <= 5)
		{
			image.getDrawable().setLevel(2);
		}
		else
		{
		}
	    
	    
	    mParse = new MacParser(getMacFromDevice(), false, null, null, true, false);
		mParse.execute("GET /profiles.xml");
		userid = mParse.matchID + 1;
		scoreGet = new SetHighScore();
		scoreGet.execute("GET /scores/" + (mParse.matchID + 7) + ".xml");
	    
		weekHighScore = scoreGet.weekly;
		
		sendScores();
	    
	    addListenerOnButton();
	}

	public void sendScores(){
		if(Gaming.score > weekHighScore){
			scoreSend = new SetHighScore();
		    scoreSend.execute("GET /scores/us/" + (mParse.matchID + 7) + "/" + Gaming.score + "/" + Gaming.score);
		}
		else if(Gaming.score > scoreGet.daily){
			scoreSend = new SetHighScore();
		    scoreSend.execute("GET /scores/us/" + (mParse.matchID + 7) + "/" + Gaming.score + "/" + weekHighScore);
		}
	}
	
	public void addListenerOnButton() {
	   	 
		final Context context = this;
		goHome = (Button) findViewById(R.id.goHome);
		newGame = (Button) findViewById(R.id.gotoCustom);
		Gaming.score = 0;
		goHome.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
			    Intent intent = new Intent(context, HomeScreen.class);
                startActivity(intent);   
                finish();
			}
 
		});
		newGame.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			    Intent intent = new Intent(context, CustomGame.class);
                startActivity(intent);
                finish(); 
			}
 
		});
	}
	
	private String getMacFromDevice(){
		WifiManager wifiMan = (WifiManager) this.getSystemService(
                Context.WIFI_SERVICE);
		WifiInfo wifiInf = wifiMan.getConnectionInfo();
		return wifiInf.getMacAddress();
	}
	
	@Override
	public void onBackPressed() {
	
	}

}

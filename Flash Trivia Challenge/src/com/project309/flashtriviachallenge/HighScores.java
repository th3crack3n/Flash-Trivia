package com.project309.flashtriviachallenge;

import network.*;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HighScores extends Activity {

	Button button;

	
	public void onCreate(Bundle savedInstanceState) {
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_high_scores);
		
		
		final HighScoreParser Top1 = new HighScoreParser((TextView)findViewById(R.id.Top_ids),
				 										 (TextView)findViewById(R.id.Top_D_scores),
				 										 (TextView)findViewById(R.id.Top_W_scores));
		Top1.execute(("GET /scores.xml"));
		

	}

}
package com.project309.flashtriviachallenge;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class OtherProfile extends Activity {
	
	Button updateUN;
	TextView t;
	EditText e;
	ImageView i;
	
	
	@SuppressLint({ "NewApi", "NewApi" })
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_profile);
		
		t = (TextView)findViewById(R.id.usernameProfile);
		e = (EditText)findViewById(R.id.editUsername);
		e.setVisibility(View.GONE);
		i = (ImageView)findViewById(R.id.ProfilePic);
		i.setBackgroundColor(Color.BLACK);
		updateUN = (Button)findViewById(R.id.buttonEnter);
		updateUN.setVisibility(View.GONE);
		
		
		if (getIntent().getExtras().getString("name") != null){
			t.setText(getIntent().getExtras().getString("name"));
		}
	}
	
}

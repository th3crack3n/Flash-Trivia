package com.project309.flashtriviachallenge;

import android.os.Bundle;
import android.app.Activity;
import android.view.Window;
import android.widget.Button;

public class Help extends Activity {

	Button help;

	@Override
	public void onCreate(Bundle savedInstanceState) {
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help);
	}

}
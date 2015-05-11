package com.project309.flashtriviachallenge;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Info extends Activity {

	Button button, help, contact, version;

	@Override
	public void onCreate(Bundle savedInstanceState) {
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);
        addListenerOnButton();
	}
	
	public void addListenerOnButton() {
   	 
		final Context context = this;
 
		help = (Button) findViewById(R.id.help);
		contact = (Button) findViewById(R.id.contact);
		version = (Button) findViewById(R.id.version);
		
		help.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
 
			    Intent intent = new Intent(context, Help.class);
                startActivity(intent);   
 
			}
 
		});
		
		contact.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
 
			    Intent intent = new Intent(context, ContactUs.class);
                startActivity(intent);   
 
			}
 
		});
		
		version.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
 
			    Intent intent = new Intent(context, AppVersion.class);
                startActivity(intent);   
 
			}
 
		});
	}

}
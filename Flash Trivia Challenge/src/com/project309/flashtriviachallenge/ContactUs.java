package com.project309.flashtriviachallenge;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ContactUs extends Activity {

	Button contactEnter;
	String name, email, message;

	@Override
	public void onCreate(Bundle savedInstanceState) {
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_us);
		addListenerOnButton();
		
		
	}
	
	public void addListenerOnButton() {
 
		contactEnter = (Button) findViewById(R.id.contactSend);
		
 
		contactEnter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				EditText Name = (EditText)findViewById(R.id.contactNameField);
				EditText Email = (EditText)findViewById(R.id.contactEmailField);
				EditText Message = (EditText)findViewById(R.id.contactMessageField);
				
				name = Name.getText().toString();
				email = Email.getText().toString();
				message = Message.getText().toString();
				
				Name.setText("");
				Email.setText("");
				Message.setText("");
				
				contactEnter.setText("Message Sent!");
				
				sendMessage();
			}
 
		});
	}
	
	private void sendMessage(){
		
	}
}
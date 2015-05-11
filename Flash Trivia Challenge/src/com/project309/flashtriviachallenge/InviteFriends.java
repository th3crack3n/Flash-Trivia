package com.project309.flashtriviachallenge;

import android.os.Bundle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class InviteFriends extends Activity {
	
	Button invite;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friends);
        addListenerOnButton();
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_invite_friends, menu);
        return true;
    }
    
    public void addListenerOnButton() {
      	 
		final Context context = this;
 
		invite = (Button) findViewById(R.id.InviteFriends);
		
		
		invite.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
 
			    Intent intent = new Intent(context, CustomGame.class);
                startActivity(intent);   
                finish();
			}
 
		});
    }
}
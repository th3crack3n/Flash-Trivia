package com.project309.flashtriviachallenge;

import network.Request;
import network.UsersParser;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class UsersList extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_users_list);
        
        ListView lister = (ListView)findViewById(R.id.userListView);
        
        final UsersParser uParse = new UsersParser(lister, this);
 
        uParse.execute("GET /profiles.xml");
        
        lister.setOnItemClickListener(new OnItemClickListener(){

            public void onItemClick(AdapterView<?> arg0, View v, int position,long id)
            {
            	Intent intent = new Intent(getBaseContext(), OtherProfile.class);
            	String name;
            	intent.putExtra("name", uParse.names[position]);
                startActivity(intent);   
                
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });
    
	}
    
}

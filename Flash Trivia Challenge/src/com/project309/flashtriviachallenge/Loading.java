package com.project309.flashtriviachallenge;

import network.MacParser;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.content.Context;
//import android.content.Context;
import android.content.Intent;
import android.view.Window;

public class Loading extends Activity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) { 
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        
        String macAddr = getMacFromDevice();
        
        MacParser mParse = new MacParser(macAddr, true, "GET /profiles/newProf/",("/" + macAddr), false, false);
        
        mParse.execute("GET /profiles.xml");
        
        
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
	
	public CountDownTimer waitTimer = new CountDownTimer(3000, 5001) {
		//final Context context =  this;
    
		public void onTick(long millisUntilFinished) {
           //called every 5001 milliseconds, which could be used to
           //display some crude animation
		}

		public void onFinish() {
            //After 2000 milliseconds (2 sec) finish current 
            //activity and open next activity    
			Intent intent = new Intent(getBaseContext(), HomeScreen.class);
    		startActivity(intent);
    		finish();
        }
    }.start();


}
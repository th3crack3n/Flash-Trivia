package com.project309.flashtriviachallenge;



import network.*;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MyProfile extends Activity {
	
	Button updateUN;
	TextView t;
	TextView weekly, daily;
	EditText e;
	ImageView i;
	NameUpdater updateName;
	ImageUpdater updateImage;
	SetHighScore scoreGet;
	Bitmap image;
	MacParser mParse;
	UsersParser uParse;
	String mac;
	int scoresID;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_profile);
	//	weekly = (TextView)findViewById(R.id.weeklyscore);
	//	daily = (TextView)findViewById(R.id.dailyscore);
		t = (TextView)findViewById(R.id.usernameProfile);
		e = (EditText)findViewById(R.id.editUsername);
		i = (ImageView)findViewById(R.id.ProfilePic);
		i.setBackgroundColor(Color.BLACK);
		updateName = new NameUpdater(t, this);
		updateImage = new ImageUpdater(i);
		
		getUserNameFromServer();
		
		mParse = new MacParser(mac, false, null, null, true, false);
		mParse.execute("GET /profiles.xml");
		scoreGet = new SetHighScore();

	//	scoreGet.execute("GET /scores/" + (mParse.matchID + 1) + ".xml");

	//	scoreGet.execute("GET /scores/" + (scoresID) + ".xml");
		
		addListenerOnNameButton();
		addListenerOnImage();
		
	//	weekly.setText(scoreGet.weekly);
	//	daily.setText(scoreGet.daily);
		
		
	}
	
	public void getUserNameFromServer(){
		mac = getMacFromDevice();
		scoresID = 6;
		
		uParse = new UsersParser(t, this, 0);
		uParse.execute("GET /profiles.xml");
	}
	
	public int findID(){
		mParse = new MacParser(mac, false, null, null, true, false);
		mParse.execute("GET /profiles.xml");
		
		return mParse.matchID + 1;
	}
	
	public void addListenerOnNameButton() {
		
		updateUN = (Button) findViewById(R.id.buttonEnter);
		
		mParse = new MacParser(mac, false, null, null, true, false);
		mParse.execute("GET /profiles.xml");
		
		
 
		updateUN.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {

				updateName.execute("GET /profiles/un/" + (mParse.matchID+1) + "/" + e.getText().toString());

				
				t.setText(e.getText().toString());
				e.setVisibility(View.GONE);
				updateUN.setVisibility(View.GONE);
			}
 
		});
		
	}
	
	private String getMacFromDevice(){
		WifiManager wifiMan = (WifiManager) this.getSystemService(
                Context.WIFI_SERVICE);
		WifiInfo wifiInf = wifiMan.getConnectionInfo();
		return wifiInf.getMacAddress();
	}
	
	public void addListenerOnImage() {
		
		i.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
				intent.setType("image/*");
				startActivityForResult(intent, 0);
			
			}
 
		});
		
	}
	
	@Override
	protected void onActivityResult(int request, int result, Intent imageReturned){
		super.onActivityResult(request, result, imageReturned);
		
		switch(request){
		case 0:
			if(result == RESULT_OK){
				Uri selectedImage = imageReturned.getData();
				String[] filePathColumn = {MediaStore.Images.Media.DATA};
				
				Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
				cursor.moveToFirst();
				
				int colIndex = cursor.getColumnIndex(filePathColumn[0]);
				String filePath = cursor.getString(colIndex);
				cursor.close();
				
				image = BitmapFactory.decodeFile(filePath);
				Matrix mat = new Matrix();
				mat.postRotate(-90);
				Bitmap rotated = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), mat, true);
				image = rotated;
				i.setImageBitmap(image);
				
				
			i.toString();
			
			}
		}
		
	}
	
}

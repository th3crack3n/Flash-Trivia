package network;

import android.widget.ImageView;

public class ImageUpdater extends Request{

	ImageView t;
	
	public ImageUpdater(ImageView iv){
		t = iv;
	}
	
	
	@Override
	public void onPostExecute(String text){
		
	}	
	
}


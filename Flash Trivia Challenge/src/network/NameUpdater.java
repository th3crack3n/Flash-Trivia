package network;

import java.util.Scanner;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.widget.TextView;

public class NameUpdater extends Request{

	TextView t;
	public String[] names;
	public String[] macs;
	public int numMacs, matchID = -1;
	int id;
	Context context;
	
	public NameUpdater(TextView tv, Context con){
		t = tv;
		context = con;
	}
	
	
	@Override
	public void onPostExecute(String text){
		parseNames(text);
		parseMacs(text);
		if (hasMatch(getMacFromDevice()))
		t.setText(names[matchID + 1]);
	}	
	
	private String getMacFromDevice(){
		WifiManager wifiMan = (WifiManager) context.getSystemService(
                Context.WIFI_SERVICE);
		WifiInfo wifiInf = wifiMan.getConnectionInfo();
		return wifiInf.getMacAddress();
	}
	
	private void parseNames(String response){
		Scanner scan = new Scanner(response);
		String line = "Line";
		
		int i = 0;
		while (scan.hasNextLine()){
			line = scan.nextLine();
			if (line.contains("name")){
				i++;
			}
		}
		
		names = new String[i];
		
		int n = 0;
		while(n<i){
			names[n] = "";
			n++;
		}
		
		Scanner scan2 = new Scanner(response);
		
		int p = 0;
		while (p < i){
			line = scan2.nextLine();
			if (line.contains("name")){
				names[p] = line.substring(10, line.length() - 7);
				p++;
			}
		}
		scan.close();
		
	}
	
	private void parseMacs(String response){
		Scanner scan = new Scanner(response);
		String line = "Line";
		
		while (scan.hasNextLine()){
			line = scan.nextLine();
			if (line.contains("mac")){
				numMacs++;
			}
		}
		
		macs = new String[numMacs];
		
		Scanner scan2 = new Scanner(response);
		
		int p = 0;
		while (p < numMacs){
			line = scan2.nextLine();
			if (line.contains("mac")){
				macs[p] = line.substring(16, line.length() - 13);
				p++;
			}
		}
		scan.close();
		
	}

	public boolean hasMatch(String macAddr){
		boolean temp = false;
		
		int t = 0;
		while (t < (macs.length)){
			if (macs[t].compareTo(macAddr) == 0){
				temp = true;
				matchID = t;
			}
			t++;
		}
		return temp;
	}

}

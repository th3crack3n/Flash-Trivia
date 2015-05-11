package network;

import java.util.Scanner;
import android.widget.TextView;

public class MacParser extends Request{

	public String[] macs = {"Did not update"};
	String compMac = "0";
	public int numMacs = 0, matchID = -1;
	public boolean anotherRequest = false, hasAlreadyRun = false, matchFound = false, 
			readyToAddScores = false;
	public String nextRequest1, nextRequest2, scoresRequest;
	
	public MacParser(String cMac, boolean followedByRequest, String nextReq1, String nextReq2, boolean hasRun, boolean match){
		compMac = cMac;
		anotherRequest = followedByRequest;
		nextRequest1 = nextReq1;
		nextRequest2 = nextReq2;
		hasAlreadyRun = hasRun;
		matchFound = match;
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
	
	@Override
	public void onPostExecute(String text){
		parseMacs(text);
		matchFound = this.hasMatch(compMac);
		
		if (!hasAlreadyRun && !matchFound){
			readyToAddScores = true;
			new MacParser(null, true, null, null, true, matchFound).execute(nextRequest1 + (numMacs + 1) + nextRequest2);
		}
		
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
	
	public String[] getMacs(){
		return macs;
	}
	
}

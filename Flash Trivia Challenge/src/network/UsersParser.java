package network;

import java.util.ArrayList;
import java.util.Scanner;

import com.project309.flashtriviachallenge.UsersList;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class UsersParser extends Request{

	ListView mainList = null;
	TextView mainText = null;
	public String[] names = {"Did not update"};
	String[] macs = {"Did not update"};
	Context context;
	int id;
	
	public UsersParser(ListView t, Context c){
		mainList = t;
		context = c;
	}
	
	public UsersParser(TextView t, Context c, int i){
		mainText = t;
		context = c;
		id = i;
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
		
		int i = 0;
		while (scan.hasNextLine()){
			line = scan.nextLine();
			if (line.contains("mac")){
				i++;
			}
		}
		
		macs = new String[i];
		
		Scanner scan2 = new Scanner(response);
		
		int p = 0;
		while (p < i){
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
		parseNames(text);
		parseMacs(text);
		
		if (mainList != null){
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, names);
			mainList.setAdapter(adapter);
		} else {
			mainText.setText(names[id]);
		}
	}
	
}

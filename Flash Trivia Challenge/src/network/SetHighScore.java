package network;

import java.util.Scanner;

import android.widget.TextView;


public class SetHighScore extends Request{
	
	public int daily, weekly;
	
	public String day = "Day Score", week = "Week Score";
	
	public SetHighScore(){
		daily = 0;
		weekly = 0;
	}
	
	public String parseDaily(String response){
		Scanner scan = new Scanner(response);
		String correct = null;
		
		for(int i = 0; i < 4; i++){
			scan.nextLine();
		}
		
		correct = scan.nextLine();
		scan.close();
		
		day = correct;
		return day.substring(29, correct.length() - 13);
	}
	
	public String parseWeekly(String response){
		Scanner scan = new Scanner(response);
		String correct = null;
		
		for(int i = 0; i < 7; i++){
			scan.nextLine();
		}
		
		correct = scan.nextLine();
		scan.close();
		
		week = correct;
		return week.substring(30, correct.length() - 14);
	}
	
	public int toInt(String in){
		return Integer.parseInt(in);
	}
	
	
	@Override
	protected void onPostExecute(String text){
		daily = toInt(this.parseDaily(text));
		weekly = toInt(this.parseWeekly(text));
	}
	
	public String getWeek(){
		return week;
	}
	
	public String getDay(){
		return day;
	}
}

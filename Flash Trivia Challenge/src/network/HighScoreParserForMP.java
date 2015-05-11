package network;


import java.util.Scanner;

import android.widget.TextView;


public class HighScoreParserForMP extends Request{
	
	TextView ID,DScore,WScore;
	
	public HighScoreParserForMP(TextView id,TextView dailyScore,TextView weeklyScore)
	{
		ID = id;
		DScore = dailyScore;
		WScore = weeklyScore;
	}
	
	
	public String IdParser(String response)
	{
		Scanner scan = new Scanner(response);
		String id = "";
		String sub ="";
		for(int i = 0;i<10;i++)
		{
			while(scan.hasNextLine())
			{
				String line = scan.nextLine();
				if(line.startsWith("id",3))
				{	
					for(int j =0;j<line.length();j++)
					{
						if('0'<=line.charAt(j) && line.charAt(j)<='9')
						{
							sub += line.charAt(i);
						}
					}

				}
				else
				{
					scan.nextLine();
				}
			}
				id += sub;
		}
		
		return id;
	}
	
	
	public String DailyScoreParser(String response)
	{
		Scanner scan = new Scanner(response);
		String dailyScore = "";
		String sub ="";
		
		for(int i = 0; i <10; i++)
		{
			while(scan.hasNextLine())
			{
				String line = scan.nextLine();
				if(line.startsWith("daily",3))
				{	
					for(int j =0;j<line.length();j++)
					{
						if('0'<=line.charAt(j) && line.charAt(j)<='9')
						{
							sub += line.charAt(j);
						}
					}

				}
				else
				{
					scan.nextLine();
				}
			}
				dailyScore += sub;
		}
		
		return dailyScore;
	}


		
	public String WeeklyScoreParser(String response)
	{
		Scanner scan = new Scanner(response);
		String weeklyScore = "";
		String sub ="";
		
		for(int i =0;i<10;i++)
		{
			while(scan.hasNextLine())
			{
				String line = scan.nextLine();
				if(line.startsWith("weekly",3))
				{	
					for(int j =0;j<line.length();j++)
					{
						if('0'<=line.charAt(j) && line.charAt(j)<='9')
						{
							sub += line.charAt(j);
						}
					}

				}
				else
				{
					scan.nextLine();
				}
			}
				weeklyScore += sub;
		}
		
		return weeklyScore;
	}
	
	@Override
	protected void onPostExecute(String text)
	{
		ID.setText(this.IdParser(text));
		DScore.setText(this.DailyScoreParser(text));
		WScore.setText(this.WeeklyScoreParser(text));
	}
	
}


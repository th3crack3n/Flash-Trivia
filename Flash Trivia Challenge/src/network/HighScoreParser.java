package network;


import java.util.Scanner;

import android.widget.TextView;


public class HighScoreParser extends Request{
	
	TextView ID,DScore,WScore;
	
	public HighScoreParser(TextView id,TextView dailyScore,TextView weeklyScore)
	{
		ID = id;
		DScore = dailyScore;
		WScore = weeklyScore;
	}
	
	
	public String IdParser(String response)
	{	
		String str = "";
		Scanner scan = new Scanner(response);
		for(int i = 0;i<6;i++)
		{
		scan.nextLine();
		}
		String line1 = scan.nextLine();
			str = line1.substring(23,line1.length()-5)+"\n";
			
			for(int i = 0;i<6;i++)
			{
				scan.nextLine();
			}
			String line2 = scan.nextLine();
			str =str+ line2.substring(23,line2.length()-5)+"\n";
				
				for(int i = 0;i<6;i++)
				{
				scan.nextLine();
				}
				String line3 = scan.nextLine();
				str =str+ line3.substring(23,line3.length()-5)+"\n";
		
					for(int i = 0;i<6;i++)
					{
						scan.nextLine();
					}
					String line4 = scan.nextLine();
					str =str+ line4.substring(23,line4.length()-5)+"\n";
				
					for(int i = 0;i<6;i++)
					{
						scan.nextLine();
					}
					String line5 = scan.nextLine();
					str =str+ line5.substring(23,line5.length()-5)+"\n";
						
						for(int i = 0;i<6;i++)
						{
							scan.nextLine();
						}
						String line6 = scan.nextLine();
						str =str+ line6.substring(23,line6.length()-5)+"\n";
						
						for(int i = 0;i<6;i++)
						{
							scan.nextLine();
						}
						String line7 = scan.nextLine();
						str =str+ line7.substring(23,line7.length()-5)+"\n";
							
						for(int i = 0;i<6;i++)
						{
							scan.nextLine();
						}
						String line8 = scan.nextLine();
						str =str+ line8.substring(23,line8.length()-5)+"\n";
						
						for(int i = 0;i<6;i++)
						{
							scan.nextLine();
						}
						String line9 = scan.nextLine();
						str =str+ line9.substring(23,line8.length()-5)+"\n";
						
						for(int i = 0;i<6;i++)
						{
							scan.nextLine();
						}
						String line10 = scan.nextLine();
						str =str+ line10.substring(23,line8.length()-5)+"\n";
						
					return str;
		
	}
	
	
	public String DailyScoreParser(String response) 
	{	
		String str = "";
		Scanner scan = new Scanner(response);
		
			for(int i =0;i<5;i++)
			{
				scan.nextLine();
			}
			String line1 = scan.nextLine();
			str = str+line1.substring(31,line1.length()-13)+"\n";
			
			for(int i =0;i<6;i++)
			{
				scan.nextLine();
			}
			String line2 = scan.nextLine();
			str = str+line2.substring(31,line1.length()-13)+"\n";
			
			for(int i =0;i<6;i++)
			{
				scan.nextLine();
			}
			String line3 = scan.nextLine();
			str = str+line3.substring(31,line1.length()-13)+"\n";
			
			for(int i =0;i<6;i++)
			{
				scan.nextLine();
			}
			String line4 = scan.nextLine();
			str = str+line4.substring(31,line1.length()-13)+"\n";
			
			for(int i =0;i<6;i++)
			{
				scan.nextLine();
			}
			String line5 = scan.nextLine();
			str = str+line5.substring(31,line1.length()-13)+"\n";
			
			for(int i =0;i<6;i++)
			{
				scan.nextLine();
			}
			String line6 = scan.nextLine();
			str = str+line6.substring(31,line1.length()-13)+"\n";
			
			for(int i =0;i<6;i++)
			{
				scan.nextLine();
			}
			String line7 = scan.nextLine();
			str = str+line7.substring(31,line1.length()-13)+"\n";
			
			for(int i =0;i<6;i++)
			{
				scan.nextLine();
			}
			String line8 = scan.nextLine();
			str = str+line8.substring(31,line1.length()-13)+"\n";
			
			for(int i =0;i<6;i++)
			{
				scan.nextLine();
			}
			String line9 = scan.nextLine();
			str = str+line9.substring(31,line1.length()-13)+"\n";
			
			for(int i =0;i<6;i++)
			{
				scan.nextLine();
			}
			String line10 = scan.nextLine();
			str = str+line10.substring(31,line1.length()-13)+"\n";
		return str;
	}

	public String WeeklyScoreParser(String response)
	{	
		String str = "";
		Scanner scan = new Scanner(response);
		
		for(int i=0;i<8;i++)
		{
			scan.nextLine();
		}
		String line1 = scan.nextLine();
		str = line1.substring(32,line1.length()-14)+"\n";
		
		for(int i=0;i<6;i++)
		{
			scan.nextLine();
		}
		String line2 = scan.nextLine();
		str = str+line2.substring(32,line1.length()-14)+"\n";
			
		for(int i=0;i<6;i++)
		{
			scan.nextLine();
		}
		String line3 = scan.nextLine();
		str = str+line3.substring(32,line1.length()-14)+"\n";
		
		for(int i=0;i<6;i++)
		{
			scan.nextLine();
		}
		String line4 = scan.nextLine();
		str = str+line4.substring(32,line1.length()-14)+"\n";
		
		for(int i=0;i<6;i++)
		{
			scan.nextLine();
		}
		String line5 = scan.nextLine();
		str = str+line5.substring(32,line1.length()-14)+"\n";
		
		for(int i=0;i<6;i++)
		{
			scan.nextLine();
		}
		String line6 = scan.nextLine();
		str = str+line6.substring(32,line1.length()-14)+"\n";
		
		for(int i=0;i<6;i++)
		{
			scan.nextLine();
		}
		String line7 = scan.nextLine();
		str = str+line7.substring(32,line1.length()-14)+"\n";
		
		for(int i=0;i<6;i++)
		{
			scan.nextLine();
		}
		String line8 = scan.nextLine();
		str = str+line8.substring(32,line1.length()-14)+"\n";
		
		for(int i=0;i<6;i++)
		{
			scan.nextLine();
		}
		String line9 = scan.nextLine();
		str = str+line9.substring(32,line1.length()-14)+"\n";
		
		for(int i=0;i<6;i++)
		{
			scan.nextLine();
		}
		String line10 = scan.nextLine();
		str = str+line10.substring(32,line1.length()-14)+"\n";
		
		return str;
	}
	
	@Override
	protected void onPostExecute(String text)
	{
		ID.setText(this.IdParser(text));
		DScore.setText(this.DailyScoreParser(text));
		WScore.setText(this.WeeklyScoreParser(text));
	}
	
}

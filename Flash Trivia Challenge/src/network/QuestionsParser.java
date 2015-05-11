package network;

import java.util.Random;
import java.util.Scanner;

//import android.os.AsyncTask;
import android.widget.TextView;

public class QuestionsParser extends Request{
	int id = generateQuestionID();
	TextView Question, Ans1, Ans2, Ans3, Ans4;
	public int Correct;
	
	public QuestionsParser(TextView q, TextView a1, TextView a2, TextView a3, TextView a4){
		Question = q;
		Ans1 = a1;
		Ans2 = a2;
		Ans3 = a3;
		Ans4 = a4;
		Correct = 0;
	}

	/**
	 * Takes a server response, parses it, and
	 * returns the question text.
	 * 
	 * @param response
	 * @return
	 */
	public String parseQuestion(String response){
		Scanner scan = new Scanner(response);
		String question = null;
		
		for(int i = 0; i < 10; i++){
			scan.nextLine();
		}
		
		question = scan.nextLine();
		scan.close();
		
		return question.substring(12, question.length() - 11);
	}
	
	/**
	 * Takes a server response, parses it, and
	 * returns answer #1 for the corresponding question.
	 * 
	 * @param response
	 * @return
	 */
	public String parseAns1(String response){
		Scanner scan = new Scanner(response);
		String ans = null;
		
		for(int i = 0; i < 3; i++){
			scan.nextLine();
		}
		
		ans = scan.nextLine();
		scan.close();
		
		return ans.substring(11, ans.length() - 10);
	}
	
	/**
	 * Takes a server response, parses it, and
	 * returns answer #2 for the corresponding question.
	 * 
	 * @param response
	 * @return
	 */
	public String parseAns2(String response){
		Scanner scan = new Scanner(response);
		String ans = null;
		
		for(int i = 0; i < 4; i++){
			scan.nextLine();
		}
		
		ans = scan.nextLine();
		scan.close();
		
		return ans.substring(11, ans.length() - 10);
	}
	
	/**
	 * Takes a server response, parses it, and
	 * returns answer #3 for the corresponding question.
	 * 
	 * @param response
	 * @return
	 */
	public String parseAns3(String response){
		Scanner scan = new Scanner(response);
		String ans = null;
		
		for(int i = 0; i < 5; i++){
			scan.nextLine();
		}
		
		ans = scan.nextLine();
		scan.close();
		
		return ans.substring(11, ans.length() - 10);
	}
	
	/**
	 * Takes a server response, parses it, and
	 * returns answer #4 for the corresponding question.
	 * 
	 * @param response
	 * @return
	 */
	public String parseAns4(String response){
		Scanner scan = new Scanner(response);
		String ans = null;
		
		for(int i = 0; i < 6; i++){
			scan.nextLine();
		}
		
		ans = scan.nextLine();
		scan.close();
		
		return ans.substring(11, ans.length() - 10);
	}
	
	/**
	 * Takes a server response, parses it, and
	 * returns the index of the correct question
	 * for the corresponding question.
	 * 
	 * @param response
	 * @return
	 */
	public String parseCorrect(String response){
		Scanner scan = new Scanner(response);
		String correct = null;
		
		for(int i = 0; i < 7; i++){
			scan.nextLine();
		}
		
		correct = scan.nextLine();
		scan.close();
		
		return correct.substring(32, correct.length() - 16);
	}
	
	/**
	 *  Generates a random question to pull form the server database.
	 */
	public int generateQuestionID() {
		
		Random generator = new Random();
		return (generator.nextInt() % 3) + 1;
 
	}
	
	/**
	 *  Converts the string representation of the 
	 *  correct answer index into an int.
	 */
	public int toInt(String in){
		return Integer.parseInt(in);
	}
	
	@Override
	protected void onPostExecute(String text){
		Question.setText(this.parseQuestion(text));
		Ans1.setText(this.parseAns1(text));
		Ans2.setText(this.parseAns2(text));
		Ans3.setText(this.parseAns3(text));
		Ans4.setText(this.parseAns4(text));
		Correct = toInt(this.parseCorrect(text));
	}

}


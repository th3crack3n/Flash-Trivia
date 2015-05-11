package interfaces;

import java.util.Random;
import network.QuestionsParser;
import android.app.Activity;


public class GetQuestions extends Activity{
	public static int QUESTION_DB_START;
	public static int QUESTION_DB_FINISH;
	public static int QUESTION_DB_SIZE = 60;
	public static int GAME_TYPE = 0;
	public int[] quesList = new int[10];
	public QuestionsParser[] Questions = new QuestionsParser[10];
	public int Correct;
	
	public GetQuestions(int start, int finish){
		QUESTION_DB_START = start;
		QUESTION_DB_FINISH = finish;
		quesList = getQuestionIndex(QUESTION_DB_START, QUESTION_DB_FINISH);
		//Questions = getQuestions();
	}
	
	private static int generateID(int start, int finish){
		Random generator = new Random();
		
		return (generator.nextInt(finish - start) + start);
	}
	
	public static int[] getQuestionIndex(int start, int finish){
		int[] List = new int[10];
		int index = generateID(start, finish);
		List[0] = index;
		index++;
		for(int j = 1; j < 10; j++){
			if(index > finish){
				index = start;
			}
			switch(j){
			case 1:  List[1] = index; break;
			case 2:  List[4] = index; break;
			case 3:  List[7] = index; break;
			case 4:  List[2] = index; break;
			case 5:  List[5] = index; break;
			case 6:  List[8] = index; break;
			case 7:  List[3] = index; break;
			case 8:  List[6] = index; break;
			case 9:  List[9] = index; break;
			}
			if(GAME_TYPE != 0){
				index++;
			}else{
				index += 9;
			}
		}
		return List;
	}
	
	public void chooseType(int gametype){
		
	}
	
	/*public static QuestionsParser[] getQuestions(){
		QuestionsParser[] ques = new QuestionsParser[10];
		GetQuestions index = new GetQuestions();
		for(int i = 0; i < 10; i++){
			ques[i] = new QuestionsParser((TextView) findViewById(R.id.textView2),
			  							  (TextView) findViewById(R.id.radio0),
			  							  (TextView) findViewById(R.id.radio2),
			  							  (TextView) findViewById(R.id.radio1),
			  							  (TextView) findViewById(R.id.RadioButton01));
			ques[i].execute(("GET /questions/" + index.quesList[i - 1] + ".xml"));
		}
		
		
		return ques;	
	}*/
}

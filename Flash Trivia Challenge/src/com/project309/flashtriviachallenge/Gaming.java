package com.project309.flashtriviachallenge;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import network.QuestionsParser;
import interfaces.GetQuestions;

public class Gaming extends Activity {
	static String response = null;
	static String question = null;
	static String ans1 = null;
	static String ans2 = null;
	static String ans3 = null ;
	static String ans4 = null;
	static int score = 0, temp = 0;
	static int i=1;
	protected static TextView Time;
	protected CountDownTimer timer;
	static GetQuestions ques;
	public boolean finished = false;
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_gaming, menu);
  	  	setTextViewColor();
        return true;
    } 
      
     
    public class MyCount extends CountDownTimer
    {
    	
    	public MyCount(long millisInFuture, long countDownInterval)
    	{
    		super(millisInFuture, countDownInterval);
    	}
    	
    	@Override
    	public void onFinish()
    	{
    		Time.setText("Time's up!");
    		finished = true;
    	}
    	
    	@Override
    	public void onTick(long millisUntilFinished)
    	{
    		Time.setText("Left: "+millisUntilFinished/1000);
    	}
    }
    
    
     protected void onCreate(Bundle icicle) { 
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    	super.onCreate(icicle); 
        setContentView(R.layout.activity_gaming); 
        Time = (TextView)findViewById(R.id.time);
        final Button button = (Button) findViewById(R.id.button1);
        final MyCount counter = new MyCount(16000,1000);
        final TextView questionNum = (TextView) findViewById(R.id.textView1);
        final QuestionsParser  qparse = new QuestionsParser((TextView) findViewById(R.id.textView2),
													  		(TextView) findViewById(R.id.radio0),
													  		(TextView) findViewById(R.id.radio2),
													  		(TextView) findViewById(R.id.radio1),
													  		(TextView) findViewById(R.id.RadioButton01));
        final RadioButton button1 = (RadioButton) findViewById(R.id.radio0);
        final RadioButton button2 = (RadioButton) findViewById(R.id.radio2);
        final RadioButton button3 = (RadioButton) findViewById(R.id.radio1);
        final RadioButton button4 = (RadioButton) findViewById(R.id.RadioButton01); 
        if(i == 1){
        	switch(GetQuestions.GAME_TYPE){
        	case 0: ques = new GetQuestions(1, GetQuestions.QUESTION_DB_SIZE); break;
        	case 1: ques = new GetQuestions(1, 10); break;
        	case 2:	ques = new GetQuestions(11, 20); break;
        	case 3:	ques = new GetQuestions(21, 30); break;
        	case 4: ques = new GetQuestions(31, 40); break;
        	case 5: ques = new GetQuestions(41, 50); break;
        	case 6: ques = new GetQuestions(51, 60); break;
        	}
        }
        questionNum.setText("Question: " + i); 
        qparse.execute(("GET /questions/" + ques.quesList[i - 1] + ".xml"));

        counter.start();

  	  	
        button.setOnClickListener(
 			new View.OnClickListener() { 		
	            public void onClick(View v) { 
	              ++i;
	              if (i < 11 || finished){
	            	  if(finished){
	            		  qparse.Correct = 0;
	            	  }
	            	  switch(qparse.Correct){
	            	  	case 0: break;
	            	  	case 1: if(button1.isChecked()){
            	  					score = score + 2;
            	  				}else{
            	  					score = score - 1;
            	  				};
            	  				break;
            	  		case 2: if(button2.isChecked()){
		            	  			score = score + 2;
		    	  				}else{
		    	  					score = score - 1;
		    	  				};
            	  				break;
            	  		case 3: if(button3.isChecked()){
		            	  			score = score + 2;
		    	  				}else{
		    	  					score = score - 1;
		    	  				};
		            	  		break;
		            	case 4: if(button4.isChecked()){
				            		score = score + 2;
		    	  				}else{
		    	  					score = score - 1;
		    	  				};
		            	  		break;
	            	  }
	            	  counter.cancel();
	            	  Intent intent = new Intent(getApplicationContext(), Gaming.class);
	                  startActivity(intent);	               
	                  overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
	                  finish();

	            	  //setTextViewColor();
	
	              } else {	  
	            	  i = 1;
	            	  temp = score;
	            	  switch(qparse.Correct){
	            	  	//case 0: break;
	            	  	case 1: if(button1.isChecked()){
			            	  		score = score + 2;
		    	  				}else{
		    	  					score = score - 1;
		    	  				};
	          	  				break;
	          	  		case 2: if(button2.isChecked()){
			          	  			score = score + 2;
		    	  				}else{
		    	  					score = score - 1;
		    	  				};
	          	  				break;
	          	  		case 3: if(button3.isChecked()){
			          	  			score = score + 2;
		    	  				}else{
		    	  					score = score - 1;
		    	  				};
		            	  		break;
		            	case 4: if(button4.isChecked()){
				            		score = score + 2;
		    	  				}else{
		    	  					score = score - 1;
		    	  				};
		            	  		break;
	            	  }
	            	  /*if(finished){
	            		  score = temp;
	            	  }*/
	            	  for(int j = 0; j < 10; j++){
	            		  ques.quesList[j] = 0;
	            	  }
	            	  counter.cancel();
	            	  Intent intent = new Intent(getApplicationContext(), ScoreScreen.class);
	                  startActivity(intent);
	                  overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
	                  finish();
	                  
	              }
	            } 
	        });  
     }
    
    public void setTextViewColor()
	{
		//Time.setTextColor(Color.RED);
	}
    
    @Override
	public void onBackPressed() {
	
	}
	
}

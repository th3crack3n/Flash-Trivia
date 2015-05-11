package interfaces;

import java.util.Random;

import network.QuestionsParser; 

public class QuestionsInterface {
	
	
	public QuestionsInterface(){
		String question;
		String ans1;
		String ans2;
		String ans3;
		String ans4;
		int correct;
	}
	/*/**
	 * generateQuestionID() takes no parameters as an input, and outputs a random
	 * int value that represents the index of the Question in the database
	 * 
	 * @return
	 */
	/*int generateID(){
		Random generator = new Random();
		return (generator.nextInt() % 3) + 1;
	}*/
	
	/*
	 * getQuestion() takes the index of the question as a parameter, and outputs
	 * a string that is the question
	 * 
	 * @param questionID
	 * @return
	 */
	/*String getQuestion(int questionID){
		
	}*/
	
	/*
	 * getAnswers() takes the index of the answers as a parameter, and outputs
	 * an array of strings which are the answer choices
	 * 
	 * @param questionID
	 * @return
	 */
	//String[] getAns1(int questionID);
	
	/*
	 * correctAnswer() takes the index of the answers as a parameter, and outputs
	 * the index in the array of answers that is the correct answer
	 * 
	 * @param questionID
	 * @return
	 */
	//int correctAnswer(int questionID);
}


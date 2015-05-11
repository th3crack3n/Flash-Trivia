package interfaces;

import java.sql.Blob;

public interface ProfileInterface {
	
	// returns a string containing the username that has						been previously set by the user with given id
	String getUsername(int id);
	
	// returns a jpg, png, or bmp file containing the picture that has been previously set by the user with given id
	Blob getProfilePic(int id);
	
	//returns a int value containing the high score of the current day, associated with the user with given id
	int getUserDailyScore(int id);
	
	//returns an int value containing the high score of the current week, associated with the use with given id
	int getUserWeeklyScore(int id);
    
    

}
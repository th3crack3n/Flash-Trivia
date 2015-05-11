package interfaces;

public interface HighScore_interface {
	
	/*
	 * returns a string that is the result of ranking all
		scores from high to low.
	 */
	String rankscore(String a);
	/*
	 * show the highest scores of today of top ten users.
	 */
	void HighScoreToday();
	/*
	 * show the highest score of this week of top ten users.
	 */
	void HighScoreWeek();
	/*
	 * returns a two dimension array, one is
		showing id list, the other is showing score list.
	 */
	String getScoreTable(int[] ids, int[] scores);
	
}
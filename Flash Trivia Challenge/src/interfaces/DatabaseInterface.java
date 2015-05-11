package interfaces;

public interface DatabaseInterface {
	
	//Return the current instance to the database, 
	//or create a new one if there is no connection exists.
	
	String getDatabaseInstance();
	
	//Excute a query on database and 
	//return the Statement object after completion. 
	//Throw a SQLException if there is any problem.

	String excuteQuery(String query);
	
	//Excute a update on the database and return the 
	//Statement object after completion. 
	//Throw a SQLException if there is any problem.
	
	
	void  excuteUpdate(String query);

	
}

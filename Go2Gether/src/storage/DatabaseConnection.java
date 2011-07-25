package storage;

import java.sql.*;
import java.util.Calendar;
import java.util.UUID;

public class DatabaseConnection {

	//Connection specific variables
	// Perhaps theese variables shoud be read from a xml-settings-file
    private final String dbForName = "org.postgresql.Driver";
    private final String jdbcLocation = "jdbc:postgresql:"
				      + "//localhost:5432/G2G";
    
    /*
     * Theese variables are used to connect to the dB,
     *  should be changed before deployment (maybe..)
     *  to make all users own username and password used
     *  by the page to access what he/she may & needs from the dB
     */
    private final String u = "g2g"; //username
    private final String p = "g2g"; //password
    
    
    //The connection and statement that we will use in this application.
    private Connection c = null;
    private Statement s = null; //Not sure what a >Statement< is in this context..
    
    /**
     * Creates an empty DatabaseConnection, no settings or connections will be
     *  set/created with this constructor
     */
	public DatabaseConnection(){ }
	
	public boolean connect(){
		boolean retVal = false;
        try {
        	Class.forName(dbForName);
        }catch (ClassNotFoundException cnfe) {
            log("NOT_FIND_DRIVER_CLASS", cnfe.getStackTrace().toString());
        }
        
        try {
            c = DriverManager.getConnection(jdbcLocation, u, p);
        } catch (SQLException se) { 
        	log("COULD_NOT_CONNECT", se.getStackTrace().toString());
        }
        if (c != null){ 
        	log("SUCCESS", Calendar.getInstance().toString());//tror inte denna formaterar korrekt..
        }else{ log("NEVER_GET_HERE", "-"); }
        
        try{
            s = c.createStatement();
            retVal = true;
        }catch (SQLException se){ log("STATEMENT_ERROR", se.getMessage()); }
        
        return retVal;
    }
	
	public void log(String mess, String log){
		//Should probably be in a own class, since this is instead should be a connection to the file-system and a log-file
		if (mess.equals("STATEMENT_ERROR")){
			System.out.println("(Application will exit!!)\n"
        	    + "We got an exception while creating a statement: "
        	    + "That propably means we are no longer connected.");
		}else if (mess.equals("NEVER_GET_HERE")){
            System.out.println("(Try-catch?)Err: We should never get here.");
		}else if (mess.equals("SUCCESS")){
			System.out.println("dB:Connection successful");
		}else if (mess.equals("COUT_NOT_CONNECT")){
			System.out.println("(Application will exit!!)\n"
	        		+ "Couldn't connect: print out a stack trace");
		}else if (mess.equals("NOT_FIND_DRIVER_CLASS")){
            System.err.println("(Application will exit!!)\n"
        	    + "Couldn't find driver class:");
		}
        
		
		System.out.println(log);
	}

	/**
     * @returns true if we are still connected to the database
     */
    public boolean isConnected(){
		try {
		    if (!s.isClosed() && !c.isClosed())
			return true;
		}catch (SQLException e){
		    System.out.println(e.getMessage());
		}
		return false; 
    }
    
    /**
     * This method will disconnect us from the database.
     */
    public void disconnectDB() {
		try{	//try closing connections
		    System.out.print("Disconnecting...");
		    s.close();
		    c.close();
		    System.out.println("Done!");
		}catch (SQLException se){
		    //Errors? show what....
		    System.out.println("Error occured when closing" +
		    		" connections to database\n"+
		    		se.getMessage() + "\n" + se.getStackTrace());
		}
    }
    
    /**
     * This method will execute a SQL-statement, returning a ResultSet
     * with all the information extracted by the sqlStatement...
     * WILL RETURN NULL IF THERE IS NO CONNECTION!!
     *  eg: "SELECT * FROM myTable;"
     * This method is mainly meant to be used internally, but I left the
     *  it public for now.
     *  @param sqlString like the sample above..
     *  @return ResultSet with the data from the db.
     */
    public ResultSet executeSQL(String sqlString){
    	ResultSet rs = null;
        if (isConnected()){
            try {
               rs = s.executeQuery(sqlString); 
            }catch (SQLException se){
                System.out.println(
            	    "We got an exception while executing query: "
            	    + "That propably means our SQL is invalid.");
                se.printStackTrace();
                System.out.println(se.getMessage());
            }
        }
        return rs;
    }
    
    /**
     * This method will execute a DDL or DML -satement and 
     *  return a int with the number of tuples affected...
     * If return value is < 0 then we're not connected to db!
     * @param sqlString eg.
     * "UPDATE myTable SET aColumn = '2'  WHERE aValue = '1234567890' ;"
     * @return int with the number of tuples that were affected..
     */
    public int executeUpdate(String sqlString){
		int ret = -1;
		if (isConnected()){
		    try {
			ret = s.executeUpdate(sqlString);
		    }catch (SQLException se){
		        System.out.println(
		       	    "We got an exception while executing sql-Update: "
		       	    + "That propably means our SQL is invalid.");
		        se.printStackTrace();
		        System.out.println(se.getMessage());
		        //System.exit(1);
		    }
		}
		return ret;
    }
}

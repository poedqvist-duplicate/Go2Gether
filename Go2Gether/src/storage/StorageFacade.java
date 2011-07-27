/**
 * 
 */
package storage;

import java.sql.*;

import models.Traveller;

/**
 * A class that acts as a facade between the model layer and the storage layer.
 * @author Kristofer
 *
 */
public class StorageFacade {
	
	//public Traveller getTraveller(){
	//Traveller t1 = new Traveller();
	
	//}
	
	public void saveTraveller(Traveller travellerToBeSaved) throws SQLException {
		
		DatabaseConnection dc1 = new DatabaseConnection();
		dc1.connect();
		
		Statement sqlStatement = null;
		
		String sqlString = String.format(
				"INSERT INTO \"Travellers\" VALUES ('%s', '%s', '%s', %d);",
				travellerToBeSaved.getName(), travellerToBeSaved.getId(), 
					travellerToBeSaved.getPhone(), travellerToBeSaved.getAge());
		
		sqlStatement.executeUpdate(sqlString);
		
	}

}

/**
 * 
 */
package test;

import storage.DatabaseConnection;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Kristofer
 *
 */
public class DatabaseConnectionTest {
	
	public void canConnectToDb(){
		DatabaseConnection dc1 = new DatabaseConnection();
		assertTrue(dc1.connect());
	}

}

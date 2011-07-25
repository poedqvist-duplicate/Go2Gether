package test;

import static org.junit.Assert.*;

import org.junit.Test;

import storage.DatabaseConnection;

public class DatabaseTests {

	@Test
	public void test_CanConnectAndDisconnectToG2GDatabase() {
		
		DatabaseConnection db = new DatabaseConnection();
		
		assertFalse(db.isConnected());
		assertTrue(db.connect());
		
		db.disconnectDB();
		
		assertFalse(db.isConnected());
	}

}

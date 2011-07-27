/**
 * 
 */
package test;

import static org.junit.Assert.*;

import models.Traveller;

import org.junit.Test;

/**
 * @author Kristofer
 *
 */
public class StorageFacadeTest {

	@Test
	public void saveTravellerToDb() {
		Traveller t1 = new Traveller();
		t1.setAge("23");
		t1.setName("Kristofer");
		t1.setPhoneNumber("032110622");
		t1.setId("0");
		t1.saveTraveller();
	}

}

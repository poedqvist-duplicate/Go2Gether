/**
 * 
 */
package test;

import static org.junit.Assert.*;

import models.Journey;
import models.Traveller;
import models.City;

import org.junit.Test;

/**
 * @author P-O Edqvist
 *
 */
public class JourneyTest {
	@Test
	public void journeyKnowsItsAttributes() {
		
		//Creates cityobjects
		City t1 = new City("G�teborg");
		City t2 = new City("Stockholm");
		City t3 = new City("Ulricehamn");
		
		//Creates a new journey with a start- and endpoint
		Journey j = new Journey(t1, t2);
		
		//Checks so that stockholm isn't the starting point for the journey
		assertFalse(j.getStartCity().equals("Stockholm"));
		//Checks so that g�teborg is the starting point for the journey
		assertEquals("G�teborg", j.getStartCity());
		//Checks so that stockholm is the enddestination
		assertEquals("Stockholm", j.getEndCity());
		
		//Changes start and endcity
		j.setStartCity(t3);
		j.setEndCity(t1);
		
		//Asserts that ulricehamn is the startcity and g�teborg the endcity
		assertEquals("Ulricehamn", j.getStartCity());
		assertEquals("G�teborg", j.getEndCity());
	}

}

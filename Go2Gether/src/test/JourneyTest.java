/**
 * 
 */
package test;

import static org.junit.Assert.*;

import models.Journey;
import models.Person;
import models.City;

import org.junit.Test;

/**
 * @author P-O Edqvist
 *
 */
public class JourneyTest {
	@Test
	public void journeyKnowsItsAttributes() {
		
		City t1 = new City("Göteborg");
		City t2 = new City("Stockholm");
		City t3 = new City("Ulricehamn");
		
		Journey j = new Journey(t1, t2);
		
		assertFalse(j.getStartCity().equals("Stockholm"));
		assertEquals("Göteborg", j.getStartCity());
		assertEquals("Stockholm", j.getEndCity());
		
		j.setStartCity(t3);
		j.setEndCity(t1);
		
		assertEquals("Ulricehamn", j.getStartCity());
		assertEquals("Göteborg", j.getEndCity());
	}

}

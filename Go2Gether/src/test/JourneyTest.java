/**
 * 
 */
package test;

import static org.junit.Assert.*;

import models.Person;

import org.junit.Test;

/**
 * @author P-O Edqvist
 *
 */
public class JourneyTest {
	@Test
	public void journeyKnowsItsAttributes() {
		Journey j = new Journey();
		
		j.setStart("Gšteborg");
		j.setEnd("Stockholm");
		
		assertEquals("Gšteborg", j.getStart());
		assertEquals("Stockholm", j.getEnd());
		
	}

}

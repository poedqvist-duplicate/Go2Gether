/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import models.City;
import models.Journey;
import models.Traveller;

import org.junit.Test;

/**
 * @author P-O Edqvist
 *
 */
public class TravellerTest {

	@Test
	public void travellerKnowsItsAttributes() {
		
		Traveller p1 = new Traveller();
		p1.setName("Testperson");
		p1.setPhoneNumber("032110622");
		p1.setAge("23");
		
		assertFalse(p1.getPhoneNumber().equals("032110621"));
		
		assertEquals("Testperson", p1.getName());
		assertEquals("032110622", p1.getPhoneNumber());
		assertEquals("23", p1.getAge());
	}
	
	@Test
	public void travellerKnowsItsJourneys(){
		
		//Creates traveller with attributes
		Traveller p1 = new Traveller();
		p1.setName("Testperson");
		p1.setPhoneNumber("032110622");
		p1.setAge("23");
		
		//Creates two cities
		City t1 = new City("Göteborg");
		City t2 = new City("Stockholm");
		
		//Creates two journeys that are to be added to p1's Journey[]
		Journey j = new Journey(t1, t2);
		Journey j2 = new Journey(t2, t1);
		
		//Adds journey
		p1.addJourney(j);
		p1.addJourney(j2);
		
		//Creates temporary array to recieve p1's array
		 ArrayList<Journey> testArr = p1.getAllJourneys();
		
		//Checks if first elemts has the correct end- and startcities
		assertEquals("Göteborg", testArr.get(0).getStartCity());
		assertEquals("Stockholm", testArr.get(0).getEndCity());
		
	}

}


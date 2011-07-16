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
public class PersonTest {

	@Test
	public void personKnowsItsAttributes() {
		
		Person p1 = new Person();
		p1.setName("Testperson");
		p1.setPhoneNumber("032110622");
		p1.setAge("23");
		
		assertFalse(p1.getPhoneNumber().equals("032110621"));
		
		assertEquals("Testperson", p1.getName());
		assertEquals("032110622", p1.getPhoneNumber());
		assertEquals("23", p1.getAge());
	}

}

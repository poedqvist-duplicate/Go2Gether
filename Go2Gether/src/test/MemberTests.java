/**
 * 
 */
package test;

import static org.junit.Assert.*;
import org.junit.Test;


/**
 * @author P-O Edqvist
 *
 */
public class MemberTests {

	@Test
	public void memberKnowsItsAttributes(){
		
	}
	
	@Test
	public void memberCanBeRegistered(){
		
	}
	
	@Test
	public void memberCanBeUnregistered(){
		
	}
	
	@Test
	public void memberCanChangeAttributes(){
		
	}
	
	@Test
	public void memberCanExportToPersistantStorage(){
		Member m = new Member();
		
		assertTrue(m.save());
	}
	
	@Test
	public void memberCanImportFromPersistantStorage(){
		int memberId = 346;
		Member m = new Member(memberId);
	}
	
	
	
	/*
	 * Member
	 * Name   | Phone   | Id
	 * P-O    | 1234    | 1
	 */
	
	//P-O#1234#1
	//Member#Name#Phone#Id
	public boolean saveMe(String s, String table){
		//�ppna connection
		//Skapa sql-str�ng av infomationen i s..
		// skicka sql-str�ng till db-motor
		// ta emot resultat
		//ber�kna hur m�nga rader som borde �ndras
		//kontrollera om antalet rader som faktiskt �ndrades var s� m�nga och returnera det..
		int numRowsAffected = 1;
		int actually = db.executeSQL();
		return actually == numRowsAffected;
	}
}

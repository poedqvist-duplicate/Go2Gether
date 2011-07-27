/**
 * 
 */
package models;

import java.util.ArrayList;

/**
 * @author Kristofer
 *
 */
public class Traveller {
	
	private String name;
	private String phoneNumber;
	private String age;
	private ArrayList<Journey> journeys = new ArrayList<Journey>();	
	
	public String getName(){
		return name;
	}
	
	public String getPhoneNumber(){
		return phoneNumber;
	}
	
	public String getAge(){
		return age;
	}
	
	public void addJourney(Journey journey){
		journeys.add(journey);
	}
	
	public void removeJourney(Journey journey){
		journeys.remove(journey);
	}
	
	public ArrayList<Journey> getAllJourneys(){
		return journeys;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	public void setAge(String age){
		this.age = age;
	}

}

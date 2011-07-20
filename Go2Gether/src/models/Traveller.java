/**
 * 
 */
package models;

/**
 * @author Kristofer
 *
 */
public class Traveller {
	
	private String name;
	private String phoneNumber;
	private String age;
	private Journey[] Journeys; 	
	
	public String getName(){
		return name;
	}
	
	public String getPhoneNumber(){
		return phoneNumber;
	}
	
	public String getAge(){
		return age;
	}
	
	//Something goes wrong when i try to set Journey[i] = j
	public void addJourney(Journey j){
		for(int i = 0; i <= Journeys.length; i++){
			if(Journeys[i] == null){
				Journeys[i] = j;
			}
		}
	}
	
	public Journey[] getAllJourneys(){
		return Journeys;
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

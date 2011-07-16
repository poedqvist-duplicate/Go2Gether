/**
 * 
 */
package models;

/**
 * @author Kristofer
 *
 */
public class Person {
	
	private String name;
	private String phoneNumber;
	private String age;
	
	public String getName(){
		return name;
	}
	
	public String getPhoneNumber(){
		return phoneNumber;
	}
	
	public String getAge(){
		return age;
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

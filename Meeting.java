/**   Name: Meeting.java
 * 	  Purpose: This class inherits event and models a meeting event.
 * 	  Course: CST8130
 * 	  Section: 303
 *	  Author:  Chandler Newman-Reed
 *	  Date: 1/24/2017
 *	  Data fields:  none
 *    Methods:  default constructor 
 *				inputEvent(Scanner, String): boolean - calls super inputEvent and asks for input for location for meeting event
 *              toString(): String - returns string of meeting event
 */
import java.util.Scanner;

public class Meeting extends Event {
	
	private String location;
	
	public Meeting(){
	}
	
	public boolean inputEvent(Scanner input, String prompt){
		if(!super.inputEvent(input, prompt))
			return false;
		if(prompt.charAt(0) == 'y'){
			System.out.println("\nEnter a location for meeting: ");
		}
		location = input.next();
		return true;
	}
	
	public String toString(){
		return super.toString() + " at " + location;
	}
}

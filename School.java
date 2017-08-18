/**   Name: School.java
 * 	  Purpose: This class inherits event and models a school event.
 * 	  Course: CST8130
 * 	  Section: 303
 *	  Author:  Chandler Newman-Reed
 *	  Date: 1/24/2017
 *	  Data fields:  none
 *    Methods:  default constructor 
 *				inputEvent(Scanner, String): boolean - calls super inputEvent and checks for inputmismatch
 *              toString(): String - returns string of school event
 */
import java.util.Scanner;

public class School extends Event {
	
	public School(){}
	
	public boolean inputEvent(Scanner input, String prompt){
		if(!super.inputEvent(input, prompt))
			return false;
		return true;
	}
	
	public String toString(){
		return super.toString();
	}

}

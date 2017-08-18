/**   Name: Work.java
 * 	  Purpose: This class inherits event and models a work event.
 * 	  Course: CST8130
 * 	  Section: 303
 *	  Author:  Chandler Newman-Reed
 *	  Date: 1/24/2017
 *	  Data fields:  length - length of work shift 
 *    Methods:  default constructor 
 *				inputEvent(Scanner, String): boolean - calls super inputEvent and asks for input of length for work shift event
 *              toString(): String - returns string of work event
 */
import java.util.Scanner;

public class Work extends Event {
	
	private int length;
	
	public Work(){}
	
	public boolean inputEvent(Scanner input, String prompt){
		if(!super.inputEvent(input, prompt))
			return false;
		do{
			if(prompt.charAt(0) == 'y')
				System.out.println("\nEnter the length of the shift: ");
			if(input.hasNextInt()){
				length = input.nextInt();
				if(length <= 0 && prompt.charAt(0) != 'y'){
					System.out.println("Invalid work shift input");
					return false;
				}
			}
			else {
				System.out.println("Invalid work shift input");
				input.next();
				if(prompt.charAt(0) != 'y')
					return false;
			}
		} while (length <= 0);
		return true;
	}
	
	public String toString(){
		return super.toString() + " for " + length;
	}

}

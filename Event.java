/**   Name: Event.java
 * 	  Purpose: This class models an event.
 * 	  Course: CST8130
 * 	  Section: 303
 *	  Author:  Chandler Newman-Reed
 *	  Date: 1/24/2017
 *	  Data fields:  date: OurDate - date of event
 *					time: OurTime - time of event
 *					description: String - description of event
 *    Methods:  default constructor - initilizes fields  
 *				inputEvent(Scanner, String): boolean - asks for input of date and time and description of event
 *              toString(): String - returns string of an event
 *              getDate(): OurDate - returns date of event
 *              getTime(): OurTime - returns time of event
 *              isEqual(Event): boolean - returns true of event matches current event based on date and time
 */
import java.util.Scanner;

public class Event {
	
	private OurDate date;
	
	private OurTime time;
	
	private String description;
	
	public Event(){
		date = new OurDate();
		time = new OurTime();
		description = "";
	}
	
	public boolean inputEvent(Scanner input, String prompt){
		if(!date.inputDate(input, prompt))
			return false;
		if(!time.inputTime(input, prompt))
			return false;
		if(prompt.charAt(0) == 'y'){
			System.out.println("\nEnter event description: ");
		}
		description = input.next();
		return true;
	}
	
	public OurDate getDate(){
		return date;
	}
	
	public OurTime getTime(){
		return time;
	}
	
	public String toString(){
		return "  " + date.toString() + " " + time.toString() + " " + description;
	}
	
	public boolean isEqual(Event event){
		if(event.getDate().isEqual(date)){
			if(event.getTime().isEqual(time)){
				return true;
			}
		}
		return false;
	}
}

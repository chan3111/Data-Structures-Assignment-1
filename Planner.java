/**   Name: Planner.java
 * 	  Purpose: This class models a planner.
 * 	  Course: CST8130
 * 	  Section: 303
 *	  Author:  Chandler Newman-Reed
 *	  Date: 1/24/2017
 *	  Data fields:  events: int[] - stores the events made by the user 
 *                  numEvents: int - value of events currently in the planner
 *                  MAX_EVENTS: int - maximum events allowed in planner
 *    Methods:  default constructor - initilizes event array with MAX_EVENTS 
 *				inputEvent(Scanner, String): boolean - sets type of event to add based on user input, 
 *              deleteEvent(OurDate, OurTime): boolean - deletes an event at a given date and time
 *              displayOneDay(OurDate): void - display events of a certain date
 *				displaySevenDays(OurDate): void - displays events for a week starting at a certain date
 */
import java.util.Scanner;

public class Planner {
	
	private Event events[];
	
	private int numEvents;
	
	private final int MAX_EVENTS = 1000;
	
	public Planner(){
		events = new Event[MAX_EVENTS];
		numEvents = 0;
	}
	
	public boolean inputEvent(Scanner input, String prompt){
		int type = 0;
		
		if(numEvents >= MAX_EVENTS){
			System.out.println("Maximum events entered, planner full");
			return false;
		}
		
		do{
			if(prompt.charAt(0) == 'y'){
				System.out.println("\nEnter the event type to add: ");
				System.out.println(" 1 for a meeting event");
				System.out.println(" 2 for a school event");
				System.out.println(" 3 for a work event");
				System.out.print(" 4 for a social event  ");
			}
			
			
			if(input.hasNextInt()){
				type = input.nextInt();
				if(type < 1 || type > 4 && prompt.charAt(0) != 'y'){
					System.out.println("Invalid event type");
					return false;
				}
			}
			else {
				System.out.println("Invalid event type");
				input.next();
				if(prompt.charAt(0) != 'y')
					return false;
			}
		} while (type < 1 || type > 4);
		
		switch(type){
		case 1:
			events[numEvents] = new Meeting();
			break;
		case 2:
			events[numEvents] = new School();
			break;
		case 3:
			events[numEvents] = new Work();
			break;
		case 4:
			events[numEvents] = new Social();
			break;
		}
			
		if(!events[numEvents].inputEvent(input, prompt)){ 
			events[numEvents] = null;
			return false;
		}
		
		for(int i = 0; i < numEvents; i++){
			if(events[i] != null){
				if(events[numEvents].isEqual(events[i])){
					System.out.println("You already have an activity for that date and time ... cannot be entered");
					events[numEvents] = null;
					break;
				}
			}
		}
		
		if(events[numEvents] != null)
			++numEvents;
		
		return true;
	}
	
	public boolean deleteEvent(OurDate date, OurTime time){
		boolean deleted = false;
		for(int i = 0; i < numEvents; i++){
			if(events[i] != null){
				if(events[i].getDate().isEqual(date)){
					if(events[i].getTime().isEqual(time)){
						events[i] = null;
						System.out.println("\nEvent deleted.");
						deleted = true;
					}
				}
			}
		}
		
		if(!deleted)
			System.out.println("No event at that date/time");
		return true;
	}
	
	public void displayOneDay(OurDate date){
		System.out.println("Your activities for " + date.toString() + " are: ");
		for(int i = 0; i < numEvents; i++){
			if(events[i] != null){
				if(events[i].getDate().isEqual(date)){
					System.out.println(events[i]);
				}
			}
		}
	}
	
	public void displaySevenDays(OurDate date){
		System.out.println("Your activities for the week starting " + date.toString() + " are: ");
		for(int j = 0; j < 7; j++){
			System.out.println("Your activies for " + date + " are: ");
			for(int i = 0; i < numEvents; i++){
				if(events[i] != null){
					if(events[i].getDate().isEqual(date)){
						System.out.println(events[i]);
					}
				}
			}
			date.addOne();
			System.out.println();
		}
	}
}

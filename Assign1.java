/**   Name: Assign1.java
 * 	  Purpose: This class contains a main method to run the planner application..
 * 	  Course: CST8130
 * 	  Section: 303
 *	  Author:  Chandler Newman-Reed
 *	  Date: 1/24/2017
 *	  Data fields:  none
 *    Methods:  main - provides a menu to run a planner application
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Assign1 {

	public static void main(String[] args) {
		Scanner input = null;
		Planner planner = new Planner();
		OurDate date;
		while(true){
			input = new Scanner(System.in);
			
			System.out.println("Enter 1 to add an event to planner from keyboard;");
			System.out.println("2 to display events for a day;");
			System.out.println("3 to display events for a week;");
			System.out.println("4 to delete an event;");
			System.out.println("5 to add events to a planner from a file;");
			System.out.print("0 to quit: ");
			try{
				switch(input.nextInt()){
				case 0:
					if(input!=null)
						input.close();
					return;
				case 1:
					planner.inputEvent(input, "y");
					break;
				case 2:
					date = new OurDate();
					date.inputDate(input, "y");
					planner.displayOneDay(date);
					break;
				case 3:
					date = new OurDate();
					date.inputDate(input, "y");
					planner.displaySevenDays(date);
					break;
				case 4:
					date = new OurDate();
					OurTime time = new OurTime();
					System.out.println("Enter date and time of event to delete: \n");
					date.inputDate(input, "y");
					time.inputTime(input, "y");
					planner.deleteEvent(date, time);
					break;
				case 5:
					String file;
					System.out.println("\nEnter name of file to process: ");
					file = input.next();
					try{
						input = new Scanner(new File(file));
					} catch (NullPointerException ex){
						System.out.println("Error opening file. Ensure the filename is correct.");
						break;
					} catch (FileNotFoundException ex){
						System.out.println("Error opening file. Ensure the file exists.");
						break;
					}
					while(input.hasNext())
						if(!planner.inputEvent(input, "n")) break;
					break;
				default:
					System.out.println("Invalid input");
					break;	
				}
			} catch (InputMismatchException ex){
				System.out.println("Invalid input");
			}
			
			System.out.println();
		}
	}
}

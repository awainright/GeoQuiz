package sourceCode;
/**
 * @author Adam Wainright
 */

import java.io.*;
import java.util.*;

public class DemoProgram {
	public static Scanner kbd = new Scanner(System.in);
	

	private static Athlete createAthlete() {
		
		int		set;
		String	fname,lname,gender;
		
		System.out.println("Please enter the Athlete's first name.\n");
		fname = kbd.next();
		System.out.print(fname);
		System.out.println("Please enter the Athlete's last name.\n");
		lname = kbd.next();
		System.out.println("Please enter the Athlete's gender.(M/F/U)\n");
		gender = kbd.next();
		System.out.println(gender);
		Athlete a = new Athlete(fname,lname,gender);
		System.out.println("Please enter the Athlete's clean weight\n");
		set = kbd.nextInt();
		a.setClean(set);
		System.out.println("Please enter the Athlete's snatch weight\n");
		set = kbd.nextInt();
		a.setSnatch(set);
		System.out.println("Please enter the Athlete's back-squat weight\n");
		set = kbd.nextInt();
		a.setBackSquat(set);
		System.out.println("Please enter the Athlete's Deadlift weight\n");
		set = kbd.nextInt();
		a.setDeadlift(set);
		System.out.println("Please enter the Athlete's row time\n");
		set = kbd.nextInt();
		a.setRow(set);
		System.out.println("Please enter the Athlete's run time\n");
		set = kbd.nextInt();
		a.setRun(set);
		System.out.println("Please enter the Athlete's body weight\n");
		set = kbd.nextInt();
		a.setBodyWeight(set);
		System.out.println("Auto-calculating FitScore\n");
		a.FitScoreCal();
		return a;
		
		
		
	}
	
	public static void main(String[] args) {
		boolean control = true;
		int 	classControl;
		PrintWriter outStream =null;
		try {
				outStream = new PrintWriter("data.txt");
		}
		catch(IOException e) {
			System.out.println("Error.\n");
			System.exit(1);
		}
		
		Scanner inStream = null;
		
		try {
				inStream = new Scanner(new File("data.txt"));
			}
		catch (FileNotFoundException e){
				System.out.println("File not found.\n");
				System.exit(1);
					
			}
		do {
			System.out.println("\t\t**MAIN MENU**\n\nPlease choose by"
					+ "entering the preceding number.\n\n"
					+ "[0]: Add Athlete."
					+ "\n[1]: Exit.");
			classControl = kbd.nextInt();
			
			if(classControl == 0) {
				System.out.println("You choose option1.\n");
				Athlete a = createAthlete();
				outStream.println(a);
				
				
			}
			else {
				System.out.println("Goodbye...");
				control = false;
			}
			
		}while(control);
		outStream.close();
		
		
		

	}
	

}

package sourceCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo2 {
	
	static Scanner kbd = new Scanner(System.in);
	
	//Creates athlete
	private static Athlete createNewAthlete() 
	{
		System.out.println("First name: ");
		String first = kbd.next();
		System.out.println("Last name: ");
		String last = kbd.next();
		System.out.println("Gender (M/F/U): ");
		String gender = kbd.next();
		System.out.println("Clean: ");
		char com = 'y';
		int cl = kbd.nextInt();
		System.out.println("Snatch: ");
		int sn = kbd.nextInt();
		System.out.println("Backsquat: ");
		int bs = kbd.nextInt();
		System.out.println("Deadlift: ");
		int dl = kbd.nextInt();
		System.out.println("Row: ");
		int ro = kbd.nextInt();
		System.out.println("Run: ");
		int ru = kbd.nextInt();
		System.out.println("Bodyweight: ");
		int bw = kbd.nextInt();
		Athlete a = new Athlete(first, last, gender, com, cl, sn, bs, dl, ro, ru, bw);
		return a;
		
	}
	

	public static void main(String[] args) throws IOException {
		int control = 0;
		
		while (control == 0)
		{
			System.out.println("Please choose one of the following: \n\n1.) Athlete\n2.) Coach\n3.) Quit");
			int choice1 = kbd.nextInt();
			PrintWriter outStream =null;
			Athlete a = null;
		
			if (choice1 == 1)
			{
				a = createNewAthlete();
		
				try {
					outStream = new PrintWriter(new FileOutputStream("athletes.txt", true));
					outStream.print(a.toString());
				}
				catch(IOException e) {
					System.out.println("Error");
					System.exit(1);
				}
				System.out.println("Information recorded\n");
			}
			else if (choice1 == 2)
			{
				int control2 = 0;
				Coach c = new Coach();
				while (control2 == 0)
				{
					System.out.println("Please choose one of the following: \n\n1.) Search for athlete\n2.) "
							+ "Add athlete\n3.) Remove athlete\n4.) Show all compliant athletes\n5.) Quit");
					int choice2 = kbd.nextInt();
					if (choice2 == 1)
					{
						System.out.println("Athletes first name: ");
						String first = kbd.next();
						System.out.println("Athletes last name: ");
						String last = kbd.next();
						Athlete temp = c.searchForAthlete(first, last);
						if (temp == null)
						{
							System.out.println("\nAthlete not found");
						}
						else
						{
							System.out.println("\nAthlete found:");
							System.out.println(temp.toString());
						}
					}
					else if (choice2 == 2)
					{
						Athlete temp = createNewAthlete();
						c.addAthlete(temp);
					}
					else if(choice2 == 3)
					{
						System.out.println("Athletes first name: ");
						String first = kbd.next();
						System.out.println("Athletes last name: ");
						String last = kbd.next();
						c.removeAthlete(first, last);
					}
					else if(choice2 == 4)
					{
						ArrayList<Athlete> fitScores = c.getFitScores();
						c.printList(fitScores);
					}
					else
					{
						control2 = 1;
					}
					}
				
				}
			else
			{
				control = 1;
			}
			}
		}

}

package sourceCode;
import java.util.*;

/**
 * Coach class creates a list containing athletes with information of each athlete. Methods are used to manipulate
 * the list of athletes by searching for an athlete, adding an athlete, updating an existing athlete, or removing an
 * athlete. This is imported from a textfile (for now) and saved to the same textfile. 
 * @author laneyoung
 *
 */
public class Coach 
{
	public ArrayList<Athlete> athletes = new ArrayList<Athlete>();
	
	/**
	 * searchForAthlete(firstname, lastname) searches the list of athletes based on the name and returns if equals or
	 * null if not found.
	 * @param firstname
	 * @param lastname
	 * @return a (Athlete)
	 */
	public Athlete searchForAthlete(String firstname, String lastname)
	{
		for(int i = 0; i < athletes.size(); i++)
		{
			Athlete a = (Athlete)athletes.get(i);
			if(lastname.contentEquals(a.getLastName()))
			{
				if (firstname.equals(a.getFirstName()))
				{
					return a;
				}
			}
		}
		return null;
	}
	
	/**
	 * addAthlete(...) searches for if the athlete already exists and if the athlete does not exist already in the list then
	 * it will be added by using the constructor. This is only assuming it uses all of the information and not just
	 * the default constructor. A separate addAthlete will have to be made for that. 
	 * @param fn
	 * @param ln
	 * @param gen
	 * @param com
	 * @param cl
	 * @param sn
	 * @param bs
	 * @param dl
	 * @param ro
	 * @param ru
	 * @param bw
	 * @return ture or false
	 */
	public boolean addAthlete(String fn, String ln, String gen, char com, int cl, int sn, int bs, int dl, int ro, int ru, int bw)
	{
		Athlete temp = searchForAthlete(fn, ln);
		if (temp == null)
		{
			Athlete a = new Athlete(fn, ln, gen, com, cl, sn, bs, dl, ro, ru, bw);
			athletes.add(a);
			return true;
		}
		else
		{
			System.out.println("Athlete already exists.");
			return false;
		}
	}
	
	/**
	 * removeAthlete(firstname, lastname) seraches to see if the athlete exists and if it does then it removes it from
	 * the list of athletes under this coach.
	 * @param firstname
	 * @param lastname
	 * @return true or false
	 */
	public boolean removeAthlete(String firstname, String lastname)
	{
		Athlete temp = searchForAthlete(firstname, lastname);
		if (temp == null)
		{
			System.out.println("Athlete not found.");
			return false;
		}
		else
		{
			return athletes.remove(temp);
		}
	}
	
	/**
	 * getFitScores() returns a list of athletes that have information put in and have a valid fitscore. This will not
	 * include athletes that are created from the default constructor. This will only include athletes with usable
	 * data.
	 * @return temp (list of athletes with fitscores)
	 */
	public ArrayList<Athlete> getFitScores()
	{
		ArrayList<Athlete> temp = new ArrayList<Athlete>();
		for(int i = 0; i < athletes.size(); i++)
		{
			Athlete a = (Athlete) athletes.get(i);
			if(a.getFitScore() != 300000)
			{
				temp.add(a);
			}
		}
		return temp;
	}
	
}

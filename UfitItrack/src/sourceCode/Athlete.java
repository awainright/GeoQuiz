package sourceCode;

/**
 * Athlete class contains information on an athlete. It will contain their name, bodyweight, and age along with times/weights
 * from their performance in the gym. This will include their fit-score for that individual using the fit-score algorithm.
 * @author laneyoung
 *
 */
public class Athlete implements Comparable <Athlete>
{
	private String firstname;
	private String lastname;
	private String gender;
	private char compliance;
	private int clean;
	private int snatch;
	private int backsquat;
	private int deadlift;
	private int row;
	private int run;
	private int bodyweight;
	private int fitscore;
	
	/**
	 * Athlete default constructor. First and Last name and gender is all that is needed.
	 */
	public Athlete(String fn, String ln, String gen)
	{
		firstname = fn;
		lastname = ln;
		gender = gen;
		compliance = 'n';
		clean = snatch = backsquat = deadlift = 1;
		row = 900; //15 minutes in seconds
		run = 600; //10 minutes in seconds
		bodyweight = 200; 
		fitscore = 300000; //default number to say they do not have data
	}
	
	/**
	 * Athlete constructor that sets everything if they have a number for each input.
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
	 */
	public Athlete(String fn, String ln, String gen, char com, int cl, int sn, int bs, int dl, int ro, int ru, int bw)
	{
		firstname = fn;
		lastname = ln;
		gender = gen;
		compliance = com;
		clean = cl;
		snatch = sn;
		backsquat = bs;
		deadlift = dl;
		row = ro;
		run = ru;
		bodyweight = bw;
		fitscore = 0;
	}
	
	/**
	 * getFirstName
	 * @return firstname
	 */
	public String getFirstName()
	{
		return firstname;
	}
	
	/**
	 * getLastName
	 * @return lastname
	 */
	public String getLastName()
	{
		return lastname;
	}
	
	/**
	 * getGender returns the initial
	 * @return gender
	 */
	public String getGender()
	{
		return gender;
	}
	
	/**
	 * getCompliance returns y for yes or n for no
	 * @return compliance
	 */
	public char getCompliance()
	{
		return compliance;
	}
	
	/**
	 * getClean
	 * @return clean
	 */
	public int getClean()
	{
		return clean;
	}
	
	/**
	 * getSnatch
	 * @return snatch
	 */
	public int getSnatch()
	{
		return snatch;
	}
	
	/**
	 * getBackSquat
	 * @return backsquat
	 */
	public int getBackSquat()
	{
		return backsquat;
	}
	
	/**
	 * getDeadlift
	 * @return deadlift
	 */
	public int getDeadlift()
	{
		return deadlift;
	}
	
	/**
	 * getRow
	 * @return row
	 */
	public int getRow()
	{
		return row;
	}
	
	/**
	 * getRun
	 * @return run
	 */
	public int getRun()
	{
		return run;
	}
	
	/**
	 * getBodyWeight()
	 * @return bodyweight
	 */
	public int getBodyWeight()
	{
		return bodyweight;
	}
	
	/**
	 * getFitScore()
	 * @return fitscore
	 */
	public int getFitScore()
	{
		return fitscore;
	}
	
	/**
	 * setFirstName(fn) set firstname to param fn.
	 * @param fn 
	 */
	public void setFirstName(String fn)
	{
		firstname = fn;
	}
	
	/**
	 * setLastName(ln) set lastname to param ln.
	 * @param ln
	 */
	public void setLastName(String ln)
	{
		lastname = ln;
	}
	
	/**
	 * setGender(gen) sets gender to gen. 
	 * @param gen
	 */
	public void setGender(String gen)
	{
		gender = gen;
	}
	
	/**
	 * setCompliance(com) sets compliance to com.
	 * @param com
	 */
	public void setCompliance(char com)
	{
		compliance = com;
	}
	
	/**
	 * setClean(cl) sets clean weight to cl. 
	 * @param cl
	 */
	public void setClean(int cl)
	{
		clean = cl;
	}
	
	/**
	 * setSnatch(sn) sets snatch weight to sn. 
	 * @param sn
	 */
	public void setSnatch(int sn)
	{
		snatch = sn;
	}
	
	/**
	 * setBackSquat(bs) sets backsquat weight to bs. 
	 * @param bs
	 */
	public void setBackSquat(int bs)
	{
		backsquat = bs;
	}
	
	/**
	 * setDeadlift(dl) sets deadlift weight to dl. 
	 * @param dl
	 */
	public void setDeadlift(int dl)
	{
		deadlift = dl;
	}
	
	/**
	 * setRow(ro) sets row time in seconds to ro. 
	 * @param ro
	 */
	public void setRow(int ro)
	{
		row = ro;
	}
	
	/**
	 * setRun(ru) sets run time in seconds to ru. 
	 * @param ru
	 */
	public void setRun(int ru)
	{
		run = ru;
	}
	
	/**
	 * setBodyWeight(bw) sets bodyweight in pounds to bw. 
	 * @param bw
	 */
	public void setBodyWeight(int bw)
	{
		bodyweight = bw;
	}
	
	/**
	 * setFitScore(fit) sets fitscore to fit. 
	 * @param fit
	 */
	public void setFitScore(int fit)
	{
		fitscore = fit;
	}
	
	/**
	 * FitScoreCal() calculates the fit score based on the athletes total weight and time of performance accounting
	 * there bodyweight as a parameter. 
	 */
	public void FitScoreCal()
	{
		int weightTotal = this.clean + this.snatch + this.backsquat + this.deadlift;
		int timeTotal = this.row + this.run;
		int x = weightTotal/timeTotal;
		this.fitscore = this.bodyweight/x;
	}
	
	/**
	 * toString() return the athlete's first and last name and their fitness score. 
	 */
	public String toString()
	{
		String name = this.firstname.concat(" "+this.lastname);
		return  "\n\nName: "+name+"\n" + "FitScore: " + this.fitscore +"\nInformation: \nGender:"+
				this.gender+"\nClean weight: "+this.clean+"\nSnatch weight: "+this.snatch+
				"\nBack Squat: "+this.backsquat+"\nDeadlift: "+this.deadlift+"\nRow: "+this.row+
				"\nRun time: "+this.run+"\nBodyweight: "+this.bodyweight;
	}
	
	/**
	 * equals(obj) returns true if two athletes have the same first and last name otherwise it returns false.
	 */
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		if (obj instanceof Athlete)
		{
			Athlete temp = (Athlete)obj;
			if (this.lastname.equals(temp.lastname))
			{
				return (this.firstname.equals(temp.firstname));
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * compareTo(a) returns the order based on last name of an athlete. 
	 */
	public int compareTo(Athlete a)
	{
		return this.lastname.compareTo(a.lastname);
	}
	
}

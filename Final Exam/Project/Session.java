/**
 * Class Session to represent a training session
 * @author Houria Oudghiri
 * Date of creation: December 10, 2021
 */
public class Session{
	private String code; // Code of the session
	private String title; // Title of the session
	private int time;   // duration of the session in minutes
	private double fee; // cost of the session
	private int members;// Number of members enrolled for the session
	/**
	 * Class constructor
	 * @param c: Code of the training session
	 * @param t: Title of the training session
	 * @param ti: Time, in minutes, of the training session
	 * @param f: Fee, in dollars, of the training session
	 * initializes members to 0
	 */
	public Session(String c, String t, int ti, double f) {
		code = c;
		title = t;
		time = ti;
		fee = f;
		members = 0;
	}
	/**
	 * Method to get the code the session
	 * @return code of the session
	 */
	public String getCode() {
		return code;
	}
	/**
	 * Method to get the title the session
	 * @return title of the session
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * Method to get the duration the session
	 * @return time of the session
	 */
	public int getTime() {
		return time;
	}
	/**
	 * Method to get the fee of the session
	 * @return fee for the session
	 */
	public double getFee() {
		return fee;
	}
	/**
	 * Method to get the number of members enrolled in the session
	 * @return number of enrolled members
	 */
	public int getMembers() {
		return members;
	}
	/**
	 * Method to modify the value of the session code
	 * @param c new code for the session
	 */
	public void setCode(String c) {
		code = c;
	}
	/**
	 * Method to modify the value of the session title
	 * @param t new title for the session
	 */
	public void setTitle(String t) {
		title = t;
	}
	/**
	 * Method to modify the value of the session duration
	 * @param t new duration of the session
	 */
	public void setTime(int t) {
		time = t;
	}
	/**
	 * Method to modify the value of the session fee
	 * @param f new fee of the session
	 */
	public void setFee(double f) {
		fee = f;
	}
	/**
	 * Method to modify the number of members enrolled in the session
	 * @param m number of members enrolled in the session
	 */
	public void setMembers(int m) {
		members = m;
	}
	/**
	 * increments the number of enrolled members
	 */
	public void addMember() {
		members++;
	}
	
	/**
	 * Method toString()
	 * @return the attributes of the session as a formatted string
	 */
	public String toString() {
		String out;
		out = String.format("%-5s\t%-25s\t%-10d\t%-10.2f\t%-5d",
				code, title, time, fee, members);
		return out;
	}
	/**
	 * Method equals()
	 * @param o Object being compared to this session
	 * @return true if the two sessions have the same code
	 */
	public boolean equals(Object o) {
		if(o instanceof Session) {
			Session c = (Session) o;
			return code.equals(c.code);
		}
		return false;
	}
}

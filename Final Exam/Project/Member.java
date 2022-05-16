import java.util.LinkedList;
/**
 * Class Member to model a member of the gym
 * implements the interface Comparable
 * @author Houria Oudghiri
 * Date of creation: December 10, 2021
 */
public class Member implements Comparable<Member>{
	private String id; // member id
	private String name;// member full name
	private LinkedList<String> sessions;// List of the sessions the member is enrolled in 
										// (code sessions only)
	/**
	 * Class Constructor
	 * @param id: id of the member
	 * @param name: name of the member
	 * creates an empty linked list for the sessions
	 */
	public Member(String id, String name) {
		this.id = id;
		this.name = name;
		sessions = new LinkedList<>();
	}
	/**
	 * Method to remove a session from the list of sessions 
	 * the member is enrolled in
	 * @param c the code the session to be removed
	 * list sessions is unchanged if the member is not enrolled in the session c
	 */
	public boolean findSession(String c) {
		return sessions.contains(c);
	}
	
	/**
	 * Method to add a session to the list of sessions 
	 * the member is enrolled in
	 * @param c the code the added session
	 */
	public void addSession(String c) {
		sessions.add(c);
	}
	/**
	 * Method to remove a session from the list of sessions 
	 * the member is enrolled in
	 * @param c the code the session to be removed
	 * list sessions is unchanged if the member is not enrolled in the session c
	 */
	public void removeSession(String c) {
		sessions.remove(c);
	}
	/**
	 * Method to return the list of sessions the member is enrolled in
	 * @return list of session codes
	 */
	public LinkedList<String> getSessions(){
		return sessions;
	}
	/**
	 * Method toString to return the attributes of a member as a formatted string
	 * @return attributes of the member (id, name, and list of sessions)
	 */
	public String toString() {
		String out = String.format("%-10s\t%-20s\t%-20s", 
				id, name, sessions);
		return out;
	}
	/**
	 * Method equals to compare two Member objects for equality
	 * @param o object being compared to this member
	 * @return true if the two Member objects have the same member id
	 */
	public boolean equals(Object o) {
		if(o instanceof Member) {
			Member m = (Member) o;
			return id.equals(m.id);
		}
		return false;
	}
	/**
	 * Method compareTo to order two Member objects 
	 * @param m member being compared to this member
	 * @return 0 if the two members have the same id
	 *         > 0 if the id of this member is after the id of m
	 *         < 0 if the if of this member is before the id of m
	 */
	public int compareTo(Member m) {
		return id.compareTo(m.id);
	}
}


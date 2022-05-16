/**
 * Class UserInfo to hold the attributes of a user
 * @author Houria Oudghiri
 * Date of creation: December 10, 2021
 */
public class UserInfo {
	private String id;
	private String username;
	private String password;
	/**
	 * Class Constructor
	 * @param id the user's id
	 * @param un the user name
	 * @param pw the user password
	 */
	public UserInfo(String id, String un, String pw) {
		this.id = id;
		username = un;
		password = pw;	
	}
	/**
	 * Method to get the user id
	 * @return the user id
	 */
	public String getID() {
		return id;
	}
	/**
	 * Method to get the user's username
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * Method to get the user's password
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Method to modify the user id
	 * @param id the new user id
	 */
	public void setID(String id) {
		this.id = id;
	}
	/**
	 * Method to modify the username
	 * @param id the new username
	 */
	public void setUsername(String un) {
		username = un;
	}
	/**
	 * Method to modify the password
	 * @param id the new password
	 */
	public void setPassword(String pw) {
		password = pw;
	}
	/**
	 * Method toString
	 * Returns the attributes of the user as a string
	 */
	public String toString() {
		return id + "\t" + username + "\t" + password;
	}
	/**
	 * Method equals
	 * @override equals from class Object
	 * @param o Object to compare to this user
	 * @return true if the usernames of two users are identical
	 */
	public boolean equals(Object o) {
		if(o instanceof UserInfo) {
			UserInfo u = (UserInfo) o;
			return u.username.equals(username);
		}
		return false;
	}
}

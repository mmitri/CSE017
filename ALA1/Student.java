/***
 * Class to model the entity Student
 * @author Mark Mitri
 * @version 0.2
 * Date of creation: August 30, 2021
 * Last Date Modified: September 1, 2021
 */

public class Student extends Person{
    // Data members
    private int id;
    private String major;
    /***
     * Default constructor
     * Inherits the super class Person
     * No parameters
     * Initializes id to integer 0 and major to string "undeclared"
     */
    public Student(){
        super();
        id=0; major="undeclared";
    }
    /***
     * Constructor with six parameters
     * @param name for the name of the student
     * @param address for the address of the student
     * @param phone for the phone number of the student
     * @param email for the email address of the student
     * @param id for the id of the student
     * @param major for the major of the student
     */
    public Student(String name, String address, String phone, String email, int id, String major){
        super(name, address, phone, email);
        this.id = id;
        this.major = major;
    }
    /***
     * Getter for the id of the student
     * No parameters
     * @return the value of the data member id
     */
    public int getID(){
        return id;
    }    
    /*** 
     * Getter for the major of the student
     * No parameters
     * @return the value of the data member major
     */
    public String getMajor(){
        return major;
    }
    /***
     * Setter for the id of the student
     * @param id to set the data member id
     * No return value
     */
    public void setID(int id){
        this.id = id;
    }
    /***
     * Setter for the major of the student
     * @param major to set the data member major
     * No return value
     */
    public void setMajor(String major){
        this.major = major;
    }
    /***
	 * Method to get the student information
	 * No parameters
	 * @return formatted string containing the value of the data members
	 */
    public String toString(){
        return super.toString() + String.format("ID: %d\nMajor: %s\n,", id, major );
    }
}

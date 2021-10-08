/***
 * Class to model the entity Lab
 * @author Mark Mitri
 * @version 0.3
 * Date of creation: August 28, 2021
 * Last Date Modified: September 10, 2021
 */

public class Lab extends Room{
    // Data members
    private int computers;
    /***
     * Default constructor
     * Inherits the super class Room
     * No parameters
     * Initializes computers to the integer 0
     */
    public Lab(){
        super();
        computers = 0;
    }
    /***
     * Constructor with four parameters
     * @param number for the number of the Lab
     * @param capacity for the capacity of the Lab
     * @param area for the area of the Lab
     * @param computers for the computers of the Lab
     */
    public Lab(String number, int capacity, int area, int computers){
        super(number, capacity, area);
        this.computers = computers;
    }
    /***
     * Getter for the computer of the Lab
     * No parameters
     * @return the value of the data member computers
     */
    public int getComputers(){
        return computers;
    }
    /***
     * Setter for the computer of the Lab
     * @param computers to set the data member computers
     * No return value
     */
    public void setComputers(int computers){
        this.computers = computers;
    }
    /***
	 * Method to get the Lab information
	 * No parameters
	 * @return formatted string containing the value of the data members
	 */
    public String toString(){
        return String.format("%-15s\t%s\t%d", "Lab", super.toString(), computers);
    }
}

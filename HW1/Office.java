/***
 * Class to model the entity Office
 * @author Mark Mitri
 * @version 0.1
 * Date of creation: August 28, 2021
 * Last Date Modified: September 1, 2021
 */

public class Office extends Room{
    // Data members
    private String owner;
    /***
     * Default constructor
     * No parameters
     * Initializes owner to the string "n/a"
     */
    public Office(){
        super();
        owner = "n/a";
    }
    /***
     * Constructor with four parameters
     * Inherits the super class Room
     * @param number for the number of the office
     * @param capacity for the capacity of the office
     * @param area for the area of the office
     * @param owner for the owner of the office
     */
    public Office(String number, int capacity, int area, String owner){
        super(number, capacity, area);
        this.owner = owner;
    }
    /***
     * Getter for the owner of the office
     * No parameters
     * @return the value of the data member owner
     */
    public String getOwner(){
        return owner;
    }
    /***
     * Setter for the owner of the office
     * No return value
     * @param owner to set the data member owner
     */
    public void setOwner(String owner){
        this.owner = owner;
    }
    /***
	 * Method to get the Office information
	 * No parameters
	 * @return formatted string containing the value of the data members
	 */
    public String toString(){
        return super.toString() + String.format("       %s",owner);
    }
}

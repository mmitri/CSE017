/***
 * Class to model the entity Classroom
 * @author Mark Mitri
 * @version 0.3
 * Date of creation: August 28, 2021
 * Last Date Modified: September 10, 2021
 */

public class Classroom extends Room{
    /***
     * Default constructor
     * No parameters
     * Inherits the super class Room
     */
    public Classroom(){
        super();
    }
    /***
     * Constructor with three parameters
     * @param number for the number of the Classroom
     * @param capacity for the capacity of the Classroom
     * @param area for the area of the Classroom
     */
    public Classroom(String number, int capacity, int area){
        super();
    }
    /***
	 * Method to get the Classroom information
	 * No parameters
	 * @return formatted string containing the value of the data members
	 */
    public String toString(){
        return String.format("%-15s\t%s", "Classroom", super.toString());
    }
    /***
     * Method to return a simple string
     * No parameters
     * @return an unformatted string with attributes of the room
     */
    public String simpleString(){
        return String.format(" \t", "Classroom", super.toString());
    }
}

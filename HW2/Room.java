/***
 * Class to model the entity Room
 * @author Mark Mitri
 * @version 0.3
 * Date of creation: August 28, 2021
 * Last Date Modified: September 10, 2021
 */

public class Room {
    // Data members
    private String number;
    private int capacity, area;
    /***
     * Default constructor
     * No parameters
     * Initializes name to the string "n/a" and capacity and area to the integer 0
     */
    public Room(){
        number = "n/a"; capacity = area = 0;
    }
    /***
     * Constructor with three parameters
     * @param number for the number of the room
     * @param capacity for the capacity of the room
     * @param area for the area of the room
     */
    public Room(String number, int capacity, int area){
        this.number = number;
        this.capacity = capacity;
        this.area = area;
    }
    /***
     * Getter for the number of the room
     * No parameters
     * @return the value of the data member number
     */
    public String getNumber(){
        return number;
    }
    /***
     * Getter for the capacity of the room
     * No parameters
     * @return the value of the data member capacity
     */
    public int getCapacity(){
        return capacity;
    }
    /***
     * Getter for the area of the room
     * No parameters
     * @return the value of the data member area
     */
    public int getArea(){
        return area;
    }
    /***
     * Setter for the number of the room
     * @param number to set the data member number
     * No return value
     */
    public void setNumber(String number){
        this.number = number;
    }
    /***
     * Setter for the capacity of the room
     * @param capacity to set the data member capacity
     * No return value
     */
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    /***
     * Setter for the area of the room
     * @param area to set the data member area
     * No return value
     */
    public void setArea(int area){
        this.area = area;
    }
    /***
	 * Method to get the Room information
	 * No parameters
	 * @return formatted string containing the value of the data members
	 */
    public String toString(){
        return String.format("%-10s\t%-10d\t%-10d", number, capacity, area);
    }
    /***
     * Method to return a simple string
     * No parameters
     * @return an unformatted string with attributes of the room
     */
    public String simpleString(){
        return String.format(" \t \t", number, capacity, area);
    }
}

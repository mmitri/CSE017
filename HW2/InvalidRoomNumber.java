/***
 * Class to model the entity InvalidRoomNumber which extends Exception
 * @author Mark Mitri
 * @version 0.3
 * Date of creation: August 28, 2021
 * Last Date Modified: September 10, 2021
 */
public class InvalidRoomNumber extends Exception{
    /***
     * Default constructor
     * No parameters
     * Inherits the super class with the message "Invalid Room Number"
     */
    public InvalidRoomNumber(){
        super("Invalid Room Number");
    }
    /***
     * Constructor with one parameter
     * @param message for the message of the return
     */
    public InvalidRoomNumber(String message){
        super(message);
    }
}

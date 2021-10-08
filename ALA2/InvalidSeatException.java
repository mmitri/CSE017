/***
 * Class to model the entity InvalidSeatException
 * which extends the class Exception
 * @author Mark Mitri
 * @version 0.1
 * Date of creation: September 7, 2021
 * Last Date Modified: September 7, 2021
 */

public class InvalidSeatException extends Exception{
    /***
     * Default constructor
     * No parameters
     * Inherits the super class with the message "Invalid Seat"
     */
    public InvalidSeatException(){
        super("Invalid Seat");
    }
    /***
     * Constructor with one parameter
     * @param message for the message of the return
     */
    public InvalidSeatException(String message){
        super(message);
    }
}


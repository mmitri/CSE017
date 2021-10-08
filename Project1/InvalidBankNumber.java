/***
 * Class to model the entity InvalidBankNumber
 * which extends the class Exception
 * @author Mark Mitri
 * @version 0.1
 * Date of creation: September 21, 2021
 * Last Date Modified: September 21, 2021
 */

public class InvalidBankNumber extends Exception{
    /***
     * Default constructor
     * No parameters
     * Inherits the super class with the message "Invalid Bank Number"
     */
    public InvalidBankNumber(){
        super("Invalid Bank Number");
    }
    /***
     * Constructor with one parameter
     * @param message for the message of the return
     */
    public InvalidBankNumber(String message){
        super(message);
    }
}
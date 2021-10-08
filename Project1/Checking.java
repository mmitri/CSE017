/***
 * Class to model the entity Checking which extends BankAccount
 * @author Mark Mitri
 * @version 0.1
 * Date of creation: September 21, 2021
 * Last Date Modified: September 22, 2021
 */
public class Checking extends BankAccount{
    // No data members
    private String bankType;
    /***
     * Default constructor
     * No parameters
     * Inherits the super class BankAccount
     */
    public Checking(){
        super();
        bankType = "N/a";
    }
    /***
    * Constructor with three parameters
    * Inherits the super class BankAccount
    * @param bankType for the type of bank account
    * @param accountNum for the account number of the bank account
    * @param owner for the owner of the bank account
    * @param balance for the amount of money in the bank account
    */
    public Checking(String bankType, int accountNum, String owner, double balance){
        super();
        this.bankType = bankType;
    }
    public String getbankType(){
        return bankType;
    }
    public void setbankType(String bankType){
        this.bankType = bankType;
    }
    /***
     * Method to get the Checking information
     * No parameters
     * @return formatted string containing the value of the data members
     */
    public String toString(){
        return String.format("%-15s\t%s\t%d", "Checking", super.toString());
    }
}

/***
 * Class to model the entity Savings which extends BankAccount
 * @author Mark Mitri
 * @version 0.1
 * Date of creation: September 21, 2021
 * Last Date Modified: September 22, 2021
 */
public class Savings extends BankAccount{
    // Data member
    private double interest;
    /***
     * Default constructor
     * No parameters
     * Initializes interest to the integer 0
     */
    public Savings(){
        super();
        interest = 0.0;
    }
    /***
     * Constructor with four parameters
     * @param accountNum for the account number of the bank account
     * @param balance for the amount of money in the account
     * @param owner for the owner of the account
     * @param interest for the amount of monthly interest
     */
    public Savings(String bankType, int accountNum, String owner, double balance, double interest){
        super();
        this.interest = interest;
    }
    /***
     * Getter for the interest of the bank account
     * No parameters
     * @return the value of the data member interest
     */
    public double getInterest(){
        return interest;
    }
    /***
     * Setter for the interest of the bank account
     * No return value
     * @param interest to set the data member interest
     */
    public void setInterest(double interest){
        this.interest = interest;
    }
    public void applyMonthlyInterest(){
        balance = balance + (balance*(interest/12));
    }
    /***
     * Method to get the Savings informations
     * No parameters
     * @return formatted string containing the value of the data members
     */
    public String toString(){
        return String.format("%-15s\t%s\t%d", "Savings", super.toString(), interest);
    }
}

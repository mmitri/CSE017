/***
 * Class to model the entity BankAccount
 * Implements Comparable for the type Rational
 * @author Mark Mitri
 * @version 0.2
 * Date of creation: September 21, 2021
 * Last Date Modified: September 26, 2021
 */

abstract class BankAccount implements Closable{
    // Data members
    public int accountNum;
    public double balance;
    public String owner;
    /***
     * Default Constructor
     * No paramerters
     * Initializes accountNum and balance to the integer 0
     * Initializes owner to the string "N/a"
     */
    public BankAccount(){
        accountNum = 0;
        balance = 0.0;
        owner = "N/a";
    }
    /***
     * Constructor with three parameters
     * @param accountNum for the account number of the bank account
     * @param balance for the amount of money in the account
     * @param owner for the owner of the account
     */
    public BankAccount(int accountNum, double balance, String owner){
        this.accountNum = accountNum;
        this.balance = balance;
        this.owner = owner;
    }
    /***
     * Getter method getAccountNum
     * No parameters
     * @return the value accountNum
     */
    public int getAccountNum(){
        return accountNum;
    }
    /***
     * Getter method getBalance
     * No parameters
     * @return the value balance
     */
    public double getBalance(){
        return balance;
    }
    /***
     * Getter method getOwner
     * No parameters
     * @return the value owner
     */
    public String getOwner(){
        return owner;
    }
    /***
     * Setter method setOwner with one parameter
     * @param owner for the owner of the bank account
     */
    public void setOwner(String owner){
        this.owner = owner;
    }
    public double withdraw(double amount){
        balance = balance - amount;
        return balance;
    }
    public double deposit(double amount){
        balance = balance + amount;
        return balance;
    }
    public boolean isClosable(){
        if(getBalance() > 200.00){
            return true;
        }else{
            return false;
        }
    }
    /***
     * Method toString to format the return statement
     * No parameters
     * @return a formatted string with the data members
     */
    public String toString(){
        return String.format("%-10d\t%-10s\t%-10d",accountNum,owner,balance);
    }
}
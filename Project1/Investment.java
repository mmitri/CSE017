/***
 * Class to model the entity Investment which extends BankAccount
 * @author Mark Mitri
 * @version 0.2
 * Date of creation: September 21, 2021
 * Last Date Modified: September 26, 2021
 */

public class Investment extends BankAccount{
    // Data members
    private String investmentType, bankType;
    /***
     * Default constructor
     * No parameters
     * Initializes property, growth, and shares to the string "N/a"
     */
    public Investment(){
        super();
        investmentType = bankType = "N/a";
    }
    /***
     * Constructor with six parameters
     * Inherits the super class BankAccount
     * @param accountNum for the account number
     * @param balance for the amount of money in the account
     * @param owner for the owner of the account
     * @param property for the type of investment
     * @param growth for the type of investment
     * @param shares for the type of investment
     */
    public Investment(String bankType, int accountNum, String owner, double balance, String investmentType){
        super();
        this.bankType = bankType;
        this.investmentType = investmentType;
    }
    public String getBankType(){
        return bankType = "Investment";
    }
    /***
     * Getter for the property type of the investment
     * No parameters 
     * @return the value of the data member property
     */
    public String getProperty(){
        return investmentType = "Property";
    }
    /***
     * Getter for the growth type of the investment
     * No parameters 
     * @return the value of the data member property
     */
    public String getGrowth(){
        return investmentType = "Growth";
    }
    /***
     * Getter for the shares type of the investment
     * No parameters 
     * @return the value of the data member property
     */
    public String getShares(){
        return investmentType = "Shares";
    }
    public void setBankType(String bankType){
        this.bankType = "Investment";
    }
    /***
     * Setter for the property type of investment
     * No return value
     * @param investmentType to set the data member to property
     */
    public void setProperty(String investmentType){
        this.investmentType = "Property";
    }
    /***
     * Setter for the growth type of investment
     * No return value
     * @param investmentType to set the data member to growth
     */
    public void setGrowth(String investmentType){
        this.investmentType = "Growth";
    }
    /***
     * Setter for the shares type of investment
     * No return value
     * @param investmentType to set the data member to shares
     */
    public void setShares(String investmentType){
        this.investmentType = "Shares";
    }
    public int applyInvestmentRisk(){
        // updates the balance and returns a boolean indicating if there was a profit or a loss
        double prob = (Math.random() * 1) + 0.1;
        if(prob >= 0.5){
            double profit = (Math.random() * (balance*0.05)) + (balance*0.01);
            balance = balance + profit; 
            return 1;
        }else{
            double loss = (Math.random() * (balance*0.05)) + (balance*0.01);
            balance = balance - loss; 
            return -1;
        }
    }
    /***
     * Method to get the Investment information
     * No parameters
     * @return formatted string containing the value of the data members
     */
    public String toString(){
        return String.format("%-15s\t%-15s\t%-15s\t", bankType, super.toString(),investmentType);
    }
}

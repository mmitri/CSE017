/***
 * Class to model the entity Faculty
 * @author Mark Mitri
 * @version 0.2
 * Date of creation: August 30, 2021
 * Last Date Modified: September 1, 2021
 */

public class Faculty extends Employee{
    // Data members
    private String rank;
    /***
     * Defult constructor
     * No parameters
     * Inherits the super class Person
     * Initializes rank to the string "rank"
     */
    public Faculty(){
        super();
        rank = "rank";
    }
    /***
     * Constructor with eight parameters
     * @param name for the name of the faculty
     * @param address for the address of the faculty
     * @param phone for the phone number of the faculty
     * @param email for the email of the faculty
     * @param id for the id of the faculty 
     * @param position for the position of the faculty
     * @param salary for the salary of the faculty
     * @param rank for the rank of the faculty
     */
    public Faculty(String name, String address, String phone, String email, int id, String position, double salary, String rank){
        super(name, address, phone, email, id, position, salary);
        this.rank = rank;
    }
    /***
     * Getter for the rank of the faculty
     * No parameters
     * @return the vaule of the data member rank
     */
    public String getRank(){
        return rank;
    }
    /***
     * Setter for the rank of the faculty
     * No return value
     * @param rank to set the data member rank
     */
    public void setRank(String rank){
        this.rank = rank;
    }
    /***
    * Method to get the Faculty information
    * No parameters
    * @return formatted string containing the value of the data members
    */
    public String toString(){
        return super.toString() + String.format("Rank: %s\n", rank);
    }
}
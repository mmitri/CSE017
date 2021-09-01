/***
 * Class to model the entity Employee
 * @author Mark Mitri
 * @version 0.2
 * Date of creation: August 30, 2021
 * Last Date Modified: September 1, 2021
 */

public class Employee extends Person{
    // Data members
    private int id;
    private String position;
    private double salary;
    /***
     * Default constructor
     * No parameters
     * Inherits the super class Person
     * Initializes id to integer 0, position to string "position", and salary to double 100000.00
     */
    // Constructors
    public Employee(){
        super();
        id = 0; position="position"; salary = 100000.00;
    }
    /***
     * Constructor with seven parameters
     * @param name for the name of the employee
     * @param address for the address of the employee
     * @param phone for the phone number of the employee
     * @param email for the email address of the employee
     * @param id for the id of the employee
     * @param position for the position of the employee
     * @param salary for the salary of the employee
     */
    public Employee(String name, String address, String phone, String email, int id, String position, double salary){
        super(name, address, phone, email);
        this.id = id;
        this.position = position;
        this.salary = salary;
    }
    /***
     * Getter for the id of the employee
     * No parameters
     * @return the value of the data member id
     */
    public int getID(){
        return id;
    }
    /***
     * Getter for the position of the employee
     * No parameters
     * @return the value of the data member position
     */
    public String getPostion(){
        return position;
    }
    /***
     * Getter for the salary of the employee
     * No parameters
     * @return the value of the data member salary
     */
    public double getSalary(){
        return salary;
    }
    /***
     * Setter for the id of the employee
     * No return value
     * @param id to set the data member id
     */
    public void setID(int id){
        this.id = id;
    }
    /***
     * Setter for the position of the employee
     * No return value
     * @param position to set the data member position
     */
    public void setPosition(String position){
        this.position = position;
    }
    /***
     * Setter for the salary of the employee
     * No return value
     * @param salary to set the data member salary
     */
    public void setSalary(double salary){
        this.salary = salary;
    }
    /***
     * Method to get the Employee information
     * No parameters
     * @return formatted string containing the value of the data members
     */
    public String toString(){
        return super.toString() + String.format("ID: %d\nPostion: %s\nSalary: $%.2f\n", id,position,salary);
    }
}
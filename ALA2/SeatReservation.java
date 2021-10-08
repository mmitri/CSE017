/***
 * Main method SeatReservation
 * Calls the classes Airplane and InvalidSeatException
 * Writes to a text file seatsmap.txt
 * @author Mark Mitri
 * @version 0.1
 * Date of creation: September 7, 2021
 * Last Date Modified: September 7, 2021
 */

import java.util.Scanner;

public class SeatReservation{
    public static void main(String[] args){
        // Extentiate the class Airplane with the file seatsmap.txt
        Airplane myAirplane = new Airplane("seatsmap.txt");
        // Initializing the user operation
        int operation = 0;
        String seat;
        Scanner keyboard = new Scanner(System.in);
        // Do-while block to continuously run the program until user exits
        do{
            try{
                // Print the menu
                System.out.println(myAirplane.toString());
                printMenu();
                // Ask for user input
                operation = keyboard.nextInt();
                // Switch case to handle different options
                switch(operation){
                    case 1: // Reserve a seat
                        System.out.println("Enter a seat number:");
                        seat = keyboard.next();
                        if(myAirplane.reserveSeat(seat)){
                            System.out.println("Seat " + seat + " successfully reserved.");
                        }else{
                            System.out.println("Seat " + seat + " already reserved.");
                        }
                        break;
                    case 2: // Free a seat
                        System.out.println("Enter a seat number:");
                        seat = keyboard.next();
                        if(myAirplane.freeSeat(seat)){
                            System.out.println("Seat " + seat + " successfully freed.");
                        }else{
                            System.out.println("Seat " + seat + " already freed.");
                        }
                        break;
                    case 3: // Quit the program
                        myAirplane.saveMap("seatsmap.txt");
                        break;
                    default:
                        System.out.println("Invalid operation. Must be 1-3");
                }
            }catch(InvalidSeatException e){
                System.out.println(e.getMessage());
            }
        }while(operation != 3);
        keyboard.close();
        System.out.println("Wasn't that fun!");
    }
    /***
     * Method to print the menu
     * No parameters
     */
    public static void printMenu(){
        System.out.println("Select an operation: ");
        System.out.println("1: Reserve a seat");
        System.out.println("2: Free a seat");
        System.out.println("3: Quit");
    }
}
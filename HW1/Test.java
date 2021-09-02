/***
 * Main method Test to print, sort, and find the Rooms
 * @author Mark Mitri
 * @version 0.1
 * Date of creation: August 28, 2021
 * Last Date Modified: September 1, 2021
 */
import java.util.Scanner;

public class Test {
    /***
     * Method printRooms: Printing the array list
     * @param list to reference the array list
     * No return value
     * Prints a formatted header
     * Uses a for loop to run through the size of the array
     * Prints the list on a different line
     */
    public static void printRooms(Room[] list){
        System.out.println("Type        Number     Capacity   Area     Owner/Computers");
        for(int i=0; i<list.length;i++){
            System.out.println(list[i].getClass().getSimpleName() + list[i].toString());
        }
    }
    /***
     * Method findRooms: Searching for a room
     * @param list to reference the array list
     * @param roomNumber for user input
     * @param keyboard to reference the Scanner class
     * @return the index of the room or a -1 if the room does not exist
     * Finds the length of the array
     * Traverses the array within a while loop
     * If the k-th element is the user's input roomNumber
     * then return the index and print the room information
     * Else, return -1
     */
    public static int findRooms(Room[] list, String roomNumber, Scanner keyboard){
        int length = list.length;
        int k = 0;
        System.out.println(" ");
        System.out.println("Enter the room number:");
        roomNumber = keyboard.next();
        while(k < length){
            if(list[k].getNumber().equals(roomNumber)){
                System.out.println(" ");
                System.out.println("Room found: " + list[k].getClass().getSimpleName() + list[k].toString());
                return k;
            }
            else {
                k++;
            }
        }
        System.out.println("Error 404: Room not found.");
        return -1;
    }
    /***
     * Method sortRooms: Sorting the rooms by capacity
     * @param list to reference the array list
     * No return value
     * Uses two for loops and inserts element i into the sorted sub-list
     * Shifts element (j-1) into element (j)
     * Inserts currentVal at position j
     */
    public static void sortRooms(Room[] list){
        for (int i=1; i<list.length; i++) {
            Room currentVal = list[i];
            int j = i-1;
            while (j >= 0 && list[j].getCapacity() > currentVal.getCapacity()){
                list[j+1] = list[j];
                j--;
            }
            list[j+1] = currentVal;
            }
    }
    /***
     * Method printMenu: Prints the menu for the user
     * @param keyboard to reference the Scanner class
     * @return the value of the user's input as a char in menuOption
     * Prints the options on a different line
     * Asks the user for a character
     */
    public static char printMenu(Scanner keyboard){
        System.out.println(" ");
        System.out.println("Select an operation:");
        System.out.println("1: Find a room");
        System.out.println("2: View all rooms");
        System.out.println("3: Sort rooms");
        System.out.println("4: exit");
        System.out.println("Choose an option: ");
        char menuOption = keyboard.next().charAt(0);
        return menuOption;
    }
    public static void main(String[] args){
        // Scanner class called keyboard
        Scanner keyboard = new Scanner(System.in);
        // Variables
        boolean rightMenu = false;
        char menuOption = 'Z';
        String roomNumber = " ";
        // Array rooms creates an array of type Room and size five
        Room[] rooms = new Room[5];
        rooms[0] = new Lab("PA-110", 65, 150, 45);
        rooms[1] = new Office("PA-252", 2, 36, "Houria Oudghiri");
        rooms[2] = new Lab("PA-202", 45, 100, 25);
        rooms[3] = new Room("PA-101", 20, 45);
        rooms[4] = new Lab("PA-100", 47, 120, 40);
        // While loop to run the user's options
        while(!rightMenu){
            menuOption = printMenu(keyboard);
            if(menuOption == '4'){
                System.out.println("Until next time!");
                rightMenu = true;
            }
            if(menuOption == '1'){
                findRooms(rooms, roomNumber, keyboard);
            }
            if(menuOption == '2'){
                printRooms(rooms);
            }
            if(menuOption == '3'){
                sortRooms(rooms);
                printRooms(rooms);
            }
        }
        keyboard.close();
    }
}

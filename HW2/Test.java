/***
 * Main method Test to print, sort, and find the Rooms
 * @author Mark Mitri
 * @version 0.4
 * Date of creation: August 28, 2021
 * Last Date Modified: September 15, 2021
 */
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Test {
    /***
     * Method printRooms: Printing the array list
     * @param list to reference the array list
     * No return value
     * Prints a formatted header
     * Uses a for loop to run through the size of the array
     * Prints the list on a different line
     */
    public static void printRooms(Room[] list, int count){
        System.out.println("Type            Number          Capacity        Area            Owner/Computers");
        for(int i=0; i<count;i++){
            System.out.println(list[i].toString());
        }
    }
    /***
     * Method readFile: Reading the text file
     * @param fileName for the name of the file
     * @param list to reference the array list
     * @param count for the size of the array
     * @throws FileNotFoundException if the user has not inputted the correct type of room
     * Creates an instance of the file and array list
     * Try block to run through the length of the array
     * Check the type of room, then creates an array based of the textfile
     */
    public static void readFile(String fileName, Room[] list, int count) throws FileNotFoundException{
        File file = new File(fileName);
        String roomNumber, owner;
        int capacity, area, computers;
        try{
            Scanner readFile = new Scanner(file);
            for(int i=0;i<count;i++){
                while(readFile.hasNext()){
                    String roomType = readFile.next();
                    if(roomType == "Office"){
                        roomNumber = readFile.next();
                        capacity = readFile.nextInt();
                        area = readFile.nextInt();
                        owner = readFile.next() + "" + readFile.next();
                        list[count] = new Office(roomNumber, capacity, area, owner);
                        count = count + 1;
                    }else if(roomType == "Classroom"){
                        roomNumber = readFile.next();
                        capacity = readFile.nextInt();
                        area = readFile.nextInt();
                        list[count] = new Classroom(roomNumber, capacity, area);
                        count = count + 1;
                    }else if(roomType == "Lab"){
                        roomNumber = readFile.next();
                        capacity = readFile.nextInt();
                        area = readFile.nextInt();
                        computers = readFile.nextInt();
                        list[count] = new Lab(roomNumber, capacity, area, computers);
                        count = count + 1;
                    }else{
                        System.out.println("Error 13: Room type mismatch");
                    }
                }
            }
            readFile.close();
        }catch(FileNotFoundException e){

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
    public static int findRooms(Room[] list, int count, String roomNumber, Scanner keyboard){
        int length = count;
        int k = 0;
        System.out.println(" ");
        System.out.println("Enter the room number:");
        roomNumber = keyboard.next();
        while(k < length){
            if(list[k].getNumber().equals(roomNumber)){
                System.out.println(" ");
                System.out.println("Room found: " + list[k].toString());
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
    public static void sortRooms(Room[] list, int count){
        for (int i=1; i<count; i++) {
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
     * Method checkRoomNumber: Using RegEx to check if a room is present
     * @param roomNumber for the user's input of a room number
     * @param count for the size of the array within rooms.txt
     * @return a boolean 
     */
    public static boolean checkRoomNumber(String roomNumber) throws InvalidRoomNumber{
        System.out.println("We are in the CheckRoomNumber method");
        if(roomNumber.matches("[A-Z][A-Z][1-9][1-9][1-9]")){
            return true;
        }else{
            throw new InvalidRoomNumber("Invalid Room Number. Should be letter[A-Z], letter[A-Z], number[1-9], number[1-9], number[1-9]");
        }
    }
    /**
     * Method addRoom: Adds a room after checking if it is already present
     * @param roomNumber for the user's input of a room number
     * @param count for the size of the array within rooms.txt
     * @param keyboard from the Scanner
     * @return a boolean
     * @throws InvalidRoomNumber if the room is not of the type Room class
     */
    public static boolean addRoom(String roomNumber, int count, Scanner keyboard) throws InvalidRoomNumber{
        if(checkRoomNumber(roomNumber)){
            System.out.println("Enter the type of the room (Lab, Office, Classroom): ");
            String roomType = keyboard.next();
            System.out.println("This is your roomtype: " + roomType);
        }else{
            throw new InvalidRoomNumber("Invalid Room type. Must be of type Office, Lab, or Classroom.");
        }
        return false;
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
        System.out.println("1: View all rooms");
        System.out.println("2: Find a room");
        System.out.println("3: Add a new room");
        System.out.println("4: Remove an existing room");
        System.out.println("5: Sort rooms by capacity");
        System.out.println("6: Exit");
        System.out.println("Choose an option: ");
        char menuOption = keyboard.next().charAt(0);
        return menuOption;
    }
    public static void main(String[] args) throws InvalidRoomNumber, FileNotFoundException{
        // Scanner class called keyboard
        Scanner keyboard = new Scanner(System.in);
        // Variables
        int count = 10;
        boolean rightMenu = false;
        char menuOption = 'Z';
        String roomNumber = " ";
        // Array rooms creates an array of type Room and size five
        Room[] rooms = new Room[50];
        readFile("newRooms", rooms, count);
        // While loop to run the user's options
        while(!rightMenu){
            menuOption = printMenu(keyboard);
            if(menuOption == '6'){
                System.out.println("Until next time!");
                rightMenu = true;
            }
            if(menuOption == '1'){
                printRooms(rooms, count);
            }
            if(menuOption == '2'){
                findRooms(rooms, count, roomNumber, keyboard);
            }
            if(menuOption == '3'){
            // Add a room
                System.out.print("Enter a room number: ");
                roomNumber = keyboard.next();
                if(addRoom(roomNumber, count, keyboard)){

                }
            }
            if(menuOption == '4'){
                // Remove a room
                System.out.println("Enter a room number to be removed: ");
                roomNumber = keyboard.next();
                if(checkRoomNumber(roomNumber) == true){
                    // Search for that roomNumber
                    int k = 0;
                    while(k < count){
                        if(rooms[k].getNumber().equals(roomNumber)){
                            // delete the room
                            System.out.println("Deleted the room.");
                            k = count;
                            count = count - 1;
                        }
                    }
                }
            }
            if(menuOption == '5'){
                sortRooms(rooms, count);
            }
        }
        keyboard.close();
    }
}

/***
 * Main method to run a bank account program
 * @author Mark Mitri
 * @version 0.5
 * Date of creation: September 21, 2021
 * Last Date Modified: September 26, 2021
 */

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Bank {
    /***
     * Method addAccount: Create a new bank account
     * 
     * @param keyboard for user's input
     * @param bankAccounts to reference the array of bank accounts
     * @param count for the size of the array
     * @param accountNumber for the accout number of the bank account
     * @return void
     * When the user wants to create a bank account,
     * they input first the type of bank account.
     * This dictates the following prompts.
     * Uses Scanner class for inputs.
     * Assigns inputs to variables.
     * Creates a new array member with those variables.
     */
    public static void addAccount(Scanner keyboard, BankAccount[] list, int count, int accountNumber){
        String owner, bankType, investmentType;
        int accountNum;
        double balance, interest;
        System.out.println("Enter an account type (Checking/Savings/Investment): ");
        if(keyboard.hasNext()){
            bankType = keyboard.next();
            if(bankType.equals("Checking")){
                System.out.println("Enter the owner's name (First and Last name): ");
                owner = keyboard.next();
                System.out.println("Enter the initial balance: ");
                balance = keyboard.nextDouble();
                accountNum = (int) (Math.random() * 999999) + 000001;
                list[count++] = new Checking(bankType,accountNum,owner,balance);
            }else if(bankType.equals("Savings")){
                System.out.println("Enter the owner's name(First and Last name): ");
                owner = keyboard.next();
                System.out.println("Enter the initial balance: ");
                balance = keyboard.nextDouble();
                System.out.println("Enter the yearly interest: ");
                interest = keyboard.nextDouble();
                accountNum = (int) (Math.random()*999999) + 000001;
                list[count++] = new Savings(bankType, accountNum, owner, balance, interest);
            }else if(bankType.equals("Investment")){
                System.out.println("Enter the owner's name(First and Last name): ");
                owner = keyboard.next();
                System.out.println("Enter the initial balance: ");
                balance = keyboard.nextDouble();
                System.out.println("Enter the investment type (Property/Growth/Shares): ");
                investmentType = keyboard.next();
                accountNum = (int) (Math.random()*999999) + 000001;
                list[count++] = new Investment(bankType, accountNum, owner, balance, investmentType);
            }  
        }
    }
    /***
     * Method findAccount: Find a bank account
     * @param list to reference the array of bank accounts
     * @param count for the size of the array
     * @param accountNumber for the account number of the bank account
     * @return an integer representing whether or not a bank account was found
     * A for loop runs through the array, looking for a match with the user's input and a bank account number
     */
    public static int findAccount(BankAccount[] list, int count, int accountNumber){
        for(int i=0;i<count;i++){
            if(list[i].getAccountNum() == accountNumber){
                return i;
            }
        }
        return -1;
    }
    /***
     * Method printAccounts: Printing the array bankAccounts
     * @param list to reference the array of bank accounts
     * @param count for the size of the array
     * @return void
     * Prints a formatted header
     * Uses a for loop to run through the size of the array
     * Prints the list on a different line
     */
    public static void printAccounts(BankAccount[] list, int count){
        System.out.println("Type    Account #    Owner    Balance    Interest/Investment Type");
        for(int i=0; i<count; i++){
            System.out.println(list[i]);
        }
    }
    /***
     * Method sortRooms: Sorting the bank accounts by their balance
     * @param list to reference the array of bank accounts
     * @param count for the size of the array
     * @return void
     * Uses two for loops and inserts element i into the sorted sub-list
     * Shifts element (j-1) into element (j)
     * Inserts currentVal at position j
     */
    public static void sortAccounts(BankAccount[] list, int count){
        for(int i=1;i<count;i++){
            BankAccount currentVal = list[i];
            int j = i-1;
            while(j >= 0 && list[j].getBalance() > currentVal.getBalance()){
                list[j+1] = list[j];
                j--;
            }
            list[j+1] = currentVal;
        }
    }
    /***
     * Method readFile: Reading the text file
     * @param fileName for the name of the file
     * @param list to reference the array of bank accounts
     * @param count to reference the size of the array
     * @throws FileNotFoundException if the user's inputted file is not found
     * Creates an instance of the file and array, list
     * Try block to run through the length of the array
     * Check the type of room, then creates an array based of the textfile
     */
    public static int readFile(String fileName, BankAccount[] list, int index) throws FileNotFoundException{
        File file = new File(fileName);
        String owner, bankType, investmentType;
        int accountNum;
        double balance, interest;
        try{
            Scanner readFile = new Scanner(file);
                while(readFile.hasNext()){
                    bankType = readFile.next();
                    accountNum = readFile.nextInt();
                    owner = readFile.next();
                    balance = readFile.nextDouble();
                    if(bankType.equals("Checking")){
                        list[index++] = new Checking(bankType, accountNum, owner, balance); 
                    }else if(bankType.equals("Savings")){
                        interest = readFile.nextDouble();
                        list[index++] = new Savings(bankType, accountNum, owner, balance, interest);
                    }else if(bankType.equals("Investment")){
                        investmentType = readFile.next();
                        list[index++] = new Investment(bankType, accountNum, owner, balance, investmentType);
                    }else{
                        System.out.println("Error 13: Room type mismatch");
                    }
                }
            readFile.close();
        }catch(FileNotFoundException e){
            System.out.println("Error 404: File not found. Please enter a valid file name.");
            System.exit(0);
        }
        return index;
    }
    /***
     * Method printMenu: Prints the menu for the user
     * @param keyboard to reference the Scanner class
     * @return the value of the user's input as a char in menuOption
     * Prints the options on a different line
     * Asks the user for a character
     */
    public static char printMenuOption(Scanner keyboard){
        System.out.println(" ");
        System.out.println("Select an operation:");
        System.out.println("1: Find Account");
        System.out.println("2: Add Account");
        System.out.println("3: Remove Account");
        System.out.println("4: View Accounts");
        System.out.println("5: View Closable Accounts");
        System.out.println("6: Sort Accounts");
        System.out.println("7: Exit");
        System.out.println("Choose an option: ");
        char menuOption = keyboard.next().charAt(0);
        return menuOption;
    }
    public static char printAccountOption(Scanner keyboard){
        System.out.println(" ");
        System.out.println("Select an operation:");
        System.out.println("1: Check Balance");
        System.out.println("2: Withdraw");
        System.out.println("3: Deposit");
        System.out.println("4: Apply Monthly Interest");
        System.out.println("5: Apply Investment Risk");
        System.out.println("6: Go Back to the Main Menu");
        System.out.println("Choose an option: ");
        char menuOption = keyboard.next().charAt(0);
        return menuOption;
    }
    /***
     * Method saveToFile: Saving the file
     * @param bankAccounts to reference the array of bank accounts
     * @param count for the size of the array
     * @param fileName for the name of the file
     * @return void
     * Uses PrintWriter class to write to a file and close it.
     */
    public static void saveToFile(BankAccount[] list, int count, String fileName){
        File file = new File(fileName);
        try{
            PrintWriter writeFile = new PrintWriter(file);
            for(int i=0;i<count;i++){
                writeFile.println(list[i].toString());
            }
            writeFile.close();
        }catch(FileNotFoundException e){
            System.out.println("Error 1003: Cannot write to file.");
        }
    }
    public static void main(String[] args) throws InvalidBankNumber, FileNotFoundException{
        Scanner keyboard = new Scanner(System.in);
        BankAccount[] bankAccounts = new BankAccount[50];
        int accountNumber = 000000, index = 0;
        boolean rightMenu = false, rightAccountMenu = false;
        char menuOption = 'Z', accountOption = 'Z';

        int count = readFile("accounts.txt", bankAccounts, index);
        printAccounts(bankAccounts,count);

        while(!rightMenu){
            menuOption = printMenuOption(keyboard);
            if(menuOption == '7'){
                // Save and exit the program
                System.out.println("Thanks for shopping at Mark's bank. Have a great day!");
                saveToFile(bankAccounts,count,"accounts.txt");
                rightMenu = true;
            }
            if(menuOption == '1'){
                // Find an existing account
                System.out.println("Enter an account number: ");
                int foundAccount = findAccount(bankAccounts,count,accountNumber);
                if(foundAccount != 1){
                    while(!rightAccountMenu){
                        accountOption = printAccountOption(keyboard);
                        if(accountOption == '6'){
                            // Go back to the main menu
                            rightAccountMenu = true;
                        }
                        if(accountOption == '1'){
                            // Check Balance
                            System.out.println("Balance: $" + bankAccounts[foundAccount].getBalance());
                        }
                        if(accountOption == '2'){
                            // Withdraw
                            System.out.println("Enter the amount you want to withdraw: ");
                            double withdraw = keyboard.nextDouble();
                            if(bankAccounts[foundAccount].getBalance() < withdraw){
                                System.out.println("Withdraw failed. You do not have enough money.");
                            }else{
                                bankAccounts[foundAccount].withdraw(withdraw);
                                System.out.println("Withdrawl completed. New balance: $" + bankAccounts[foundAccount].getBalance());
                            }
                        }
                        if(accountOption == '3'){
                            // Deposit
                            System.out.println("Enter the amount you want to deposit: ");
                            double deposit = keyboard.nextDouble();
                            bankAccounts[foundAccount].deposit(deposit);
                            System.out.println("Deposit completed. New balance: $" + bankAccounts[foundAccount].getBalance());
                        }
                        if(accountOption == '4'){
                            /*** Apply Monthly Interest
                             *   if(Account == savings){
                             *      apply the interest
                             *   }else{
                             *      System.out.println("Invalid operation. Not a savings account");
                             *   }
                            */
                        }
                        if(accountOption == '5'){
                            /*** Apply Investment Risk
                             *   if(Account == investment){
                             *      apply the investment risk
                             *   }else{
                             *      System.out.println("Invalid operation. Not an investment account");
                             *   }
                            */
                        }
                    }
                }else{
                    System.out.println("Error 404: Account not found.");
                }
            }
            if(menuOption == '2'){
                // Add an account
                addAccount(keyboard, bankAccounts, count, accountNumber);
            }
            if(menuOption == '3'){
                // Remove an account
                System.out.println("Enter an account number to be removed (6 digits): ");
                if(keyboard.hasNextInt()){
                    accountNumber = keyboard.nextInt();
                    int foundAccount = findAccount(bankAccounts,count,accountNumber);
                    if(foundAccount != -1){
                        System.out.println("Account found: " + bankAccounts[foundAccount]);
                        for(int i=foundAccount;i<count-1;i++){
                            bankAccounts[i] = bankAccounts[i+1];
                        }
                        count = count -1;
                        System.out.println("Bank Account removed successfully");
                    }else{
                        System.out.println("Error 404: Bank Account not found.");
                    }
                    
                }
            }
            if(menuOption == '4'){
                // View accounts
                printAccounts(bankAccounts,count);
            }
            if(menuOption == '5'){
                // View closable accounts
                // Closable accounts are those under $200
                for(int i=0;i<count;i++){
                    if(bankAccounts[i].isClosable() == true){
                        printAccounts(bankAccounts, count);
                    }
                }
            }
            if(menuOption == '6'){
                // Sort accounts by balance
                sortAccounts(bankAccounts,count);
            }
        }
        keyboard.close();
    }
}
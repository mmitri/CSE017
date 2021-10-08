/***
 * Class to model the entity Airplane
 * @author Mark Mitri
 * @version 0.1
 * Date of creation: September 7, 2021
 * Last Date Modified: September 7, 2021
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Airplane{
    // Data members
    private char[][] seatMap;
    /***
     * Default constructor
     * No parameters
     * Initializes seatMap as a 9x8 char array with elements '.'
     */
    public Airplane(){
        seatMap = new char[9][8];
        for(int i=0;i<seatMap.length;i++){
            for(int j=0;j<seatMap[i].length;j++){
                seatMap[i][j] = '.';
            }
        }
    }
    /***
     * Constructor with one parameter
     * @param filename for the name of the file
     * Assigns the char array seatMap
     * Calls the method readMap
     */
    public Airplane(String filename){
        seatMap = new char[9][8];
        readMap(filename);
    }
    /***
     * Method with one parameter
     * @param filename for the name of the file
     * Creates a file with the filename
     * Initializes a try/catch block to read the file for a char at position 1
     */
    private void readMap(String filename){
        File file = new File(filename);
        try{
            Scanner readFile = new Scanner(file);
            for(int i=0;i<seatMap.length;i++){
                for(int j=0;j<seatMap[i].length;j++){
                    seatMap[i][j] = readFile.next().charAt(0);
                }
            }
            readFile.close();
        }catch(FileNotFoundException e){
            for(int i=0;i<seatMap.length;i++){
                for(int j=0;j<seatMap[i].length;j++){
                    seatMap[i][j] = '.';
                }
            }
        }
    }
    /***
     * Constructor with three parameters
     * @param seat for the name of the user input
     * @return a boolean if seat matches the regular expresion
     * @throws InvalidSeatException if seat does not match the regular expresion
     * and says "invalid seat"
     */
    private boolean checkSeat(String seat) throws InvalidSeatException{
        if(seat.matches("[1-9][A-H]")){
            return true;
        }else{
            throw new InvalidSeatException("Invalid Seat Number. Should be row[1-9], column[A-H]");
        }
    }
    /***
     * Constructor with three parameters
     * @param seat for the name of the user input
     * @return a boolean if the seat is free or not
     * @throws InvalidSeatException if seat is not free
     * and throws "invalid seat"
     */
    public boolean reserveSeat(String seat) throws InvalidSeatException{
        if(checkSeat(seat)){
            int row = seat.charAt(0) - '1';
            int column = seat.charAt(1) - 'A';
            if(seatMap[row][column] == '.'){ // Seat is free
                seatMap[row][column] = 'X';
                return true;
            }else{
                return false;
            } 
        }
        return false;
    }
    /***
     * Constructor with three parameters
     * @param seat for the name of the user input
     * @return a boolean if there is a free seat or not
     * @throws InvalidSeatException if there is not a reserved seat
     * and throws "invalid seat"
     */
    public boolean freeSeat(String seat) throws InvalidSeatException{
        if(checkSeat(seat)){
            int row = seat.charAt(0) - '1';
            int column = seat.charAt(1) - 'A';
            if(seatMap[row][column] == 'X'){ // Seat is reserved
                seatMap[row][column] = '.';
                return true;
            }else{
                return false;
            } 
        }
        return false;
    }
    /***
     * Constructor with one parameter
     * @param filename for the name of the file
     * No return
     * Saves the map of the airplane seats to the file
     */
    public void saveMap(String filename){
        File file = new File(filename);
        try{
            PrintWriter writeFile = new PrintWriter(file);
            for(int k=0;k<seatMap.length;k++){
                for(int l=0;l<seatMap[k].length;l++){
                    writeFile.print(seatMap[k][l] + " ");
                }
                writeFile.println();
            }
            writeFile.close();
        }catch(FileNotFoundException e){
            System.out.println("Cannot write to " + filename + ".");
        }
    }
    /***
     * Method to get the airplane information
     * No parameters
     * @return formatted string containing the rows and collumns of the airplane
     */
    public String toString(){
        String output = "\tA\tB\tC\tD\tE\tF\tG\tH\n";
        for(int m=0;m<seatMap.length;m++){
            output += (m+1) + "\t";
            for(int n=0;n<seatMap[m].length;n++){
                output += seatMap[m][n] + "\t";
            }
            output += "\n";
        }
        return output;
    }
}
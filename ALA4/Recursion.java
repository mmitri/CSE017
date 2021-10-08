/***
 * Main class Recursion to find files within a directory 
 * and find a word within a file
 * @author Mark Mitri under supervision of Prof. Odghiri at Lehigh University
 * @version 0.1
 * Date of creation: September 21, 2021
 * Last Date Modified: September 21, 2021
 */

import java.io.File;
import java.util.Scanner;
import java.io.*;

public class Recursion{
    /***
     * Method searchFile to search for a file in the computer's directory
     * Creates an instance of the file with its path, checks if it is a directory and
     * looks through the path for a file with the name filename
     * @param path for the computer file path
     * @param filename for the name of the file
     * @return the path of the filename
     */
    public static String searchFile(String path, String filename){
        File dir = new File(path);
        if(!dir.isDirectory()){
            return "";
        }else{
            // Createan array with the filepaths
            File[] files = dir.listFiles();
            // Loop through the length of the array files
            for(int i=0;i<files.length;i++){
                if(files[i].isFile()){ // is a file
                    // check if the file name is equal to the filename input
                    if(files[i].getName().equals(filename)){
                        // print the path of the file
                        return files[i].getAbsolutePath();
                    }
                }else{ // is a subfile
                    // recursive statement
                    String found = searchFile(files[i].getAbsolutePath(),filename);
                    if(!found.equals("")){
                        return found;
                    }
                }
            }
            return "";
        }
    }
    /***
     * Method findWord to find a word within a file and a path
     * Creates an instance of File with the path
     * Checks if the File(path) is a file
     * calls the method wordCount
     * prints the number of occurences of that word and the path
     * if the File(path) is a directory
     * Creates an array of filepaths and runs through its length to find a file recursively
     * @param path for the file path 
     * @param word for the word to find in the file
     */
    public static void findWord(String path, String word){
        File dir = new File(path);
        if(dir.isFile()){
            //search for word in dir
            int count = wordCount(dir,word);
            if(count != 0){
                System.out.println(word + " appears" + count + " times in the file " + dir.getAbsolutePath());
            }
        }else if(dir.isDirectory()){
            File[] files = dir.listFiles();
            for(int i=0;i<files.length;i++){
                // recursive statement
                findWord(files[i].getAbsolutePath(),word);
            }
        }
        return;
    }
    /***
     * Method wordCount searches a file for the number of occurences of the String word
     * try-catch block to read each line of the file for the word and its index
     * starts at the index 0 and updates the index with the length of the next word
     * @param path for the path of the file
     * @param word for the word to find in the file
     * @return the occurences of the word within the file
     */
    public static int wordCount(File path, String word){
       int count = 0;
       int index = 0;
        try{
           Scanner readFile = new Scanner(path);
           // while there are words in the file...
           while(readFile.hasNextLine()){
               // save the line within String line
               String line = readFile.nextLine();
               index = line.indexOf(word, 0);
               // looking for word in the same line
               while(index != -1){// returns the index of the word
                    count = count + 1;
                    index = line.indexOf(word,index+word.length());
               }
           }
           readFile.close();
       }catch(FileNotFoundException e){
            return count;
       }
       return count;
    }
    /***
     * Main method to take in user input and produce the outputs of the methods
     * @param args
     */
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a directory:");
        String path = keyboard.next();
        System.out.println("Enter a filename:");
        String filename = keyboard.next();
        String output = searchFile(path,filename);
        if(output.equals("")){
            System.out.println("Error 404: File " + filename + " not found");
        }else{
            System.out.println("File " + filename + " found at: " + output);
        }
        System.out.println("Enter a file/directory: ");
        path = keyboard.next();
        System.out.println("Enter a word: ");
        String word = keyboard.next();
        findWord(path,word);
        keyboard.close();
    }
    
}
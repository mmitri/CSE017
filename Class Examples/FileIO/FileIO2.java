import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class FileIO {
    public static void main(String[] args){
        // Reading
        File file = new File("data.txt");
        try{
            Scanner readFile = new Scanner(file);
            for(int i=0;i<4;i++){
                String name = readFile.next();
                int id = readFile.nextInt();
                double gpa = readFile.nextDouble();
                System.out.println("Student" + (i+1) + ":" + name + "\t" + id + "\t" + gpa);
            }
            readFile.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }
        // Writing
        file = new File("output.txt");
        try{
            PrintWriter writeFile = new PrintWriter(file);
            for(int i=0;i<100;i++){
                writeFile.println(i*100);
            }
            writeFile.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Cannot write to file");
            System.exit(0);
        }
    }
}

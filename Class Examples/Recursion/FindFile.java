import java.io.File;
import java.util.Scanner;

public class FindFile{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a directory");
        String startPath = keyboard.next();
        System.out.println("Enter a filename");
        String fileName = keyboard.next();

        keyboard.close();
    }
    public static String searchForFile(String startPath, String fileName){
        File directory = new File(startPath);
        if(!directory.isDirectory()){
            return "";
        }
        File[] directoryFiles = directory.listFiles();
        for(int i=0;i<directoryFiles.length;i++){
            if(directoryFiles[i].isFile()){ // directoryFiles[i] is a file
                if(directoryFiles[i].getName().equals(fileName)){
                    return directoryFiles[i].getAbsolutePath();
                }else{ // files[i] is a directory
                    String path = searchForFile(directoryFiles[i].getAbsolutePath(),fileName);
                    if(!path.equals("")){
                        return path;
                    }
                }
                
            }
        }
    }
}
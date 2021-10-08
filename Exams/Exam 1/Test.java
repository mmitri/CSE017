import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Test {
    public static int readFile(String fileName, Animal[] list, int index) throws FileNotFoundException{
        File file = new File(fileName);
        String animalType, name;
        double weight;
        int lifespan, flyingSpeed;
        try{
            Scanner readFile = new Scanner(file);
                while(readFile.hasNext()){
                    animalType = readFile.next();
                    name = readFile.next();
                    if(animalType.equals("Bat")){
                        weight = readFile.nextDouble();
                        lifespan = readFile.nextInt();
                        flyingSpeed = readFile.nextInt();
                        list[index++] = new Bat(animalType, name, weight, lifespan, flyingSpeed); 
                    }else if(animalType.equals("Bird")){
                        weight = readFile.nextDouble();
                        lifespan = readFile.nextInt();
                        flyingSpeed = readFile.nextInt();
                        list[index++] = new Bird(animalType, name, weight, lifespan, flyingSpeed);
                    }else if(animalType.equals("Cat")){
                        weight = readFile.nextDouble();
                        lifespan = readFile.nextInt();
                        list[index++] = new Cat(animalType, name, weight, lifespan);
                    }else{
                        System.out.println("Error 13: Animal type mismatch");
                    }
                }
            readFile.close();
        }catch(FileNotFoundException e){
            System.out.println("Error 404: File not found. Please enter a valid file name.");
            System.exit(0);
        }
        return index;
    }
    public static void printAnimals(Animal[] list, int count){
        System.out.printf("%-10s\t%-10s\t%-10s\t%-10s\t","Type","Name","Weight[oz]","Lifespan[years]");
        for(int i=0; i<count; i++){
            System.out.println(list[i]);
        }
    }
    public static void printFlyingAnimals(Animal[] list, int count){
        System.out.printf("%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t","Type","Name","Weight[oz]","Lifespan[years]","Flying Speed[mph]");
        for(int i=0;i<count;i++){
            if(list[i] instanceof CanFly){
                System.out.println(((CanFly)list[i]));
            }
        }
    }
    public static char printMenuOption(Scanner keyboard){
        System.out.println(" ");
        System.out.println("Select an operation:");
        System.out.println("1: View all Animals");
        System.out.println("2: View flying animals");
        System.out.println("3: Sort animals by weight");
        System.out.println("4: Exit");
        System.out.println("Choose an option: ");
        char menuOption = keyboard.next().charAt(0);
        return menuOption;
    }
    public static void saveToFile(Animal[] list, int count, String fileName){
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
    public static void main(String[] args) throws InputMismatchException, FileNotFoundException{
        Scanner keyboard = new Scanner(System.in);
        Animal[] kingdom = new Animal[9];
        int index = 0;
        char menuOption = 'Z';
        boolean rightMenu = false;

        int count = readFile("animals.txt",kingdom,index);
        while(!rightMenu){
            menuOption = printMenuOption(keyboard);
            if(menuOption == '4'){
                // Save and exit the program
                System.out.println("That was fun! Until next time.");
                saveToFile(kingdom, count, "animals.txt");
                rightMenu = false;
            }
            if(menuOption == '1'){
                // View all animas 
                // Print the array
                printAnimals(kingdom, count);
            }
            if(menuOption == '2'){
                // View flying animals
                // Comparable?
                printFlyingAnimals(kingdom,count);
            }
            if(menuOption == '3'){
                // Sort animals by weight
                // Sort the array
                Arrays.sort(kingdom);
                // sortAnimals(kingdom, count);
            }
        }
    }
}

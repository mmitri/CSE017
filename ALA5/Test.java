import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Test {
    /***
     * 
     * @param list
     * @param fileName
     */
    public static void readStatesFromFile(ArrayList<Pair<String,String>> list, String fileName){
        File file = new File(fileName);
        try{
            Scanner readFile = new Scanner(file);
            while(readFile.hasNextLine()){
                String line = readFile.nextLine();
                String[] tokens = line.split("\\|");
                Pair<String,String> pStates = new Pair<>(tokens[0],tokens[1]);
                list.add(pStates);
            }
            readFile.close();
        }catch(FileNotFoundException e){
            System.out.println("Error 404: File not found.");
            System.exit(0);
        }
        
    }
    public static void readTreesFromFile(ArrayList<Pair<String,Integer>> list, String fileName){
        File file = new File(fileName);
        try{
            Scanner readFile = new Scanner(file);
            while(readFile.hasNextLine()){
                String line = readFile.next();
                String[] tokens = line.split("\\|");
                Pair<String,Integer> pTrees = new Pair<>(tokens[0],tokens[1]);
                list.add(pTrees);
            }
            readFile.close();
        }catch(FileNotFoundException e){
            System.out.println("Error 404: File not found.");
            System.exit(0);
        }
        
    }
    /***
     * 
     */
    public static<E1,E2> int search(ArrayList<Pair<E1,E2>> list, E1 key){
        for(int i=0;i<list.size();i++){
            E1 f = list.get(i).getFirst(); // get first of the pair at index i
            if(f.equals(key)){
                return i;
            }
        }
        return -1;
    }
    public static void printMenu(){
        System.out.println("____________________________");
        System.out.println("Please select an operation:");
        System.out.println("1: View States");
        System.out.println("2: Search States");
        System.out.println("3: Sort States by name");
        System.out.println("4: Sort States by Capitol");
        System.out.println("5: View Trees");
        System.out.println("6: Search Trees");
        System.out.println("7: Sort Trees by name");
        System.out.println("8: Sort Trees by height");
        System.out.println("9: Exit");
    }
    public static void main(String[] args){
        ArrayList<Pair<String,String>> states = new ArrayList<>(50);
        readStatesFromFile(states,"states.txt");

        ArrayList<Pair<String,Integer>> trees = new ArrayList<>();
        readTreesFromFile(trees,"trees.txt");

        Scanner keyboard = new Scanner(System.in);
        int operation = 0;
        do{
            printMenu();
            operation = Integer.parseInt(keyboard.nextLine());
            switch(operation){
                case 1: //  view the array
                    for(Pair<String,String> p: states){
                        System.out.println(p);
                    }
                    break;
                case 2: // search
                    System.out.println("Enter a State: ");
                    String state = keyboard.nextLine();
                    int indexStates = search(states, state);
                    if(indexStates == -1){
                        System.out.println("Error 404: State Not Found.");
                    }else{
                        System.out.println("State found: " + states.get(indexStates));
                    }
                    break;
                case 3: // Sort by name
                    states.sort(new ComparatorByFirst<>());
                    break;
                case 4: // Sort by capitol
                    states.sort(new ComparatorBySecond<>());
                    break;
                case 5: // View Trees
                    for(Pair<String,Integer> p: trees){
                        System.out.println(p);
                    }
                    break;
                case 6: // Search Tree
                    System.out.println("Enter a Tree: ");
                    String tree = keyboard.nextLine();
                    int indexTrees = search(trees, tree);
                    if(indexTrees == -1){
                        System.out.println("Error 404: Tree Not Found.");
                    }else{
                        System.out.println("Tree found: " + trees.get(indexTrees));
                    }
                    break;
                case 7: // Sort Trees by name
                    trees.sort(new ComparatorByFirst<>());
                    break;
                case 8: // Sort Trees by height
                    trees.sort(new ComparatorBySecond<>());
                    break;
                case 9: // Exit
                    break;
            }
        }while(operation != 9);
        keyboard.close();
    }
}

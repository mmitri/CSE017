/***
 * Main method Test to print and sort the array people
 * @author Mark Mitri
 * @version 0.2
 * Date of creation: August 30, 2021
 * Last Date Modified: September 1, 2021
 */

public class Test {
    public static void main(String[] args){
        // Array of type Person with name people and size 4
        Person[] people = new Person[4];
        // Assigning the indicies
        people[0] = new Person("Helen Brown", "222 10th Street Bethlehem", "610-334-2288", "hbrown@gmail.com");
        people[1] = new Student("Gary Leister", "972 4th Street Allentown", " 610-331-7177", "gleister@gmail.com", 12345, "CSE");
        people[2] = new Employee("Beth Down", "234 Main Street Philadelphia", "484-222-4433", "bdown@gmail.com", 33442, "Systems Administrator", 75000.00);
        people[3] = new Faculty("Mark Jones", "21 Orchid Street Bethlehem", "610-333-2211", "mjones@gmail.com", 22222, "Faculty", 90000.00, "Associate Professor");

        // Printing the Original array
        System.out.println("Original List: ");
        System.out.println("__________________");
        printArray(people);
        // Printing the Sorted array
        System.out.println("Sorted List: ");
        System.out.println("__________________");
        sortArray(people);
        printArray(people);
    }
    /**
     * Method printArray: Printing the array
     * @param list to reference the array people
     * No return value
     * Uses a for loop to run through the size of the array
     * Prints the list on a different line
     */
    public static void printArray(Person[] list){
        for(int i=0; i<list.length; i++){
            System.out.println(list[i]);
        }
    }
    /***
     * Method sortArray: Sorting the array alphabetically
     * @param list to reference the array people
     * Uses two for loops, one to run through the size of the array
     * and one to compare each index with the first index
     */
    public static void sortArray(Person[] list){
        for(int j=0; j<list.length; j++){
            int minIndex = j;
            String minStr = list[j].getName();
            for(int k=j+1; k<list.length;k++){
                if(list[k].getName().compareTo(minStr) < 0){
                    minStr = list[k].getName();
                    minIndex = k;
                }
            }
            if(minIndex != j){
                Person temp = list[minIndex];
                list[minIndex] = list[j];
                list[j] = temp;
            }
        }
    }
    
}

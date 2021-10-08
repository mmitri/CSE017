/***
 * Main class Test to print fractions and the arithmetic operations
 * @author Mark Mitri under supervision of Prof. Odghiri at Lehigh University
 * @version 0.1
 * Date of creation: September 14, 2021
 * Last Date Modified: September 14, 2021
 */

import java.util.Random;

public class Test {
    public static void main(String[] args){
        // Part 1: Manipulating Numbers

        // Create an array of type Number of size 10
        Number[] numbers = new Number[10];
        Random r = new Random();
        // Run through the length of the array
        for(int i=0;i<numbers.length;i++){
            // Switch statement run by the remainder of the modulus operation
            switch(i%5){
                case 0: // Create an integer
                    numbers[i] = r.nextInt(100);
                    break;
                case 1: // Create a long
                    numbers[i] = (long) r.nextInt(10000);
                    break;
                case 2: // Create a float
                    numbers[i] = r.nextFloat()*100;
                    break;
                case 3: // Create a double
                    numbers[i] = r.nextDouble()*10000;
                    break;
                case 4: // Create a rational
                    int n = r.nextInt(10);
                    int d = r.nextInt(10)+1;
                    numbers[i] = new Rational(n,d);
                    break;
            }
        }
        // Print the Array
        for(int i=0;i<numbers.length;i++){
            System.out.println(numbers[i].toString() + "\t\t" + 
                               numbers[i].intValue() + "\t\t" +
                               numbers[i].doubleValue());
        }

        // Part 2: Operations on numbers of type Rational

        // Create an array of type Rational of size 8
        Rational[] fractions = new Rational[8];
        for(int i=0;i<fractions.length;i++){
            int n=r.nextInt(9) + 1;
            int d=r.nextInt(9) + 1;
            fractions[i] = new Rational(n,d);
        }
        // Print the array before the arithmetic operations
        System.out.println("Original list of fractions: ");
        for(int i=0;i<fractions.length;i++){
            System.out.println(fractions[i].toString());
        }
        // Arithmetic operations
        System.out.println("Operation on fractions: ");
        System.out.println(fractions[0].add(fractions[1]));
        System.out.println(fractions[2].add(fractions[3]));
        System.out.println(fractions[4].add(fractions[5]));
        System.out.println(fractions[6].add(fractions[7]));
        System.out.println("Sorting the list of fractions: ");
        // Using Array.sort method to sort the fractions
        java.util.Arrays.sort(fractions);
        // Print the array after the arithmetic operations
        for(int i=0;i<fractions.length;i++){
            System.out.println(fractions[i].toString());
        }
    }
}
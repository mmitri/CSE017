/***
 * Class Rational to manipulate fractions
 * Extends Number and implements Comparable for the type Rational
 * @author Mark Mitri under supervision of Prof. Odghiri at Lehigh University
 * @version 0.1
 * Date of creation: September 14, 2021
 * Last Date Modified: September 14, 2021
 */

public class Rational extends Number implements Comparable<Rational>{
    // Data members
    private int numerator, denominator;
    /***
     * Default Constructor
     * No parameters
     * Initializes numerator to integer 0
     * Initializes denominator to 1 because a 0 denominator is an invalid fraction
     */
    public Rational(){
        numerator = 0;
        denominator = 1;
    }
    /***
     * Constructor Rational with two parameters
     * @param n for the numerator
     * @param d for the denominator
     */
    public Rational(int n, int d){
        numerator = n;
        denominator = d;
        // can implement an exception if d = 0
    }
    /***
     * Getter method getNumerator
     * No parameters
     * @return the value numberator
     */
    public int getNumerator(){
        return numerator;
    }
    /***
     * Getter method getDenominator
     * No parameters
     * @return the value denominator
     */
    public int getDenominator(){
        return denominator;
    }
    /***
     * Setter method setNumerator with one parameter
     * @param n for the numerator
     */
    public void setNumerator(int n){
        numerator = n;
    }
    /***
     * Setter method setDenominator with one parameter
     * @param d for the denominator
     */
    public void setDenominator(int d){
        denominator = d;
    }
    /***
     * Method toString to format the return statements
     * No parameters
     * if statement to @return the formatted string of different conditions
     */
    public String toString(){
        reduce();
        if(denominator == 1){
            return "" + numerator;
        }else if(numerator == 0){
            return "0";
        }else if(denominator < 0){
            return (-numerator) + "/" + (-denominator);
        }else{
            return numerator + "/" + denominator;
        }
    }
    /***
     * Method add with one parameter
     * @param r for the rational value type r
     * @return the value of adding two fractions
     */
    public Rational add(Rational r){
        int sumN = this.numerator*r.denominator+r.numerator*this.denominator;
        int sumD = this.denominator*r.denominator;
        Rational result = new Rational(sumN,sumD);
        result.reduce();
        return result;
    }
    /***
     * Method sub with one parameter
     * @param r for the rational value type r
     * @return the value of subtracting two fractions
     */
    public Rational sub(Rational r){
        int sumN = this.numerator*r.denominator-r.numerator*this.denominator;
        int sumD = this.denominator*r.denominator;
        Rational result = new Rational(sumN,sumD);
        result.reduce();
        return result;
    }
    /***
     * Method mult with one parameter
     * @param r for the rational value type r
     * @return the value of multiplying two fractions
     */
    public Rational mult(Rational r){
        int sumN = this.numerator*r.numerator;
        int sumD = this.denominator*r.denominator;
        Rational result = new Rational(sumN,sumD);
        result.reduce();
        return result;
    }
    /***
     * Method div with one parameter
     * @param r for the rational value type r
     * @return the value of dividing two fractions
     */
    public Rational div(Rational r){
        int sumN = this.numerator*r.denominator;
        int sumD = this.denominator*r.numerator;
        Rational result = new Rational(sumN,sumD);
        result.reduce();
        return result;
    }
    /***
     * Void Method reduce
     * No parameters
     * Reduces the fraction using the Greatest Common Denominator (gcd) method
     */
    private void reduce(){
        int g = gcd();
        numerator /= g;
        denominator /= g;
    }
    /***
     * Method gcd
     * No parameters
     * @return g, the greatest common denominator between the numerator and denominator
     */
    private int gcd(){
        int min = Math.min(numerator, denominator);
        int g = 1;
        for(int i=2;i<=min;i++){
            if(numerator%i==0 && denominator%i==0){ // i is a common divisor
                g = i;
            }
        }
        return g;
    }
    /***
     * Method intValue
     * No parameters
     * @return the fraction as a type integer
     */
    public int intValue(){
        return numerator/denominator;
    }
    /***
     * Method longValue
     * No parameters
     * @return the fraction as the integer type long
     */
    public long longValue(){
        return (long) numerator/denominator;
    }
    /***
     * Method floatValue
     * No parameters
     * @return the fraction as a type float
     */
    public float floatValue(){
        return (float) numerator/denominator;
    }
    /***
     * Method doubleValue
     * No parameters
     * @return the fraction as a type double
     */
    public double doubleValue(){
        return (double) numerator/denominator;
    }
    /***
     * Method compareTo with one parameter
     * @param r for the rational value type r
     * @return if the doubleValue fraction is equal, greater than, or less than
     */
    public int compareTo(Rational r){
        if(this.doubleValue()==r.doubleValue()){
            return 0;
        }else if(this.doubleValue()>r.doubleValue()){
            return 1;
        }else{
            return -1;
        }
    }
}

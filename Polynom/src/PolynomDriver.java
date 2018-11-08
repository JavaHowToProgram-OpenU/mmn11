import java.util.ArrayList;
import java.util.Scanner;

/** mmn11-2b
 * Driver class for the Polynom program.
 * @author Gad Maor
 * @version 1.0
 */
public class PolynomDriver {
    public static void main(String[] args) {
        // ArrayLists for storing the powers and coefficients received from the user
        ArrayList<Integer>  powers = new ArrayList<>();
        ArrayList<Double>  coefficients = new ArrayList<>();
        // Create a Scanner to obtain input from the user
        Scanner input = new Scanner(System.in);
        // Declare the Polynom objects and initialize them to null.
        Polynom polynom1, polynom2;
        polynom1 = polynom2 = null;
        printWelcomeScreen();
        // Get coefficients and powers from user and create Polynom objects
        for (int polynomNumber = 1; polynomNumber < 3; ++polynomNumber) {
            printGetPolynomMessage(polynomNumber);
            int power = 0;
            double coefficient = 0;
            do  {
                coefficient = input.nextDouble();
                power = input.nextInt();
                // We ignore terms with coefficient 0
                if (coefficient == 0 || power < 0){
                    // Flush Scanner's input buffer
                    input.nextLine();
                    continue;
                }
                coefficients.add(new Double(coefficient));
                powers.add(new Integer(power));
            } while (power >= 0);
            // Convert the ArrayLists to Integer and Double arrays for sorting
            Integer powersArray[] = new Integer[powers.size()];
            powers.toArray(powersArray);
            Double[] coefficientsArray = new Double[coefficients.size()];
            coefficients.toArray(coefficientsArray);
            // Sorts the powers and coefficients arrays by ascending powers
            bubbleSortByPowerDescending(powersArray, coefficientsArray);
            if (polynomNumber == 1) {
                polynom1 = new Polynom(coefficientsArray, powersArray);
                System.out.println("The 1st polynom is: " + "p = " + polynom1);
            }
            else {
                polynom2 = new Polynom(coefficientsArray, powersArray);
                System.out.println("The 2nd polynom is: " + "q = " + polynom2);
            }
            // Clean powers and coefficients ArrayLists for next Polynom
            powers.clear();
            coefficients.clear();
        }
        // Print sum of Polynoms.
        System.out.print("\nThe sum of the 2 polynoms is:\np + q = ");
        System.out.println("(" + polynom1 + ")" + " + " +
                           "(" + polynom2 + ")" + " =\n= " + polynom1.plus(polynom2));
        // Print difference of Polynoms.
        System.out.print("\nThe difference of the 2 polynoms is:\np - q = ");
        System.out.println("(" + polynom1 + ")" + " - " +
                "(" + polynom2 + ")" + " =\n= " + polynom1.minus(polynom2));
        // Print derivative of each Polynom.
        System.out.println("\nThe derivative of the 1st polynom is:");
        System.out.println("p' = " + "(" + polynom1 + ")` =\n = " + polynom1.derivate());
        // Compare the Polynoms and print which is larger or if they're equal.
        System.out.println("\nThe derivative of the 2nd polynom is:");
        System.out.println("q' = " + "(" + polynom2 + ")` =\n = " + polynom2.derivate());
        System.out.println();
        int compare = polynom1.compareTo(polynom2);
        switch (compare) {
            case 1:
                System.out.println("Polynom p = (" + polynom1 + ") is larger than Polynom q = (" + polynom2 + ") .");
                break;
            case -1:
                System.out.println("Polynom p = (" + polynom1 + ") is smaller than Polynom q = (" + polynom2 + ") .");
                break;
            case 0:
                System.out.println("Polynom p = (" + polynom1 + ") is equal to Polynom q = (" + polynom2 + ") .");
                break;
        }
        System.out.println("Goodbye!");
    }

    /** Bubble sorts the powers and coefficients arrays according to the powers array in ascending order.
     *
     * @param power The powers array
     * @param coefficients The coefficients array
     */
    public static void bubbleSortByPowerDescending(Integer[] power, Double[] coefficients) {
        for (int i = 0; i < power.length; ++i) {
            for (int j = 0; j < coefficients.length - 1 - i; ++j) {
                if (power[j].compareTo(power[j + 1]) < 0) {
                    int swapInt = power[j];
                    power[j] = power[j + 1];
                    power[j + 1] = swapInt;
                    double swapDouble = coefficients[j];
                    coefficients[j] = coefficients[j + 1];
                    coefficients[j + 1] = swapDouble;
                }
            }
        }
    }

    /** Prints a short welcome message to the program and explains how to input the Polynoms.
     *
     */
    public static void printWelcomeScreen() {
        System.out.println("+---------------------------------------+\n" +
                            "+Welcome to PolyCalc polynom calculator!+\n" +
                            "+---------------------------------------+");
        System.out.println("Please input 2 polynomials, one element per line in the form: coefficient<space>power.\n");
    }

    /** Prints a specific instruction for entering each Polynom and how to mark end of input.
     *
     * @param polynomNumber The Polynom number (out of 2) to print the message for.
     */
    public static void printGetPolynomMessage(int polynomNumber) {
        System.out.println( "Enter polynom number " + polynomNumber + " (Enter any non-zero coefficient " +
                            "and a negative power to mark end of input):");
    }
}

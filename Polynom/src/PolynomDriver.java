import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/** mmn11-2b
 * Driver class for the Polynom program
 * @author Gad Maor
 * @version 1.0
 */
public class PolynomDriver {
    public static void main(String[] args) {
        // ArrayLists for storing the powers and coefficients received from the user
        ArrayList<Integer>  powers = new ArrayList<>();
        ArrayList<Double>  coefficients = new ArrayList<>();
        // create a Scanner to obtain input from the user
        Scanner input = new Scanner(System.in);
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
                Polynom polynom1 = new Polynom(coefficientsArray, powersArray);
                System.out.println(polynom1);
            }
            else {
                Polynom polynom2 = new Polynom(coefficientsArray, powersArray);
                System.out.println(polynom2);
            }
            // Clean powers and coefficients ArrayLists for next Polynom
            powers.clear();
            coefficients.clear();
        }

        /*for (Integer item : powersArray) {
            System.out.printf("%d ", item);
        }
        System.out.println();
        for (Double item : coefficientsArray) {
            System.out.printf("%.2f ", item);
        }*/
    }

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
    public static void printWelcomeScreen() {
        System.out.println("+---------------------------------------+\n" +
                            "+Welcome to PolyCalc polynom calculator!+\n" +
                            "+---------------------------------------+");
        System.out.println("Please input 2 polynomials, one element per line in the form: coefficient<space>power.\n");
    }
    public static void printGetPolynomMessage(int polynomNumber) {
        System.out.println( "Enter polynom number " + polynomNumber + "(Enter any non-zero coefficient " +
                            "and a negative power to mark end of input):");
    }
}

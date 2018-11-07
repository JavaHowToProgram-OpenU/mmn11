/**
 * Represents a single term of a polynom.
 * @author Gad Maor
 * @version 1.0
 */
public class Term {

    /******************************************************
     *                      Fields                        *
     *****************************************************/
    // The coefficient of the term
    private double coefficient;
    // The power of the term
    private int power;

    /******************************************************
     *                      Constructors                  *
     *****************************************************/
    /**
     * A constructor for creating a polynom term out of the given coefficient and power
     *
     * @param coefficient This Term's coefficient
     * @param power       This Term's power
     */
    public Term(double coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String toString() {
        return  ((coefficient == 1) ?  "" : Double.toString(coefficient)) + // Don't write coefficient if it's a 1
                ((power == 0 || coefficient == 0) ? "" : "x") + // If power or coefficient are 0, don't show variable
                ((power <= 1)?  "" : ("^" + power)); // If power is 1 or 0, don't show power
    }
}

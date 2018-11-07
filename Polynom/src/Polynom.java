import java.util.ArrayList;

/** Represents a Polynom using ArrayList of Terms comprised of pairs of coefficient and power.
 *  Contains methods to add, subtract, derivate and compare polynoms.
 * @author Gad Maor
 * @version 1.0
 */
public class Polynom {

    /******************************************************
     *                      Fields                        *
     *****************************************************/
    // An ArrayList whose elements are the Terms of this polynom
    ArrayList<Term> terms;

    /******************************************************
     *                      Constructors                  *
     *****************************************************/
    /**
     * A constructor to instantiate a new Polynom. The constructor receives 2 arrays of
     * coefficients and powers, creates aTerm object from each element pair and adds it
     * to the terms Arraylist.
     *
     * @param coefficients The coefficients array containing this Polynom's coefficients
     * @param powers       The powers array containing this Polynom's powers
     */
    public Polynom(Double[] coefficients, Integer[] powers) {
        // Initialize a new Term ArrayList for terms
        terms = new ArrayList<>();
        for (int i = 0; i < powers.length; ++i) {
            terms.add(new Term(coefficients[i].doubleValue(), powers[i].intValue()));
        }
    }

    /** Returns a string representation of this Polynom.
     * @return - this Polynom in the standard form
     */
    public String toString() {
        String result = "";
        for (int i = 0; i < terms.size(); ++i) {
            // don't add a sign for a negative element or the 1st element
            if (i == 0 || terms.get(i).getCoefficient() < 0) {
                result += terms.get(i);
            }
            else if (i > 0) {
                result += "+" + terms.get(i);
            }
        }
        return result;
    }
}
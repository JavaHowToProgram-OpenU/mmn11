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

    /** A constructor to instantiate a new Polynom using an ArrayList of Terms.
     * @param terms The Terms ArrayList to create the Polynom from
     */
    public Polynom(ArrayList<Term> terms) {
        this.terms = new ArrayList<>(terms.size());
        for (int i = 0; i < terms.size(); ++i) {
            this.terms.add(new Term(terms.get(i)));
        }
    }

    /** A copy constructor to create a new polynom from a given Polynom p.
     *
     * @param p The Polynom to copy
     */
    public Polynom(Polynom p) {
        this.terms = new ArrayList<>(p.getLength());
        for (int i = 0; i < p.getLength(); ++i) {
            this.terms.add(new Term(p.getTerms().get(i)));
        }
    }
    /******************************************************
     *                      Methods                       *
     *****************************************************/

    public ArrayList<Term> getTerms() {
        return terms;
    }

    /** Returns the length of this Polynom(number of terms).
     *
     * @return - The length of this polynom.
     */
    public int getLength() {
        return this.terms.size();
    }
    /** Returns a string representation of this Polynom.
     * @return - this Polynom in the standard form
     */
    public String toString() {
        String result = "";
        // Variable for testing a special case - zero polynom
        boolean zeroFlag = true;
        for (int i = 0; i < terms.size(); ++i) {
            if (terms.get(i).getCoefficient() != 0) {
                zeroFlag = false;
            }
            // Skip over terms with coefficient 0
            else {
                continue;
            }
            // don't add a sign for a negative element or the 1st element
            if (i == 0 || terms.get(i).getCoefficient() < 0) {
                result += terms.get(i);
            }
            else if (i > 0) {
                result += "+" + terms.get(i);
            }
        }
        return (zeroFlag) ? "0" : result;
    }

    /** Returns the sum of this Polynom and the parameter as a new Polynom.
     * The algorithm goes over the 2 Polynom's terms in sequence, using 2 pointers.
     * When it finds similar powers, it adds the coefficients and puts the resulting Term in resultPolynomTerms.
     * Otherwise, it copies the element with the larger power.
     * After it exhausts the shorter Polynom, it simply copies the rest of the terms from the longer Polynom.
     * @param p The polynom to add to this polynom
     * @return - The result of adding the 2 polynoms as a new Polynom.
     */
    public Polynom plus(Polynom p) {
        /* The maximum length of the result Polynom is the sum of elements of the 2 Polynoms - this happens
            if they have no common powers. */
        int maxLength = this.getLength() + p.getLength();
        // Create an ArrayList<Term> object for the result Polynom of size maxLength we just found
        ArrayList<Term> resultPolynomTerms = new ArrayList<>(maxLength);
        int i = 0; // Counter for the result Polynom's terms
        int j = 0; // Counter for this Polynom's terms
        int k = 0; // Counter for the parameter Polynom's terms
        // While we haven't exhausted either the result ArrayList or one of the addends
        while (i < maxLength && j < this.getLength() && k < p.getLength()) {
            // The power of the terms
            int thisPower = this.getTerms().get(j).getPower();
            int pPower = p.getTerms().get(k).getPower();
            // Powers are equal - add the coefficients
            if (thisPower == pPower) {
                // The coefficients to add together
                double thisCoefficient = this.getTerms().get(j).getCoefficient();
                double pCoefficient = p.getTerms().get(k).getCoefficient();
                double resultcoefficient = thisCoefficient + pCoefficient;
                resultPolynomTerms.add(new Term(resultcoefficient, thisPower));
                // Advance all counters to the next term
                ++i;
                ++j;
                ++k;
            }
            // pPower is greater, so add it's element and advance k
            else if (thisPower < pPower) {
                resultPolynomTerms.add(new Term(p.terms.get(k)));
                ++i;
                ++k;
            }
            // thisPower greater, so add it's element and advance j
            else {
                resultPolynomTerms.add(new Term(this.terms.get(j)));
                ++i;
                ++j;
            }
        }
        // We exhausted this polynom, so finish copying the rest of p to the result
        if (j == this.getLength()) {
            while (k < p.getLength()) {
                resultPolynomTerms.add(new Term(p.terms.get(k)));
                ++k;
            }
        }
        // We exhausted the parameter polynom, so finish copying the rest of this polynom to the result
        else if (k == p.getLength()) {
            while (j < this.getLength()) {
                resultPolynomTerms.add(new Term(this.terms.get(j)));
                ++j;
            }
        }
        return new Polynom(resultPolynomTerms);
    }

    /** Returns the sum of this Polynom and the parameter as a new Polynom.
     *  Creates a copy of the give Polynom, multiplies each of it's Terms by (-1)
     *  and uses the plus method to add the result to this Polynom
     *
     * @param p The Polynom to subtract from this Polynom
     * @return The result of subtracting p from this Polynom
     */
    public Polynom minus(Polynom p) {
        Polynom minusP = new Polynom(p);
        for (Term term : minusP.getTerms()) {
            term.setCoefficient(-1 * term.getCoefficient());
        }
        return this.plus(minusP);
    }
    /** Returns the derivative of this Polynom.
     *
     * @return This Polynom's derivative.
     */
    public Polynom derivate() {
        Polynom derivativeP = new Polynom(this);
        for (Term term : derivativeP.getTerms()) {
            double newCoefficient = term.getPower() * term.getCoefficient();
            int newPower = term.getPower() - 1;
            term.setCoefficient(newCoefficient);
            term.setPower(newPower);
        }
        return derivativeP;
    }
}
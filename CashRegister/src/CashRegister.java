/** mmn11-1a
 * @author Gad Maor
 * @version 1.0
 * Represents a cash register in a department store. Collects customer's account details, calculates total purchase sum,
 * receives payment and returns change to the customer and calculates total purchase sum for all buyers.
 */
public class CashRegister {

    /******************************************************
     *                      Fields                        *
     *****************************************************/
    private static double totalSum; // total amount of money in the CashRegister
    private double currentSum;      // total purchase sum for current customer

    /******************************************************
     *                      Constructors                  *
     *****************************************************/
    // An empty constructor - empty CashRegister
    public CashRegister() {

    }
    // A constructor for a CashRegister containing an initial amount of money
    public CashRegister(double initialSum) {
        CashRegister.totalSum = initialSum;
    }

    /******************************************************
     *                      Methods                       *
     *****************************************************/

    /** Getter method for totalSum field
     *
     * @return - The total sum of money in this CashRegister
     */
    public static double getTotalSum() {
        return totalSum;
    }

    /** Setter method for totalSum field
     *
     * @param totalSum set the amount of money in this CashRegister
     */
    public static void setTotalSum(double totalSum) {
        CashRegister.totalSum = totalSum;
    }

    /** Getter method for currentSum field
     *
     * @return - The sum for the current customer's account
     */
    public double getCurrentSum() {
        return currentSum;
    }

    /** Setter method for currentSum field
     *
     * @param currentSum The sum to set for the current customer's account
     */
    public void setCurrentSum(double currentSum) {
        this.currentSum = currentSum;
    }
}


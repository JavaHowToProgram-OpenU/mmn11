/** mmn11-1a
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

    // Getter method for totalSum field
    public static double getTotalSum() {
        return totalSum;
    }
    // Setter method for totalSum field
    public static void setTotalSum(double totalSum) {
        CashRegister.totalSum = totalSum;
    }
    // Getter method for currenSum field
    public double getCurrentSum() {
        return currentSum;
    }
    // Setter method for currenSum field
    public void setCurrentSum(double currentSum) {
        this.currentSum = currentSum;
    }
}


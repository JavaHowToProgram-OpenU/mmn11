import java.util.ArrayList;

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
    // Total amount of money in the CashRegister
    private static double totalSum;
    // Total sum of purchase for current customer
    private double currentSum;

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
    public double getTotalSum() {
        return CashRegister.totalSum;
    }

    /** Set the totalSum of money in the CashRegister
     *
     * @param sum sum to set as the total amount of money in this CashRegister
     */
    public void setTotalSum(double sum) {
        CashRegister.totalSum = sum;
    }

    /** Getter method for currentSum field
     *
     * @return - The sum for the current customer's account
     */
    public double getCurrentSum() {
        return currentSum;
    }

    /** Calculates total purchase sum for current customer
     *
     * @param record The ShoppingRecord record from which to add the record totalPrice
     */
    public void calcCurrentSum(ShoppingRecord record) {
            this.currentSum += record.getTotalPrice();
    }
    /** Adds an item to the currect customer's shoppingList.
     * Creates a new ShoppingRecord object with the given parameters and adds it to the shoppingList.
     *
     * @param item The item to add to this shoppingList
     * @param amount The amount of item to add to this shoppingList
     */
    public void addItem(Item item, int amount, ArrayList<ShoppingRecord> shoppingList) {
        ShoppingRecord record = new ShoppingRecord(item, amount);
        shoppingList.add(record);
        calcCurrentSum(record);

    }
    /** Returns the current customer's shoppingList
     *
     * @return - This customer's shoppingList
     */
    public String getShoppingList(ArrayList<ShoppingRecord> shoppingList) {
        String result = "Shopping List details:\n\n" +
        String.format("%-15s%10s%15s%n", "Item", "Amount", "Total Price") +
        "----------------------------------------\n";
        for (ShoppingRecord record : shoppingList)
            result += record;
        result += "\n" + "Total shopping cart price: " + getCurrentSum() + "$\n";
        return result;
    }
    public double getPayment(double payment, ArrayList<ShoppingRecord> shoppingList){
        double change;
        // Customer doesn't have enough money - give him back his money and send him on his way
        if (payment < getCurrentSum()) {
            System.out.println("Insufficient funds. Come back when you have some more money.");
            return payment;
        }
        else {
            // No money in CashRegister, or not enough for change
            if (getTotalSum() < payment - getCurrentSum()) {
                System.out.println("Not enough change in CashRegister. Please use exact change!");
                return payment;
            }
            // Calculate change
            change = payment - getCurrentSum();
            // Update CashRegister's totalSum
            setTotalSum(getTotalSum() + payment - change);
        }
        // Reset shoopingList for next customer
        shoppingList.clear();
        return change;
    }
}
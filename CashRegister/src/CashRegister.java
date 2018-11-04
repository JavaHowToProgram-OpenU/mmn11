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
    // total amount of money in the CashRegister
    private static double totalSum;
    //
    private double currentSum;
    // ArrayList representing the current customer's shopping list(account).
    private ArrayList<ShoppingRecord> shoppingList = new ArrayList<>();

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

    /** Calculates total purchase sum for current customer
     *
     * @param currentSum The sum to set for the current customer's account
     */
    public void setCurrentSum(double sum) {
        this.currentSum += sum;
    }
    /** Adds an item to the currect customer's shoppingList.
     * Creates a new ShoppingRecord object with the given parameters and adds it to the shoppingList.
     *
     * @param item The item to add to this shoppingList
     * @param amount The amount of item to add to this shoppingList
     */
    public void addItem(Item item, int amount) {
        ShoppingRecord record = new ShoppingRecord(item, amount);
        shoppingList.add(record);
        currentSum += record.getTotalPrice();

    }
    /** Returns the current customer's shoppingList
     *
     * @return - This customer's shoppingList
     */
    public String getShoppingList() {
        String result = "Shopping List details:\n\n" +
        String.format("%-15s%10s%15s%n", "Item", "Amount", "Total Price") +
        "----------------------------------------\n";
        for (ShoppingRecord item : shoppingList)
            result += item;
        return result;
    }
    public double getPayment(double payment){
        double change;
        // Customer doesn't have enough money - give him back his money and send him on his way
        if (payment < currentSum) {
            System.out.println("Insufficient funds. Come back when you have some more money.");
            return payment;
        }
        else {
            // No money in CashRegister, or not enough for change
            if (getTotalSum() < payment - currentSum) {
                System.out.println("Not enough change in CashRegister. Please use exact change!");
                return payment;
            }
            // Calculate change
            change = payment - currentSum;
            // Update CashRegister's totalSum
            setTotalSum(getTotalSum() + payment - change);
        }
        // Print shoppingList for customer
        System.out.println(getShoppingList());
        // Reset shoopingList for next customer
        shoppingList.clear();
        return change;
    }
}
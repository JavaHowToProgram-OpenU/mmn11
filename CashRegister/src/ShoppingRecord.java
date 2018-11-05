/**
 * Represents a single line in the shopping account of a customer
 *
 * @author Gad Maor
 * @version 1.0
 */
public class ShoppingRecord {

    /******************************************************
     *                      Fields                        *
     *****************************************************/
    // The Item of this ShoppingRecord
    private Item item;
    // Amount of Item in this ShoppingRecord
    private int amount;
    // Total price of ShoppingRecord - depends on at least one Item created
    private double totalPrice;

    /******************************************************
     *                      Constructors                  *
     *****************************************************/
    /** Instantiate ShoppingRecord with given Item, amount amd calculate totalPrice of ShoppingRecord
     *
     * @param item The Item of this ShoppingRecord
     * @param amount The amount of this ShoppingRecord's Item
     */
    public ShoppingRecord(Item item, int amount) {
        this.item = item;
        this.amount = amount;
        this.totalPrice = item.getPrice() * amount;
    }

    /******************************************************
     *                      Methods                       *
     *****************************************************/

    /**
     * Getter method for item field
     *
     * @return - the Item belonging to this ShoppingRecord
     */
    public Item getItem() {
        return item;
    }

    /**
     * Getter method for amount field
     *
     * @return - The amount of Item in this ShoppingRecord
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Getter method for totalPrice field
     *
     * @return - The total sum of this ShoppingRecord. Calculated as amount of Item times price of Item
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Returns this ShoppingRecord's details
     *
     * @return - This ShoppingRecord
     */
    public String toString() {
        return String.format("%-15s%8d%15.2f$%n", getItem().getName(), getAmount(), getTotalPrice());
    }
}

/** Represents a single line in the shopping account of a customer
 *
 */
public class ShoppingRecord {

    /******************************************************
     *                      Fields                        *
     *****************************************************/
    // A single Item
    private Item item;
    // Amount of Item
    private int amount;
    // Total price of ShoppingRecord - depends on at least one Item created
    private double totalPrice;

    /******************************************************
     *                      Constructors                  *
     *****************************************************/
    // instantiate ShoppingRecord with given Item, amount amd calculate totalPrice of ShoppingRecord
    public ShoppingRecord(Item item, int amount) {
        this.item = item;
        this.amount = amount;
        this.totalPrice = item.getPrice() * amount;
    }

    /******************************************************
     *                      Methods                       *
     *****************************************************/

    /** Getter method for item field
     *
     * @return - the Item belonging to this ShoppingRecord
     */
    public Item getItem() {
        return item;
    }

    /** Setter method for item field
     *
     * @param item the Item to set for this ShoppingRecord
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /** Getter method for amount field
     *
     * @return - The amount of Item in this ShoppingRecord
     */
    public int getAmount() {
        return amount;
    }

    /** Setter method for amount field
     *
     * @param amount The amount of Item to set for this ShoppingRecord
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /** Getter method for totalPrice field
     *
     * @return - The total sum of this ShoppingRecord. Calculated as amount of Item times price of Item
     */
    public double getTotalPrice() {
        return totalPrice;
    }

}

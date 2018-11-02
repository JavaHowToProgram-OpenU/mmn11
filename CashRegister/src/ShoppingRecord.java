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

    // Getter method for item field
    public Item getItem() {
        return item;
    }
    // Setter method for item field
    public void setItem(Item item) {
        this.item = item;
    }
    // Getter method for amount field
    public int getAmount() {
        return amount;
    }
    // Setter method for amount field
    public void setAmount(int amount) {
        this.amount = amount;
    }
    // Getter method for totalPrice field
    public double getTotalPrice() {
        return totalPrice;
    }

}

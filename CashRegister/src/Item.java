/** Represents an item in the department store
 * @author Gad Maor
 * @version 1.0
 */

public class Item {

    /******************************************************
     *                      Fields                        *
     *****************************************************/
    // Name of an Item
    private String name;
    // Price of an Item
    private double price;

    /******************************************************
     *                      Constructors                  *
     *****************************************************/
    /** Instantiate Item with name and price
     *
     * @param name The name of this Item
     * @param price The price for this Item
     */
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /******************************************************
     *                      Methods                       *
     *****************************************************/

    /** Getter method for name field
     *
     * @return name - The name of this Item
     */
    public String getName() {
        return name;
    }

    /** Setter method for name field
     *
     * @param name The name to set for this Item
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Getter method for price field
     *
     * @return price - The price of this Item
     */
    public double getPrice() {
        return price;
    }

    /** Setter method for price field
     *
     * @param price The price to set for this Item
     */
    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return String.format("%-15s%10.2f$", this.getName(), this.getPrice());
    }
}

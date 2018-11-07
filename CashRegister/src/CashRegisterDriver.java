import java.util.ArrayList;
import java.util.Scanner;

/** mmn11-1b
 * Driver class for the CashRegister program
 * @author Gad Maor
 * @version 1.0
 */
public class CashRegisterDriver {
    public static void main(String[] args) {
        // ArrayList representing the current customer's shopping list(account).
        ArrayList<ShoppingRecord> shoppingList = new ArrayList<>();
        // Initialize store inventory items and prices
        final Item[] inventory= {
                new Item("Pen", 2.5), new Item("Notebook", 5),
                new Item("T-Shirt", 20), new Item("Screwdriver", 15.75),
                new Item("Paint Bucket", 30), new Item("Screws", 6),
                new Item("Perfume", 80), new Item("Jeans", 75),
                new Item("Sport shoes", 150), new Item("Kitchen table", 250)
        };
        // create a Scanner to obtain input from the command window
        Scanner input = new Scanner(System.in);
        // Declare a new CashRegister pointer
        CashRegister cr;
        printWelcomeScreen();
        printCashRegisterInitializationMessage();
        int selection = input.nextInt();
        switch (selection) {
            case 1: // Customer chose to initialize an empty CashRegister
                cr = new CashRegister();
                break;
            case 2: // Customer chose to initialize CashRegister with initial sum
                System.out.print("Please enter initial amount of money to put into the Cash Register: ");
                cr = new CashRegister(input.nextDouble());
                break;
            default: // Interpret any other input as an empty CashRegister
                cr = new CashRegister();
                break;
        }
        System.out.printf("Cash register initialized with %.2f$.%n%n", cr.getTotalSum());
        /*  Main Cash Register function - get shoppingList, payment and continue with next customer
            Ends when customer selects option no. 4.
         */
        while (selection != 4) {
            printStoreMenu();
            selection = input.nextInt();
            switch (selection) {
                case 1:
                    int itemSelection = getItemSelection(inventory, input);
                    int amount = getAmount(inventory[itemSelection - 1].getName(), input);
                    cr.addItem(inventory[itemSelection - 1], amount, shoppingList);
                    System.out.println(amount + " " + inventory[itemSelection - 1].getName() +
                                        "s were successfully added to shopping list.\n");
                    System.out.println(cr.getShoppingList(shoppingList));
                    break;
                case 2:
                    System.out.println("Here's your shopping list:");
                    System.out.println(cr.getShoppingList(shoppingList));
                    System.out.print("Please input payment in dollars: ");
                    double payment = input.nextDouble();
                    System.out.println("You input " + payment + "$.\n");
                    double change = cr.getPayment(payment, shoppingList);
                    System.out.println("Thank you. Your change is: " + change + "$.\n");
                    System.out.println("Cash register current balance is: " + cr.getTotalSum() + "$.\n");
                    System.out.println( "Thank you for shopping OpenU-Mart.\n" +
                                        "Come back again!.\n" +
                                        "Next customer, please!\n");
                    break;
                case 3:
                    System.out.println( "Cancelling purchase.\n" +
                                         "Next customer, please!\n");
                    shoppingList.clear();
                    continue;
                case 4:
                    System.out.println("Goodbye!\n");
                    break;
            }
        }
    }

    /** Prints a welcome message for the store
     *
     */
    public static void printWelcomeScreen() {
        System.out.println("+--------------------------------+\n" +
                            "+Hello and welcome to OpenU-Mart!+\n" +
                            "+--------------------------------+");
    }

    /** Prints the CashRegister initialization request
     *
     */
    public static void printCashRegisterInitializationMessage() {
        System.out.println("You must first initialize the Cash Register service.\n" +
                           "Please choose one of the following options:\n" +
                           "1) Initialize an empty Cash Register.\n" +
                           "2) Initialize the Cash Register with initial amount of money.\n");
        System.out.print("Enter selection: ");

        //System.out.println("Please select the requested operation from the following menu(type numeric selection): \n");

    }

    /** Prints the store's main menu
     */
    public static void printStoreMenu() {
        System.out.println( "Please choose an action from the following menu:\n\n" +
                            "1) Add products to shopping list.\n" +
                            "2) Finish adding products to shopping list and go to payment.\n" +
                            "3) Cancel purchase.\n" +
                            "4) End OpenU-Mart store program.\n");
        System.out.print("Enter selection: ");
    }

    /**
     * @param inventory The inventory array from which to display the items
     * @param input The Scanner input object to get input from the user
     * @return - The item number selected by the user(shifted +1 from the array's indices)
     */
    public static int getItemSelection(Item[] inventory, Scanner input) {
        System.out.println("Please select which item you'd like to purchase from the following list:\n");
        for (int counter = 1; counter < inventory.length + 1; ++counter) {
            System.out.printf("%2d)%s%n", counter, inventory[counter - 1]);
        }
        System.out.print("Enter selection: ");
        return input.nextInt();
    }

    /**
     * @param itemName The name of the selected item to get amount for
     * @param input The Scanner input object to get input from the user
     * @return - The amount of item input by the user
     */
    public static int getAmount(String itemName, Scanner input) {
        System.out.printf("Please enter the amount of %ss you'd like to purchase: ", itemName);
        return input.nextInt();
    }
}
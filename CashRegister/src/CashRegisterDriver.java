import java.util.ArrayList;
import java.util.Scanner;

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
        // getShoppingList(shoppingList);
        /*Item pen = new Item("Pen", 2.5);
        Item notebook = new Item("Notebook", 5);
        Item tShirt = new Item("T-Shirt", 20);
        Item screwdriver = new Item("Screwdriver", 15.75);
        cr.addItem(pen, 10,shoppingList);
        cr.addItem(notebook, 5,shoppingList);
        cr.addItem(tShirt, 5,shoppingList);
        cr.addItem(screwdriver, 3,shoppingList);
        double payment = 200;
        // Print shoppingList for customer
        System.out.println(cr.getShoppingList(shoppingList));
        //System.out.println("Total: $" + cr.getCurrentSum());
        System.out.println("You paid: " + payment + "$\n" + "Your change is: " + cr.getPayment(payment,shoppingList) + "$");
        System.out.printf("Cash Register now has %.2f$ left.", cr.getTotalSum());*/
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
        System.out.println( "Please choose an action form the following menu:\n\n" +
                            "1) Add products to shopping list.\n" +
                            "2) Finish adding products to shopping list and go to payment.\n" +
                            "3) Cancel purchase.\n" +
                            "4) End OpenU-Mart store program.\n");
        System.out.print("Enter selection: ");
    }
    public static int getItemSelection(Item[] inventory, Scanner input) {
        System.out.println("Please select which item you'd like to purchase from the following list.\n");
        for (int counter = 1; counter < inventory.length + 1; ++counter) {
            System.out.printf("%2d)%s%n", counter, inventory[counter - 1]);
        }
        System.out.print("Enter selection: ");
        return input.nextInt();
    }
    public static int getAmount(String itemName, Scanner input) {
        System.out.printf("Please enter the amount of %ss you'd like to purchase: ", itemName);
        return input.nextInt();
    }
}
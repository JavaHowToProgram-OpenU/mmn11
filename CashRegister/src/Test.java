public class Test {
    public static void main(String[] args) {
        CashRegister cr = new CashRegister(0);
        //System.out.println("Amount in CashRegister is: " + cr.getTotalSum());
        Item pen = new Item("Pen", 2.5);
        Item notebook = new Item("Notebook", 5);
        Item tShirt = new Item("T-Shirt", 20);
        Item screwdriver = new Item("Screwdriver", 15.75);
        //System.out.println(pen);
        //ShoppingRecord sr= new ShoppingRecord(pen, 10);
        cr.addItem(pen, 10);
        cr.addItem(notebook, 5);
        cr.addItem(tShirt, 5);
        cr.addItem(screwdriver, 3);
        //System.out.println(cr.getShoppingList());
        //System.out.println(cr.getCurrentSum());
        double payment = 197.25;
        System.out.println("You paid: " + payment + "$\n" + "Your change is: $" + cr.getPayment(payment) + "$");
    }
}
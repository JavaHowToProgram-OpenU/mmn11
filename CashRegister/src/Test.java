public class Test {
    public static void main(String[] args) {
        CashRegister cr = new CashRegister(50);
        System.out.println("Amount in CashRegister is: " + cr.getTotalSum());
        Item pen = new Item("Pen", 2.5);
        Item notebook = new Item("Notebook", 5);
        Item tShirt = new Item("T-Shirt", 20);
        //System.out.println(pen);
        //ShoppingRecord sr= new ShoppingRecord(pen, 10);
        cr.addItem(pen, 10);
        cr.addItem(notebook, 5);
        cr.addItem(tShirt, 5);
        cr.getShoppingList();
        System.out.println(cr.getCurrentSum());
        //System.out.println(sr);
        //System.out.printf("We now have a record for %d pens which cost %.2f$", sr.getAmount(), sr.getTotalPrice());
    }
}
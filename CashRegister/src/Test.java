public class Test {
    public static void main(String[] args) {
        CashRegister cr = new CashRegister(50);
        System.out.println("Amount in CashRegister is: " + cr.getTotalSum());
        Item pen = new Item("Pen", 2.5);
        ShoppingRecord sr= new ShoppingRecord(pen, 10);
        System.out.printf("We now have a record for %d pens which cost %.2f$", sr.getAmount(), sr.getTotalPrice());
    }
}
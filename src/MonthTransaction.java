public class MonthTransaction {
    String name;
    boolean isExpense;
    int quantity;
    int unitPrice;

    public MonthTransaction(String name, boolean isExpense, int quantity, int unitPrice) {
        this.name = name;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
}

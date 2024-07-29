public class YearTransaction {
    Byte month;
    Integer amount;
    Boolean isExpense;

    public YearTransaction(Byte month, Integer amount, Boolean isExpense) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
    }
}

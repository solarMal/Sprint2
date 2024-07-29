import java.util.ArrayList;

public class MonthlyReport {
    String itemName;
    Boolean isExpense;
    Integer quantity;
    Integer unitPrice;
    ArrayList<String> lines;
    FileReader fileReader = new FileReader();
    ArrayList<MonthTransaction> monthTransactions = new ArrayList<>();
    ArrayList<Integer> incomePerMonths = new ArrayList<>();
    ArrayList<Integer> expensePerMonths = new ArrayList<>();
    ArrayList<MonthTransaction> firstMonth = new ArrayList<>();
    ArrayList<MonthTransaction> secondMonth = new ArrayList<>();
    ArrayList<MonthTransaction> thirdMonth = new ArrayList<>();

    void readFile(String fileName) {
        lines = fileReader.readFileContents(fileName);
    }

    void splitFile(String fileName) {
        readFile(fileName);

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);

            String[] lineContents = line.split(",");
            itemName = lineContents[0];
            isExpense = Boolean.parseBoolean(lineContents[1]);
            quantity = Integer.parseInt(lineContents[2]);
            unitPrice = Integer.parseInt(lineContents[3]);

            MonthTransaction monthTransaction = new MonthTransaction(itemName, isExpense, quantity, unitPrice);
            monthTransactions.add(monthTransaction);
        }
    }

    void mostPopularProduct(ArrayList<MonthTransaction> transactions) {
        int sum = 0;
        String productName = "";

        for (int i = 0; i < transactions.size(); i++) {
            if (!transactions.get(i).isExpense) {
                int current = 0;
                current = transactions.get(i).quantity * transactions.get(i).unitPrice;
                if (current > sum) {
                    sum = current;
                    productName = transactions.get(i).name;
                }
            }
        }

        System.out.println("Самый прибыльный товар " + productName + " " + sum);
    }

    void mostBigExpense(ArrayList<MonthTransaction> transactions) {
        int sum = 0;
        String productName = "";

        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).isExpense) {
                int current = 0;
                current = transactions.get(i).quantity * transactions.get(i).unitPrice;
                if (current > sum) {
                    sum = current;
                    productName = transactions.get(i).name;
                }
            }
        }

        System.out.println("Самая большая трата " + productName + " " + sum);
    }

    void getSumIncomePerMonth(ArrayList<MonthTransaction> transactions) {
        int sum = 0;
        for (int i = 0; i < transactions.size(); i++) {
            if (!transactions.get(i).isExpense) {
                MonthTransaction monthTransaction = transactions.get(i);
                int current = 0;
                current = monthTransaction.quantity * monthTransaction.unitPrice;
                sum += current;
            }
        }
        incomePerMonths.add(sum);
    }

    void getSumExpensesPerMonth(ArrayList<MonthTransaction> transactions) {
        int sum = 0;
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).isExpense) {
                MonthTransaction monthTransaction = transactions.get(i);
                int current = 0;
                current = monthTransaction.quantity * monthTransaction.unitPrice;
                sum += current;
            }
        }
        expensePerMonths.add(sum);
    }

    void incomePerMonths() {
        getSumIncomePerMonth(firstMonth);
        getSumIncomePerMonth(secondMonth);
        getSumIncomePerMonth(thirdMonth);
    }

    void expensesPerMonths() {
        getSumExpensesPerMonth(firstMonth);
        getSumExpensesPerMonth(secondMonth);
        getSumExpensesPerMonth(thirdMonth);
    }

    void firstMonth() {
        for (int i = 0; i <= 2; i++) {
            firstMonth.add(monthTransactions.get(i));
        }
    }

    void secondMonth() {
        for (int i = 3; i <= 5; i++) {
            secondMonth.add(monthTransactions.get(i));
        }
    }

    void thirdMonth() {
        for (int i = 6; i <= 8; i++) {
            thirdMonth.add(monthTransactions.get(i));
        }
    }

    void mostPopularProductByFirstMonth(ArrayList<MonthTransaction> transactions) {
        mostPopularProduct(transactions);
    }

    void mostPopularProductBySecondMonth(ArrayList<MonthTransaction> transactions) {
        mostPopularProduct(transactions);
    }

    void mostPopularProductByThirdMonth(ArrayList<MonthTransaction> transactions) {
        mostPopularProduct(transactions);
    }

    void mostBigExpenseByFirstMonth(ArrayList<MonthTransaction> transactions) {
        mostBigExpense(transactions);
    }

    void mostBigExpenseBySecondMonth(ArrayList<MonthTransaction> transactions) {
        mostBigExpense(transactions);
    }

    void mostBigExpenseByThirdMonth(ArrayList<MonthTransaction> transactions) {
        mostBigExpense(transactions);
    }
}

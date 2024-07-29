import java.util.ArrayList;

public class YearlyReport {
    Byte month;
    Integer amount;
    Boolean isExpense;
    FileReader fileReader = new FileReader();
    ArrayList<String> lines = new ArrayList<>();
    ArrayList<YearTransaction> yearTransactions = new ArrayList<>();
    ArrayList<Integer> incomePerYear = new ArrayList<>();
    ArrayList<Integer> expensePerYear = new ArrayList<>();

    void readFile() {
        String fileName = "y.2021.csv";
        lines = fileReader.readFileContents(fileName);
    }

    void splitFile() {
        readFile();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] lineContents = line.split(",");

            month = Byte.parseByte(lineContents[0]);
            amount = Integer.parseInt(lineContents[1]);
            isExpense = Boolean.parseBoolean(lineContents[2]);

            YearTransaction yearTransaction = new YearTransaction(month, amount, isExpense);
            yearTransactions.add(yearTransaction);
        }
    }

    void sumPerYear() {
        for (int i = 0; i < yearTransactions.size(); i++) {
            if (!yearTransactions.get(i).isExpense) {
                incomePerYear.add(yearTransactions.get(i).amount);
            } else {
                expensePerYear.add(yearTransactions.get(i).amount);
            }
        }
    }

    void showIncomePerYear() {
        for (int i = 0; i < incomePerYear.size(); i++) {
            System.out.println("доход за " + (i + 1) + " месяц - " + incomePerYear.get(i));
        }
    }

    void avgIncomePerYear() {
        int sum = 0;

        for (int i = 0; i < incomePerYear.size(); i++) {
            sum += incomePerYear.get(i);
        }

        System.out.println("средний доход за год " + sum / incomePerYear.size());
    }

    void avgExpensePerYear() {
        int sum = 0;

        for (int i = 0; i < expensePerYear.size(); i++) {
            sum += expensePerYear.get(i);
        }
        System.out.println("средний расход за год " + sum / expensePerYear.size());
    }
}

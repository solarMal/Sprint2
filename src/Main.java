import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();

        while (true) {
            showMenu();
            System.out.println("Выберите действие");
            int command = scanner.nextInt();
            if (command == 1) {
                for (int i = 1; i < 4; i++) {
                    String fileName = "m.20210" + i + ".csv";
                    monthlyReport.splitFile(fileName);
                }
                monthlyReport.firstMonth();
                monthlyReport.secondMonth();
                monthlyReport.thirdMonth();
            } else if (command == 2) {
                yearlyReport.splitFile();
                yearlyReport.sumPerYear();
            } else if (command == 3) {
                if (monthlyReport.monthTransactions.isEmpty() && yearlyReport.yearTransactions.isEmpty()) {
                    System.out.println("Месячный и годовой отчёты не считаны");
                }
                monthlyReport.incomePerMonths();
                monthlyReport.expensesPerMonths();

                for (int i = 0; i < monthlyReport.incomePerMonths.size(); i++) {
                    if (!monthlyReport.incomePerMonths.get(i).equals(yearlyReport.incomePerYear.get(i))) {
                        System.out.println("В месяце " + (i + 1) + " ошибка в подсчёте дохода");
                    }
                }

                for (int i = 0; i < monthlyReport.expensePerMonths.size(); i++) {
                    if (!monthlyReport.expensePerMonths.get(i).equals(yearlyReport.expensePerYear.get(i))) {
                        System.out.println("В месяце " + (i + 1) + " ошибка в подсчёте расхода");
                    }
                }
                System.out.println("расходы и доходы успешно подсчитаны");

            } else if (command == 4) {
                if (monthlyReport.monthTransactions.isEmpty() && yearlyReport.yearTransactions.isEmpty()) {
                    System.out.println("Месячный и годовой отчёты не считаны");
                    return;
                }
                System.out.println("Месяц 01 ");
                monthlyReport.mostPopularProductByFirstMonth(monthlyReport.firstMonth);
                monthlyReport.mostBigExpenseByFirstMonth(monthlyReport.firstMonth);
                System.out.println("Месяц 02 ");
                monthlyReport.mostPopularProductBySecondMonth(monthlyReport.secondMonth);
                monthlyReport.mostBigExpenseBySecondMonth(monthlyReport.secondMonth);
                System.out.println("Месяц 03 ");
                monthlyReport.mostPopularProductByThirdMonth(monthlyReport.thirdMonth);
                monthlyReport.mostBigExpenseByThirdMonth(monthlyReport.thirdMonth);

            } else if (command == 5) {
                if (monthlyReport.monthTransactions.isEmpty() && yearlyReport.yearTransactions.isEmpty()) {
                    System.out.println("Месячный и годовой отчёты не считаны");
                }
                System.out.println("Год 2021 ");
                yearlyReport.showIncomePerYear();
                yearlyReport.avgExpensePerYear();
                yearlyReport.avgIncomePerYear();

            } else if (command == 0) {
                return;
            } else {
                System.out.println("Такого действия нет");
            }
        }
    }

    static void showMenu() {
        System.out.println("1. Считать все месячные отчёты");
        System.out.println("2. Считать годовой отчёт");
        System.out.println("3. Сверить отчёты");
        System.out.println("4. Вывести информацию обо всех месячных отчётах");
        System.out.println("5. Вывести информацию о годовом отчёте");
        System.out.println("0. Выход из приложения");
    }
}
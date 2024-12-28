package IncomeTrakingProject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reports implements Serializable {
    ArrayList<Transaction> transactionsList = new ArrayList<>();

    public void saveToFile() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Transactions.txt"))) {
            oos.writeObject(this.transactionsList);
        }
    }

    // Load the employee list from a file
    @SuppressWarnings("unchecked")
    public void loadFromFile() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Transactions.txt"))) {
            this.transactionsList = (ArrayList<Transaction>) ois.readObject();
        }
    }

    public void addTrans(Transaction trans) {
        transactionsList.add(trans);
    }

    public void displly() {
        for (Transaction trans : transactionsList) {
            if (trans instanceof Income)
                ((Income) trans).getdetails();
            if (trans instanceof Expense) {
                ((Expense) trans).getExpenseDetails();
            }
        }
    }

    public void Enter_basic_details(Scanner inp, int choice) {
        System.out.println("Enter amount: ");
        double amount = inp.nextDouble();
        inp.nextLine();
        System.out.println("Enter description: ");
        String desc = inp.nextLine();
        if (choice == 1) {
            System.out.println("Enter income Category \nsalary\nfreelanceWork\nwife_Salary");
        } else if (choice == 2) {
            System.out.println("Enter expense Category \nrent\ngroceries\nutilities\nentertainment;");
        }
        String cat = inp.nextLine();
        System.out.println();

        LocalDate date = enter_date(inp);

        if (choice == 1) {
            Category f = CategoryUtil.getIncomeCategory(cat);
            addTrans(new Income(amount, desc, f, date));
        } else if (choice == 2) {
            expenseCategory x = CategoryUtil.getExpenseCategory(cat);
            addTrans(new Expense(amount, desc, x, date));
        }
    }

    public void ViewTransaction(Scanner inp) {
        if (transactionsList.isEmpty()) {
            System.out.println("There are no transactions to view. Add a transaction and try again.");
        } else {
            System.out.println("1. All\n2. By Category");
            int choice = inp.nextInt();

            if (choice == 1) {
                displly();
            } else if (choice == 2) {
                System.out.println("1. View Income\n2. View Expense");
                int operate = inp.nextInt();
                if (operate == 1) {
                    for (Transaction tran : transactionsList) {
                        if (tran instanceof Income)
                            ((Income) tran).getdetails();
                    }
                } else if (operate == 2) {
                    for (Transaction tran : transactionsList) {
                        if (tran instanceof Expense)
                            ((Expense) tran).getExpenseDetails();
                    }
                }
            }
        }
    }

    public LocalDate enter_date(Scanner inp) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = null;
        boolean validDate = false;
        while (!validDate) {
            try {
                System.out.print("Enter a date (YYYY-MM-DD): ");
                String dateString = inp.nextLine();
                date = LocalDate.parse(dateString, formatter);
                validDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }
        return date;
    }

    public void generate_reports(Scanner inpp) {
        System.out.println("Choose the type of report you want to generate:");
        System.out.println("1. Overall Savings Report");
        System.out.println("2. Detailed Income Report");
        System.out.println("3. Detailed Expense Report");
        int ReportChoice = inpp.nextInt();

        switch (ReportChoice) {
            case 1:
                generateOverallSavingsReport();
                break;
            case 2:
                generateDetailedIncomeReport();
                break;
            case 3:
                generateDetailedExpenseReport();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void generateOverallSavingsReport() {
        double totalIncome = 0;
        double totalExpense = 0;

        for (Transaction tran : transactionsList) {
            if (tran instanceof Income) {
                totalIncome += tran.getAmount();
            } else if (tran instanceof Expense) {
                totalExpense += tran.getAmount();
            }
        }

        System.out.println("The total income is: " + totalIncome);
        System.out.println("The total expense is: " + totalExpense);
        System.out.println("Savings = " + (totalIncome - totalExpense));
    }

    private void generateDetailedIncomeReport() {
        double salaryTotal = 0;
        double freelanceWorkTotal = 0;
        double wifeSalaryTotal = 0;

        for (Transaction tran : transactionsList) {
            if (tran instanceof Income) {
                Income income = (Income) tran;
                switch (income.s) {
                    case salary:
                        salaryTotal += income.getAmount();
                        break;
                    case freelanceWork:
                        freelanceWorkTotal += income.getAmount();
                        break;
                    case wife_Salary:
                        wifeSalaryTotal += income.getAmount();
                        break;
                    default:
                        break;
                }
            }
        }

        System.out.println("Detailed Income Report:");
        System.out.println("Salary Income: " + salaryTotal);
        System.out.println("Freelance Work Income: " + freelanceWorkTotal);
        System.out.println("Wife's Salary Income: " + wifeSalaryTotal);
        System.out.println("Total Income: " + (salaryTotal + freelanceWorkTotal + wifeSalaryTotal));
    }

    private void generateDetailedExpenseReport() {
        double rentTotal = 0;
        double groceriesTotal = 0;
        double utilitiesTotal = 0;
        double entertainmentTotal = 0;

        for (Transaction tran : transactionsList) {
            if (tran instanceof Expense) {
                Expense expense = (Expense) tran;
                switch (expense.x) {
                    case rent:
                        rentTotal += expense.getAmount();
                        break;
                    case groceries:
                        groceriesTotal += expense.getAmount();
                        break;
                    case utilties:
                        utilitiesTotal += expense.getAmount();
                        break;
                    case entertainment:
                        entertainmentTotal += expense.getAmount();
                        break;
                    default:
                        break;
                }
            }
        }

        System.out.println("Detailed Expense Report:");
        System.out.println("Rent Expenses: " + rentTotal);
        System.out.println("Groceries Expenses: " + groceriesTotal);
        System.out.println("Utilities Expenses: " + utilitiesTotal);
        System.out.println("Entertainment Expenses: " + entertainmentTotal);
        System.out.println("Total Expenses: " + (rentTotal + groceriesTotal + utilitiesTotal + entertainmentTotal));
    }

}

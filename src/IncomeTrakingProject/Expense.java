package IncomeTrakingProject;

import java.time.LocalDate;

public class Expense extends Transaction {

    public Expense() {
    }

    public Expense(double amount, String description, expenseCategory category, LocalDate date) {
        super(amount, description, category, date);

    }

    public void getExpenseDetails() {
        System.out.println(super.ExpensetoString() + " Date:" + date);
    }
}

enum expenseCategory {
    rent, groceries, utilties, entertainment, UNKNOWN;
}
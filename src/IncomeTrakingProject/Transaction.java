package IncomeTrakingProject;

import java.io.Serializable;
import java.time.LocalDate;

public class Transaction implements Serializable {
    private double amount;
    private String description;
    Category s;
    expenseCategory x;
    LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Transaction() {
    }

    public Transaction(double amount, String description, Category s, LocalDate date) {
        this.amount = amount;
        this.description = description;
        this.s = s;
        this.date = date;
    }

    public Transaction(double amount, String description, expenseCategory x, LocalDate date) {
        this.amount = amount;
        this.description = description;
        this.x = x;
        this.date = date;

    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Income [amount=" + amount + ", description=" + description + ", Category=" + s + "]";
    }

    public String ExpensetoString() {
        return "Expense [amount=" + amount + ", description=" + description + ", Category=" + x + "]";

    }

}

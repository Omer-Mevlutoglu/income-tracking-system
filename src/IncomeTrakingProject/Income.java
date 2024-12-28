package IncomeTrakingProject;

import java.time.LocalDate;

public class Income extends Transaction {
    public Income() {
    }

    public Income(double amount, String description, Category category, LocalDate date) {
        super(amount, description, category, date);

    }

    public void getdetails() {
        System.out.println(super.toString() + " Date:" + date);
    }
}

enum Category {
    salary, freelanceWork, wife_Salary, UNKNOWN;
}

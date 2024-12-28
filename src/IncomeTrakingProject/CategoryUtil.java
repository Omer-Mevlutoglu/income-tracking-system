package IncomeTrakingProject;

public class CategoryUtil {
    public static Category getIncomeCategory(String cat) {
        switch (cat.toLowerCase()) {
            case "salary":
                return Category.salary;
            case "freelance work":
                return Category.freelanceWork;
            case "wife salary":
                return Category.wife_Salary;
            default:
                return Category.UNKNOWN;
        }
    }

    public static expenseCategory getExpenseCategory(String cat) {
        switch (cat.toLowerCase()) {
            case "rent":
                return expenseCategory.rent;
            case "groceries":
                return expenseCategory.groceries;
            case "utilities":
                return expenseCategory.utilties;
            case "entertainment":
                return expenseCategory.entertainment;
            default:
                return expenseCategory.UNKNOWN;
        }
    }
}

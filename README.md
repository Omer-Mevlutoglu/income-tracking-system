The Personal Finance Manager is a Java-based application designed to help users track and manage their personal finances effectively. It provides functionalities for recording income and expenses, viewing transaction details, and generating detailed financial reports.

--Features
Add Income and Expenses: Record various income sources and expense categories.
View Transactions: View all transactions or filter them by category.
Generate Reports:
Overall Savings Report
Detailed Income Report
Detailed Expense Report
Persistent Storage: Automatically saves and loads transaction data from a file.

--How to Use: 
1.Clone this repository:git clone https://github.com/yourusername/PersonalFinanceManager.git 
2.cd PersonalFinanceManager
3.Compile the code:javac -d bin src/IncomeTrakingProject/*.java
4.Run the application:java -cp bin IncomeTrakingProject.TheMainProg
5.Follow the menu prompts to:
Add income or expenses.
View transaction details.
Generate reports.
Save and exit the program.

--Project Structure
TheMainProg: Entry point for the application. Handles user interactions through a console menu.
Reports: Manages transactions and generates reports.
Transaction: Base class representing a transaction with shared properties like amount, description, and date.
Income and Expense: Subclasses of Transaction for income and expense-specific data.
Category and expenseCategory: Enums for predefined categories of income and expenses.
CategoryUtil: Utility class for mapping user input to appropriate categories.

--File Storage
Transaction data is stored in a serialized file named Transactions.txt. It is automatically loaded when the program starts and saved when the program exits.

--Prerequisites
Java 8 or higher.
Basic knowledge of Java and command-line usage.


--Sample Usage

Welcome to the personal finance manager
1. Add income
2. Add expense
3. View Transaction
4. Generate report
5. Save and Exit

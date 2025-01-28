The Personal Finance Manager is a Java-based application designed to help users track and manage their personal finances effectively. It provides functionalities for recording income and expenses, viewing transaction details, and generating detailed financial reports.

## Features
1. **Add Income and Expenses**: Record various income sources and expense categories.
2. **View Transactions**: View all transactions or filter them by category (income or expense).
3. **Generate Reports**:
   - **Overall Savings Report**: Net savings (income - expenses).
   - **Detailed Income Report**: Breakdown of income by category.
   - **Detailed Expense Report**: Breakdown of expenses by category.
4. **Persistent Storage**: Automatically saves and loads transaction data from a file (`Transactions.txt`).

## How to Use 
1. Clone this repository:
```bash
git clone https://github.com/yourusername/PersonalFinanceManager.git
```
2. Navigate to The personal finance manager:
```bash
cd PersonalFinanceManager
```
4. Compile the code:
```bash
javac -d bin src/IncomeTrakingProject/*.java
```
6. Run the application:
```bash
java -cp bin IncomeTrakingProject.TheMainProg
```
8. Follow the menu prompts to:
  - Add income or expenses.
  - View transaction details.
  - Generate reports.
  - Save and exit the program.

## Using the Application
Once the application starts, you will see the following menu:

```
Welcome to the Personal Finance Manager
1. Add Income
2. Add Expense
3. View Transactions
4. Generate Report
5. Save and Exit
```

### 1. Add Income
- Enter the amount, description, and category (`salary`, `freelanceWork`, `wife_Salary`).
- Example:
  ```
  Enter amount: 5000
  Enter description: Salary
  Enter income Category: salary
  Enter a date (YYYY-MM-DD): 2023-10-15
  Income added successfully!
  ```

### 2. Add Expense
- Enter the amount, description, and category (`rent`, `groceries`, `utilities`, `entertainment`).
- Example:
  ```
  Enter amount: 1200
  Enter description: Rent
  Enter expense Category: rent
  Enter a date (YYYY-MM-DD): 2023-10-15
  Expense added successfully!
  ```

### 3. View Transactions
- View all transactions or filter by category (income or expense).
- Example:
  ```
  1. All
  2. By Category
  Enter your choice: 2
  1. View Income
  2. View Expense
  Enter your choice: 1
  Income [amount=5000.0, description=Salary, Category=salary] Date: 2023-10-15
  ```

### 4. Generate Report
- Choose the type of report:
  - **Overall Savings Report**: Displays total income, total expenses, and net savings.
  - **Detailed Income Report**: Breakdown of income by category.
  - **Detailed Expense Report**: Breakdown of expenses by category.
- Example:
  ```
  Choose the type of report you want to generate:
  1. Overall Savings Report
  2. Detailed Income Report
  3. Detailed Expense Report
  Enter your choice: 1
  The total income is: 5000.0
  The total expense is: 1200.0
  Savings = 3800.0
  ```

### 5. Save and Exit
- Saves all transactions to `Transactions.txt` and exits the program.

---

## Project Structure
The project is organized into the following classes:

### Core Classes
- **`TheMainProg`**: Entry point for the application. Handles user interactions through a console menu.
- **`Reports`**: Manages transactions and generates reports.
- **`Transaction`**: Base class representing a transaction with shared properties like amount, description, and date.
- **`Income` and `Expense`**: Subclasses of `Transaction` for income and expense-specific data.
- **`Category` and `expenseCategory`**: Enums for predefined categories of income and expenses.
- **`CategoryUtil`**: Utility class for mapping user input to appropriate categories.

---

## File Storage
Transaction data is stored in a **serialized file** named `Transactions.txt`. It is automatically loaded when the program starts and saved when the program exits.

---

## Sample Usage

### Example Workflow
1. Add an income:
   ```
   Enter amount: 5000
   Enter description: Salary
   Enter income Category: salary
   Enter a date (YYYY-MM-DD): 2023-10-15
   Income added successfully!
   ```
2. Add an expense:
   ```
   Enter amount: 1200
   Enter description: Rent
   Enter expense Category: rent
   Enter a date (YYYY-MM-DD): 2023-10-15
   Expense added successfully!
   ```
3. Generate a savings report:
   ```
   The total income is: 5000.0
   The total expense is: 1200.0
   Savings = 3800.0
   ```

---

## Troubleshooting
- **No existing transactions data found**: This message appears if `Transactions.txt` does not exist. It is safe to ignore on the first run.
- **Invalid date format**: Ensure dates are entered in `YYYY-MM-DD` format.
- **Error saving transaction data**: Check file permissions or disk space.

---

## Contributing
Contributions are welcome! Please fork the repository and submit a pull request.

---

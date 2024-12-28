package IncomeTrakingProject;

import java.io.IOException;
import java.util.Scanner;

public class TheMainProg {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Reports r = new Reports();
        try {
            r.loadFromFile();
            System.out.println("Transaction data loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existing transactions data found. Starting fresh.");
        }

        while (true) {
            System.out.println("Welcome to the personal finance manger ");
            System.out.println("1.Add income\n2.Add expense\n3.ViewTransaction\n4.Generate report\n5.Sava and Exit");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    r.Enter_basic_details(input, choice);
                    System.out.println("Income added successfully");
                    break;
                case 2:
                    r.Enter_basic_details(input, choice);
                    System.out.println("Expense added successfully");
                    break;
                case 3:
                    r.ViewTransaction(input);
                    break;
                case 4:
                    r.generate_reports(input);
                    break;
                case 5:
                    try {
                        r.saveToFile();
                        System.out.println("Transaction data saved to file. Thank you.");
                    } catch (IOException e) {
                        System.out.println("Error saving Transcation data: " + e.getMessage());
                    }
                    return;
                default:
                    System.out.println("İnvalid input");
                    break;
            }
        }

    }
}


import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {

    static class Expense {
        String name;
        String category;
        double amount;

        Expense(String name, String category, double amount) {
            this.name = name;
            this.category = category;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> expenses = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== PERSONAL EXPENSE TRACKER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Total Spending");
            System.out.println("4. View Spending by Category");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Please enter a number from 1 to 5.");
                sc.next();
                System.out.print("Enter your choice: ");
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter expense name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter amount: ");
                    while (!sc.hasNextDouble()) {
                        System.out.println("Please enter a valid amount.");
                        sc.next();
                        System.out.print("Enter amount: ");
                    }
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    if (amount <= 0) {
                        System.out.println("Amount must be greater than zero.");
                    } else {
                        expenses.add(new Expense(name, category, amount));
                        System.out.println("Expense added successfully!");
                    }
                    break;

                case 2:
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses recorded yet.");
                    } else {
                        System.out.println("\n--- All Expenses ---");
                        for (Expense e : expenses) {
                            System.out.printf(
                                "%s | %s | Rs. %.2f%n",
                                e.name, e.category, e.amount
                            );
                        }
                    }
                    break;

                case 3:
                    double total = 0;
                    for (Expense e : expenses) {
                        total += e.amount;
                    }
                    System.out.printf("Total spending: Rs. %.2f%n", total);
                    break;

                case 4:
                    System.out.print("Enter category to search: ");
                    String searchCategory = sc.nextLine();
                    double categoryTotal = 0;
                    boolean found = false;

                    for (Expense e : expenses) {
                        if (e.category.equalsIgnoreCase(searchCategory)) {
                            System.out.printf(
                                "%s | Rs. %.2f%n", e.name, e.amount
                            );
                            categoryTotal += e.amount;
                            found = true;
                        }
                    }

                    if (found) {
                        System.out.printf(
                            "Category total: Rs. %.2f%n", categoryTotal
                        );
                    } else {
                        System.out.println("No expenses found in this category.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using Expense Tracker!");
                    break;

                default:
                    System.out.println("Invalid choice. Enter 1 to 5.");
            }

        } while (choice != 5);

        sc.close();
    }
}

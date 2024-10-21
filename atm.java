import java.util.*;

public class ATM {
    private static double atmBalance = 100000; // Initialize ATM balance
    private static double userBalance = 5000;  // Initialize user's balance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0; // Initialize choice with a default value

        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw Money");
            System.out.println("2. Deposit Money");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    withdrawMoney(scanner);
                    break;
                case 2:
                    depositMoney(scanner);
                    break;
                case 3:
                    System.out.println("Exiting... Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3); // Exit when the user chooses option 3

        scanner.close(); // Close the scanner when done
    }

    private static void withdrawMoney(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter amount to withdraw: ");
                double amount = scanner.nextDouble();

                if (amount <= 0) {
                    System.out.println("Please enter a valid amount greater than zero.");
                } else if (amount > atmBalance) {
                    System.out.println("ATM does not have enough balance.");
                } else if (amount > userBalance) {
                    System.out.println("Insufficient account balance.");
                } else {
                    // If all checks pass
                    userBalance -= amount;
                    atmBalance -= amount;
                    System.out.println("Withdrawal successful! New user balance: " + userBalance);
                    System.out.println("New ATM balance: " + atmBalance);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private static void depositMoney(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter amount to deposit: ");
                double amount = scanner.nextDouble();

                if (amount <= 0) {
                    System.out.println("Please enter a valid amount greater than zero.");
                } else if (amount > 50000) {
                    System.out.println("Maximum deposit amount is 50000.");
                } else {
                    // If all checks pass
                    userBalance += amount;
                    atmBalance += amount;
                    System.out.println("Deposit successful! New user balance: " + userBalance);
                    System.out.println("New ATM balance: " + atmBalance);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }
}

import java.util.Scanner;

public class ATM {
    private double balance;
    private Scanner scanner;

    public ATM(double initialBalance) {
        this.balance = initialBalance;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        int choice;

        do {
            displayMenu();
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                scanner.next(); // clear the invalid input
                displayMenu();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting ATM...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount. Please enter a valid number.");
            scanner.next(); // clear the invalid input
            System.out.print("Enter amount to withdraw: ");
        }
        double amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Please collect your cash.");
        }
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount. Please enter a valid number.");
            scanner.next(); // clear the invalid input
            System.out.print("Enter amount to deposit: ");
        }
        double amount = scanner.nextDouble();

        balance += amount;
        System.out.println("Deposit successful.");
    }

    private void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    public static void main(String[] args) {
        ATM atm = new ATM(100.00); // Set initial balance
        atm.run();
    }
}

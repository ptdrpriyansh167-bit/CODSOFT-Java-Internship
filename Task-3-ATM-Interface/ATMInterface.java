import java.util.Scanner;

// Bank Account class
class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Check balance
    public double checkBalance() {
        return balance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful!");
            System.out.println("Deposited Amount: Rs." + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
            System.out.println("Available Balance: Rs." + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful!");
            System.out.println("Withdrawn Amount: Rs." + amount);
        }
    }
}

// ATM class
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BankAccount account = new BankAccount(10000);

        // Initialize choice
        int choice = 0;

        System.out.println("=================================");
        System.out.println("          ATM INTERFACE");
        System.out.println("=================================");

        do {

            System.out.println("\n----------- ATM MENU -----------");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.println("--------------------------------");

            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nCurrent Balance: Rs." 
                            + account.checkBalance());
                    break;

                case 2:
                    System.out.print("\nEnter amount to deposit: Rs.");

                    if (scanner.hasNextDouble()) {
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Invalid amount!");
                        scanner.next();
                    }
                    break;

                case 3:
                    System.out.print("\nEnter amount to withdraw: Rs.");

                    if (scanner.hasNextDouble()) {
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Invalid amount!");
                        scanner.next();
                    }
                    break;

                case 4:
                    System.out.println("\nThank you for using the ATM!");
                    break;

                default:
                    System.out.println(
                        "Invalid choice! Please select 1 to 4."
                    );
            }

        } while (choice != 4);

        scanner.close();
    }
}

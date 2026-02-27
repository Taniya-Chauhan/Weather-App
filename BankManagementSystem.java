import java.util.Scanner;
import java.util.ArrayList;

// Class representing a bank account
class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
     BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Deposit method
     void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited ₹" + amount);
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }

    // Withdraw method
     void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Display account details
     void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: ₹" + balance);
    }

    // Getter for account number
     String getAccountNumber() {
        return accountNumber;
    }
}

// Main Bank Management System class
public class BankManagementSystem {
    private static ArrayList<BankAccount> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Bank Management System ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch(choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    displayAccountDetails();
                    break;
                case 6:
                    System.out.println("Thank you for using the Bank Management System!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while(choice != 6);
    }

    // Create a new account
    public static void createAccount() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Initial Deposit Amount: ₹");
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        BankAccount account = new BankAccount(accountNumber, name, initialDeposit);
        accounts.add(account);
        System.out.println("Account created successfully!");
    }

    // Deposit money into account
    public static void depositMoney() {
        BankAccount account = findAccount();
        if(account != null) {
            System.out.print("Enter amount to deposit: ₹");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            account.deposit(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Withdraw money from account
    public static void withdrawMoney() {
        BankAccount account = findAccount();
        if(account != null) {
            System.out.print("Enter amount to withdraw: ₹");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            account.withdraw(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Check account balance
    public static void checkBalance() {
        BankAccount account = findAccount();
        if(account != null) {
            System.out.println("Current Balance: ₹" + account.getAccountNumber());
        } else {
            System.out.println("Account not found!");
        }
    }

    // Display account details
    public static void displayAccountDetails() {
        BankAccount account = findAccount();
        if(account != null) {
            account.displayDetails();
        } else {
            System.out.println("Account not found!");
        }
    }

    // Helper method to find account by account number
    public static BankAccount findAccount() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        for(BankAccount account : accounts) {
            if(account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
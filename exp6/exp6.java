package exp;
import java.util.Scanner;
interface Transaction {
    void deposit(double amount);
    void withdraw(double amount);
    void viewbalance();
    void viewaccountdetails();
}
abstract class Account {
    String acc_name;
    int acc_no;
    double balance;
    Account(String acc_name, int acc_no, double balance) {
        this.acc_name = acc_name;
        this.acc_no = acc_no;
        this.balance = balance;
    }
    abstract void displayAccount();
}
class Bank extends Account implements Transaction {
    Bank(String acc_name, int acc_no, double balance) {
        super(acc_name, acc_no, balance);
    }
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Amount of Rs. " + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid amount! Please enter a positive value.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0) {
            if (this.balance >= amount) {
                this.balance -= amount;
                System.out.println("Amount of Rs. " + amount + " withdrawn successfully.");
            } else {
                System.out.println("Sorry, insufficient balance.");
            }
        } else {
            System.out.println("Invalid withdrawal amount. Please try again.");
        }
    }
    public void viewbalance() {
        System.out.println("Current Balance: Rs. " + balance);
    }
    public void viewaccountdetails() {
        displayAccount();
    }
    void displayAccount() {
        System.out.println("\n----- Account Details -----");
        System.out.println("Account Holder Name: " + acc_name);
        System.out.println("Account Number     : " + acc_no);
        System.out.println("Current Balance    : Rs. " + balance);
    }
}
public class exp6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Account Number: ");
        int num = sc.nextInt();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();
        Bank customer = new Bank(name, num, balance);
        int choice;
        do {
            System.out.println("\n----- BANK MENU -----");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    customer.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    customer.withdraw(withdrawAmount);
                    break;
                case 3:
                    customer.viewbalance();
                    break;
                case 4:
                    customer.viewaccountdetails();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        sc.close();
    }
}


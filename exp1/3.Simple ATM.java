package hi;
import java.util.Scanner;
public class exp1q3 {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        double balance = 10000;
	        int choice;
	        do {
	            System.out.println("\n--- ATM Menu ---");
	            System.out.println("1. Check Balance");
	            System.out.println("2. Deposit Money");
	            System.out.println("3. Withdraw Money");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.println("Current Balance: ₹" + balance);
	                    break;
	                case 2:
	                    System.out.print("Enter amount to deposit: ₹");
	                    double deposit = sc.nextDouble();
	                    balance += deposit;
	                    System.out.println("Deposit Successful!");
	                    break;
	                case 3:
	                    System.out.print("Enter amount to withdraw: ₹");
	                    double withdraw = sc.nextDouble();
	                    if (withdraw <= balance) {
	                        balance -= withdraw;
	                        System.out.println("Withdrawal Successful!");
	                    } else {
	                        System.out.println("Insufficient Balance!");
	                    }
	                    break;
	                case 4:
	                    System.out.println("Thank you for using the ATM!");
	                    break;
	                default:
	                    System.out.println("Invalid choice! Try again.");
	            }
	        } while (choice != 4);
	    }
	}


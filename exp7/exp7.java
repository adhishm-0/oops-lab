package exp7;
	import java.util.Scanner;
	class InvalidATMPinException extends Exception {
	    public InvalidATMPinException(String message) {
	        super(message);
	    }
	}
	class NoCashException extends Exception {
	    public NoCashException(String message) {
	        super(message);
	    }
	}
	class Account {
	    private String name;
	    private double balance;
	    private int atmPin;
	    public Account(String name, double balance, int atmPin) {
	        this.name = name;
	        this.balance = balance;
	        this.atmPin = atmPin;
	    }
	    public void checkPin(int enteredPin) throws InvalidATMPinException {
	        if (this.atmPin != enteredPin) {
	            throw new InvalidATMPinException("Invalid ATM Pin!");
	        } else {
	            System.out.println("ATM Pin is correct.");
	        }
	    }
	    public void withdraw(double amount) throws NoCashException {
	        if (amount > balance) {
	            throw new NoCashException("Insufficient balance. Cannot withdraw.");
	        } else {
	            balance -= amount;
	            System.out.println("Withdrawal successful! Remaining Balance: ₹" + balance);
	        }
	    }
	}
	public class exp7 {   
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter Account Holder Name: ");
	        String name = sc.nextLine();

	        System.out.print("Enter Initial Balance: ");
	        double balance = sc.nextDouble();

	        System.out.print("Set ATM Pin: ");
	        int setPin = sc.nextInt();

	        Account acc = new Account(name, balance, setPin);

	        int choice;
	        boolean isPinCorrect = false;

	        while (true) {
	            System.out.println("\n----- ATM Menu -----");
	            System.out.println("1. Check PIN");
	            System.out.println("2. Withdraw Cash");
	            System.out.println("3. Exit");
	            System.out.print("Select an option: ");
	            choice = sc.nextInt();

	            try {
	                switch (choice) {
	                    case 1:
	                        System.out.print("Enter ATM Pin: ");
	                        int enteredPin = sc.nextInt();
	                        acc.checkPin(enteredPin);
	                        isPinCorrect = true;
	                        break;

	                    case 2:
	                        if (!isPinCorrect) {
	                            System.out.println("Please check PIN first!");
	                        } else {
	                            System.out.print("Enter amount to withdraw: ");
	                            double amount = sc.nextDouble();
	                            acc.withdraw(amount);
	                        }
	                        break;

	                    case 3:
	                        System.out.println("Thank you! Exiting...");
	                        sc.close();
	                        return;

	                    default:
	                        System.out.println("Invalid option. Try again.");
	                }
	            } catch (InvalidATMPinException | NoCashException e) {
	                System.out.println(e.getMessage());
	            }	
	        }
	    }
	}



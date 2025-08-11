package hi;
import java.util.Scanner;
public class exp1q1 {

	public static void main(String[] args) {
	     Scanner sc = new Scanner(System.in);

	        int b_Price = 200;
	        System.out.print("Enter your age: ");
	        int age = sc.nextInt();
	        System.out.print("Enter day of booking (Mon/Tue/Wed/Thu/Fri/Sat/Sun): ");
	        String day = sc.next();

	        double price = b_Price;

	        if (age < 5) {
	            price = 0;
	        } else if (age >= 5 && age <= 18) {
	            price *= 0.60; 
	        } else if (age > 60) {
	            price *= 0.70; 
	        }

	        if (day.equalsIgnoreCase("Mon") || day.equalsIgnoreCase("Tue") ||
	            day.equalsIgnoreCase("Wed") || day.equalsIgnoreCase("Thu") ||
	            day.equalsIgnoreCase("Fri")) {
	            price *= 0.90; 
	        }

	        System.out.println("Ticket Price: ₹" + price);

	}

}

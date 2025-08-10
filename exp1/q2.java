package hi;
import java.util.Scanner;
public class exp1q2 {
	public static void main(String[] args) {
		        Scanner sc = new Scanner(System.in);
		        int[] usage = new int[12];
		        int total = 0;
		        for (int i = 0; i < 12; i++) {
		            System.out.print("Enter units for month " + (i + 1) + ": ");
		            usage[i] = sc.nextInt();
		            total += usage[i];
		        }
		        double average = total / 12.0;
		        System.out.println("Total Units: " + total);
		        System.out.println("Average Monthly Usage: " + average);
		        if (average > 500) {
		            System.out.println("High Consumption Alert!");
		        }
		    }
		}


	



package hi;
import java.util.Scanner;
public class q2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		 System.out.println("enter the no elements:");
	       int n = sc .nextInt(); boolean found = false;
		int arr[]= new int[n];
	    System.out.println("enter the elements:");
        for (int i =0;i<arr.length;i++) {
        	arr[i] =sc .nextInt();   
        
        }
        int target =0  ;
        System.out.println("enter the sum of the element:");
        target =sc .nextInt();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("The indices are: " + i + ", " + j);
                   found = true;
                    break;
                }
            }
            if (found) break;
        }

        if (!found) {
        	System.out.println("No two numbers add up to the target.");
        }


	}
	
}





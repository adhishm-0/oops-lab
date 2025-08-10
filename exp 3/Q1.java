package exp3;
import java.util.Scanner;
public class Q1 {

	public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("enter the no elements:");
       int n = sc .nextInt();
        int arr[]= new int[n];
        System.out.println("enter the elements:");
        for (int i =0;i<arr.length;i++) {
        	arr[i] =sc .nextInt();       	
        }
        System.out.println("enter the elements x:");
        int search = sc.nextInt();
        System.out.println(" the elements to search:"+search);
        int count=0; int arr2[]=new int[n];
        for(int i=0;i<arr.length;i++) {
        	if (search>arr[i]) {
        		arr2[i]=arr[i];
        		count++;
        	}
        	
        }System.out.println("the no elemnt lesser than search:"+count);
        for(int i=0;i<arr2.length;i++) {
        	if (arr2[i] != 0) {
        		System.out.println(arr2[i]);
        	}

        	
        }
	}
	

}

package hi;
import java.util.Scanner;
public class exp3q1 {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the paragraph:");
	        String paragraph = sc.nextLine();
	        System.out.println("Enter the word to search:");
	        String word = sc.nextLine();
	        paragraph = paragraph.toLowerCase();
	        word = word.toLowerCase();
	        String[] wordsArray = paragraph.split(" ");
	        int count = 0;
	        for (String w : wordsArray) {
	            if (w.equals(word)) {
	                count++;
	            }
	        }
	        System.out.println("The given word '" + word + "' is found " + count + " times");
	    }
	}

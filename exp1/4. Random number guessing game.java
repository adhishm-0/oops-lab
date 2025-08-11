package hi;
import java.util.Scanner;
import java.util.Random;

public class exp1q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int number = rand.nextInt(100) + 1;
        int guess = -1; 
        int attempts = 0;
        System.out.println("Guess the number between 1 and 100 (You have 5 attempts):");
        while (guess != number && attempts < 5) {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            attempts++;

            if (guess > number) {
                System.out.println("Too High");
            } else if (guess < number) {
                System.out.println("Too Low");
            } else {
                System.out.println("Correct Guess!");
            }
        }
        if (guess != number) {
            System.out.println("Out of attempts! Better luck next time!");
        }
    }
}

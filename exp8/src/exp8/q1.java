package exp8;
import java.util.*;

class WordThread implements Runnable {
    String paragraph;

    WordThread(String paragraph) {
        this.paragraph = paragraph;
    }

    public void run() {
        String[] words = paragraph.split(" ");
        for (String word : words) {
            System.out.println("Word: " + word);
            try { Thread.sleep(2000); } catch (Exception e) {}
        }
    }
}

class VowelThread implements Runnable {
    String paragraph;

    VowelThread(String paragraph) {
        this.paragraph = paragraph;
    }

    public void run() {
        for (char ch : paragraph.toCharArray()) {
            if ("AEIOUaeiou".indexOf(ch) != -1) {
                System.out.println("Vowel: " + ch);
                try { Thread.sleep(2000); } catch (Exception e) {}
            }
        }
    }
}

public class inter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a paragraph:");
        String text = sc.nextLine();

        Thread t1 = new Thread(new WordThread(text));
        Thread t2 = new Thread(new VowelThread(text));

        t1.start();
        t2.start();
    }
}


import java.util.*;

class TableThread extends Thread {
    int num;

    TableThread(int num) {
        this.num = num;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
            try { Thread.sleep(2000); } catch (Exception e) {}
        }
    }
}

class DivisorThread extends Thread {
    int num;

    DivisorThread(int num) {
        this.num = num;
    }

    public void run() {
        System.out.println("Divisors of " + num + ":");
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.println(i);
                try { Thread.sleep(2000); } catch (Exception e) {}
            }
        }
    }
}

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = sc.nextInt();

        TableThread t1 = new TableThread(num);
        DivisorThread t2 = new DivisorThread(num);

        t1.start();
        t2.start();
    }
}



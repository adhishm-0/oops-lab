import java.util.*;

class EvenThread extends Thread {
    int[] arr;

    EvenThread(int[] arr) {
        this.arr = arr;
    }

    public void run() {
        for (int num : arr) {
            if (num % 2 == 0) {
                System.out.println("Even: " + num);
                try { Thread.sleep(2000); } catch (Exception e) {}
            }
        }
    }
}

class OddThread extends Thread {
    int[] arr;

    OddThread(int[] arr) {
        this.arr = arr;
    }

    public void run() {
        for (int num : arr) {
            if (num % 2 != 0) {
                System.out.println("Odd: " + num);
                try { Thread.sleep(2000); } catch (Exception e) {}
            }
        }
    }
}

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("Enter 10 numbers:");

        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        EvenThread t1 = new EvenThread(arr);
        OddThread t2 = new OddThread(arr);

        t1.start();
        t2.start();
    }
}


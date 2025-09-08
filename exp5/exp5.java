package Exp5;
import java.util.Scanner;

class Worker {
    protected String name;
    protected double salary_rate;
    protected double final_payment;

    public Worker(String name, double salary_rate) {
        this.name = name;
        this.salary_rate = salary_rate;
    }

    public void compute_payment(int hours) {
        final_payment = salary_rate * hours;
    }

    public void displayDetails() {
        System.out.println("Worker Name  : " + name);
        System.out.println("Salary Rate  : " + salary_rate);
        System.out.println("Final Payment: " + final_payment);
    }
}

class daily_worker extends Worker {
    int no_days;

    public daily_worker(String name, double salary_rate, int no_days) {
        super(name, salary_rate);
        this.no_days = no_days;
    }

    public void compute_payment(int no_days) {
        final_payment = salary_rate * no_days * 8;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("No. of Days  : " + no_days);
    }
}
class salariedworker extends Worker {
    int no_hours;

    public salariedworker(String name, double salary_rate, int no_hours) {
        super(name, salary_rate);
        this.no_hours = no_hours;
    }
    public void compute_payment(int no_hours) {
        final_payment = salary_rate * 40;
    }
    public void displayDetails() {
        super.displayDetails();
        System.out.println("No. of Hours : " + no_hours);
    }
}
public class exp5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Worker worker = null;
        System.out.println("Choose the employee type ");
        System.out.println("1. Daily Worker");
        System.out.println("2. Salaried Worker");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Worker Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Salary Rate: ");
        double rate = sc.nextDouble();
        if (choice == 1) {
            System.out.print("Enter Number of Days: ");
            int days = sc.nextInt();
            worker = new daily_worker(name, rate, days);
        } else if (choice == 2) {
            System.out.print("Enter Number of Hours: ");
            int hours = sc.nextInt();
            worker = new salariedworker(name, rate, hours);
        } else {
            System.out.println("Invalid Choice!");
            System.exit(0);
        }
        int option;
        do {
            System.out.println("\n--- Worker Payment Menu ---");
            System.out.println("1. Calculate Payment");
            System.out.println("2. Display Details");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    if (worker instanceof daily_worker) {
                        daily_worker dw = (daily_worker) worker;
                        dw.compute_payment(dw.no_days);
                    } else if (worker instanceof salariedworker) {
                        salariedworker sw = (salariedworker) worker;
                        sw.compute_payment(sw.no_hours);
                    }
                    System.out.println("Payment calculated successfully!");
                    break;
                case 2:
                    worker.displayDetails();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (option != 3);

        sc.close();
    }
}

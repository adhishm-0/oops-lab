package exp4;
import java.util.Scanner;
class foodorder {
    private String ID;
    private String food_name;
    private int price;
    private int qty;
    private int order_count; 
    public foodorder(String ID, String food_name, int price, int qty) {
        this.ID = ID;
        this.food_name = food_name;
        this.price = price;
        this.qty = qty;
        this.order_count = 0; 
    }
    public void placeOrder() {
        if (order_count == 0) { 
            order_count++;
            System.out.println("New order placed for " + food_name + " with quantity " + qty);
        } else {
            System.out.println("Order for " + food_name + " has already been placed.");
        }
    }
    public void cancelOrder() {
        if (order_count > 0) {
            order_count--;
            System.out.println("Cancelled order for " + food_name + " with quantity " + qty);
        } else {
            System.out.println("There is no order to cancel.");
        }
    }
    public void totalBill() {
        if (order_count > 0) {
            double subtotal = (double) price * qty;
            int deliveryCharge = 50;
            double total = subtotal + deliveryCharge;
            System.out.println("\n--- Calculating Bill ---");
            System.out.println("Subtotal for " + food_name + ": " + subtotal + " rupees");
            System.out.println("Delivery charge: " + deliveryCharge + " rupees");
            System.out.println("The total amount of the order is: " + total + " rupees");
        } else {
            System.out.println("No bill to display. An order must be placed first.");
        }
    }
    public void display() {
        System.out.println("\n------- Order Details -------");
        System.out.println("Name: " + ID);
        System.out.println("Food name: " + food_name);
        System.out.println("Price per item: " + price);
        System.out.println("Quantity: " + qty);
        System.out.println("Order status: " + (order_count > 0 ? "Placed" : "Not Placed"));
    }
}
public class que {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String ID = sc.nextLine();
        System.out.println("Enter the food name:");
        String food_name = sc.nextLine();
        System.out.println("Enter the price:");
        int price = sc.nextInt();
        System.out.println("Enter quantity of food:");
        int qty = sc.nextInt();
        foodorder order1 = new foodorder(ID, food_name, price, qty);

        int choice;
        do {
            System.out.println("\n-------- Food Delivery Menu -------------");
            System.out.println("1. Place an order");
            System.out.println("2. Cancel the order");
            System.out.println("3. Display the order info");
            System.out.println("4. Show total bill");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); 
                choice = 0;
            }
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    order1.placeOrder();
                    break;
                case 2:
                    order1.cancelOrder();
                    break;
                case 3:
                    order1.display();
                    break;
                case 4:
                    order1.totalBill();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
        sc.close(); 
    }
}
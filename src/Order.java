import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Order implements Serializable{
    private ArrayList<OrderItem> cart;
    private double totalPrice = 0;
    private String orderStatus = "New";
    private boolean checkedOut = false;
    private int isDineIn = 0;
    private int orderID;
    private LocalDateTime pickupDeadLine;

    //constructor
    public Order() {
        this.cart = new ArrayList<>();
    }

    //methods
    public void printOrder(){
        if (cart.isEmpty()){
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("Your order number is: " + orderID);
        System.out.println("You have ordered: ");
        for (OrderItem item : cart){
            System.out.printf("%dx %s - $%.2f\n", item.getQuantity(), item.getName(), item.getPrice() * item.getQuantity());
            if (item.getCustomisation().equals("")){
                continue;
            }else{
                System.out.printf("\tCustomisation: %s\n", item.getCustomisation());
            }
        }
        if (this.isDineIn != 0){
            System.out.printf("%s \n", this.isDineIn == 1 ? "Dine In" : "Takeaway");
        }
        System.out.printf("Total price is $%.2f\n", totalPrice);
        System.out.println();
    }

    public double calculateTotalPrice(){
        double currentPrice = 0;
        for (OrderItem item : cart){
            currentPrice += item.getQuantity() * item.getPrice();
        }
        return currentPrice;
    }

    public void addToCart(OrderItem order){
        cart.add(order);
        this.totalPrice += order.getPrice() * order.getQuantity();
        System.out.printf("Added: %dx %s", order.getQuantity(), order.getName());
    }

    public void removeFromCart(){
        int userChoice = 0;
        printOrder();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the item number you wish to remove (or any other number to exit): ");
        while (true){
            try{
                userChoice = scanner.nextInt();
                break;
            } catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
        if (userChoice > 0 && userChoice <= cart.size()){
            System.out.printf("Removed: %dx %s", cart.get(userChoice-1).getQuantity(), cart.get(userChoice-1).getName());
            this.totalPrice -= cart.get(userChoice-1).getPrice() * cart.get(userChoice-1).getQuantity();
            System.out.println();
            cart.remove(userChoice-1);
        }else return;
    }

    //called after user finalises cart and is ready to make pmt, updates checkedOut to be true
    public void finaliseCart() {
        this.checkedOut = true;
        int userChoice = 0;
        Scanner scanner = new Scanner(System.in);
        while (userChoice != 1 && userChoice != 2){
            System.out.println("Do you want to dine in or takeaway? (1/2)");
            while (true){
                try{
                    userChoice = scanner.nextInt();
                    break;
                } catch (InputMismatchException e){
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.nextLine();
                }
            }
        }
        setDineIn((userChoice == 1) ? 1 : 2);
        System.out.println("Please proceed to payment.");
        System.out.println();
    }

    //getters and setters
    public LocalDateTime getPickupDeadline(){
        return pickupDeadLine;
    }
    public ArrayList<OrderItem> getCart() {
        return cart;
    }
    public void setCart(ArrayList<OrderItem> cart) {
        this.cart = cart;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice() {
        this.totalPrice = calculateTotalPrice();
    }
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String newStatus) {
        if ("Ready to Pickup".equals(newStatus) && !"Ready to Pickup".equals(orderStatus)) {
            this.orderStatus = newStatus;
            this.pickupDeadLine = LocalDateTime.now().plusSeconds(30); 
        } else {
            this.orderStatus = newStatus;
        }
    }

    public boolean getCheckedOut() {
        return checkedOut;
    }
    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    public int isDineIn() {
        return isDineIn;
    }
    public void setDineIn(int isDineIn) {
        this.isDineIn = isDineIn;
    }
}
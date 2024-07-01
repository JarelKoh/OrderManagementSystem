import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class OrderSystem extends PermutableBranch{
    private ArrayList<Order> orders;
    private Menu menu;
    private int currentOrderID;
    private ScheduledExecutorService scheduler;
    private ArrayList<Integer> deletedIDs;

    public OrderSystem() {
    }

    public void request(Branch br) {
        this.scheduler = Executors.newScheduledThreadPool(1); 
        startOrderStatusUpdater();
        this.orders = br.getOrderlist();
        this.menu = br.getMenu();
        this.deletedIDs = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Order System!");
        int choice = 0;
        int hasCreatedOrder = 0;
        
        do {
            System.out.println(
                    "\n1. Create a new order\n2. Print the Menu\n3. Add an item to the current order\n4. Remove an item from the current order\n5. View cart\n6. Checkout current order\n7. Exit");
            System.out.print("Choose an option: ");
            choice = SafeReadInt.request();   
            switch (choice) {
                case 1:
                    try{
                        this.currentOrderID = br.getOrderlist().size() + 1;
                    } catch (NullPointerException e){
                        this.currentOrderID = 1;
                    }
                    hasCreatedOrder = startNewOrder(hasCreatedOrder);
                    break;
                case 2:
                    printMenu(br);
                    break;
                case 3: 
                    addItemToCurrentOrder(hasCreatedOrder);
                    break;
                case 4:
                    removeItem(hasCreatedOrder);
                    break;
                case 5:
                    printCurrentOrder(hasCreatedOrder);
                    break;
                case 6:
                    if (checkoutCurrentOrder(hasCreatedOrder, br) == -1) break;
                    hasCreatedOrder = 0;
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        } while (choice != 7);
        
    }
    
    // all private methods- only request() can call them

    private void startOrderStatusUpdater() { 
        scheduler.scheduleAtFixedRate(() -> { 
            LocalDateTime now = LocalDateTime.now(); 
            for (Order order : new ArrayList<>(orders)) {  // Use a copy to avoid ConcurrentModificationException 
                if (order.getPickupDeadline().isBefore(now) && "Ready to Pickup".equals(order.getOrderStatus())) { 
                    order.setOrderStatus("Expired"); 
                    System.out.println("Order ID " + order.getOrderID() + " status updated to Expired."); 
                } 
            } 
        }, 0, 1, TimeUnit.MINUTES);  // Change to MINUTES for less frequent checks 
    }

    private int startNewOrder(int hasCreatedOrder) {
        if (hasCreatedOrder == 1){
            System.out.println("You already have created a new order. Please enter other options.");
            return 1;
        }

        try{
            Order order = new Order();
            order.setOrderID(currentOrderID);
            orders.add(order);
            System.out.println("New order created and added to the system.");
        } catch (NullPointerException e){
            orders = new ArrayList<>();
            Order order = new Order();
            order.setOrderID(currentOrderID);
            orders.add(order);
            System.out.println("New order created and added to the system.");
        }
        
        return 1;
    }

    private void printMenu(Branch br) {
        System.out.println("~~~~~~~~MENU~~~~~~~~");
        br.getMenu().printMenu();
    }

    private void addItemToCurrentOrder(int hasCreatedOrder) {
        if (hasCreatedOrder == 0) {
            System.out.println("No active order. Please create a new order first.");
            return;
        }

        Order currentOrder = orders.get(orders.size() - 1);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = SafeReadInt.request();
        //compares user entered string with name of each menu item, and initialises an OrderItem obj
        for (MenuItem item : menu.getMenuItems()){
            if (item.getName().trim().equalsIgnoreCase(name.trim())){
                OrderItem addedItem = new OrderItem(item.getItemId(), item.getAvailability(), item.getCategory(), item.getPrice(), item.getName(), item.getDescription(), quantity);
                addedItem.setCustomisation();
                currentOrder.addToCart(addedItem);
                return;
            }
        }System.out.println("Sorry, item not found. Please try again.");
    }

    private void removeItem(int hasCreatedOrder){
        if (hasCreatedOrder == 0){
            System.out.println("No active order.");
            return;
        }
        Order currentOrder = orders.get(orders.size() - 1);
        currentOrder.removeFromCart();
    }

    private void printCurrentOrder(int hasCreatedOrder) {
        if (hasCreatedOrder == 0) {
            System.out.println("No active order.");
            return;
        }
        Order currentOrder = orders.get(orders.size() - 1);
        if (currentOrder.getTotalPrice() == 0){
            System.out.println("Empty Cart. Please order an item before proceeding.");
            return;
        }
        currentOrder.printOrder();
    }

    private int checkoutCurrentOrder(int hasCreatedOrder, Branch br) {
        if (hasCreatedOrder == 0) {
            System.out.println("No active order to checkout.");
            return -1;
        }
        Order currentOrder = orders.get(orders.size() - 1);
        if (currentOrder.getTotalPrice() == 0){
            System.out.println("Empty Cart. Please order an item before proceeding.");
            return -1;
        }
        currentOrder.finaliseCart();

        br.setOrderlist(orders);
        hasCreatedOrder = 0;
        proceedToPayment();
        super.setBranch(br);
        return 1;
    }
    
    private void proceedToPayment(){
        Order currentOrder = orders.get(orders.size() - 1);
        if (currentOrder.getTotalPrice() == 0){
            System.out.println("Empty Cart. Please order an item before proceeding.");
            return;
        }
        CustomerPaymentView custView = new CustomerPaymentView();

        currentOrder.printOrder();
        custView.showPaymentOptions();

        System.out.println("You have paid. ");
        System.out.println("Please wait for your order to be ready.");
        System.out.println();
        return;
    }
}    
   
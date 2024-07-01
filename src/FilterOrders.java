import java.util.ArrayList;

public class FilterOrders {
    public FilterOrders(){}
    public static void request(ArrayList<Order> orders, String filter) {
        if (orders.size() == 0) {
            System.out.println("There are no orders at the moment.");
        }else {
            if (filter.equals("All")){
                System.out.println("Displaying all orders:");
                for (Order order : orders) {
                    System.out.println("ORDER ID: " + order.getOrderID());
                    System.out.println("Total Price: $" + String.format("%.2f", order.getTotalPrice()));
                    System.out.println("Status: " + order.getOrderStatus());
                    System.out.println();
                }
            }else{
                int found = 0;
                System.out.printf("Displaying %s orders:\n", filter);
                for (Order order : orders) {
                    if (order.getOrderStatus().equals(filter)) {
                        System.out.println("ORDER ID: " + order.getOrderID());
                        System.out.println("Total Price: $" + String.format("%.2f", order.getTotalPrice()));
                        System.out.println("Status: " + order.getOrderStatus());
                        System.out.println();
                        found = 1;
                    }
                }
                if (found == 0){
                    System.out.printf("There are no %s orders:\n", filter);
                }
            }
        }
    }
}

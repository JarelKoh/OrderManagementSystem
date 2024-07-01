import java.util.ArrayList;

/**
 * The {@code FilterOrders} class provides functionality to filter and display
 * orders based on their status. It can handle displaying all orders or only those
 * that match a specific filter.
 */
public class FilterOrders {
    /**
     * Constructs a new {@code FilterOrders} object.
     * This constructor is not performing any operations as of now.
     */
    public FilterOrders(){}
    /**
     * Filters and displays orders based on the specified filter criteria.
     * If the filter is "All", all orders are displayed. Otherwise, only the orders
     * matching the specified filter are shown.
     *
     * @param orders the list of {@code Order} objects to be filtered and displayed
     * @param filter the filter criteria used to display orders. If "All", all orders are displayed.
     *               Otherwise, displays orders that match the filter criteria (e.g., "Pending").
     */
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

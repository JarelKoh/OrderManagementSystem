import java.util.ArrayList;
/**
 * The CheckOrderStatus class implements the NonPermutableBranch interface
 * and provides functionality to check the status of an order.
 */
public class CheckOrderStatus implements NonPermutableBranch{
     /**
     * Constructs a new CheckOrderStatus object.
     */
    public CheckOrderStatus(){}
    /**
     * Requests the user to enter an order ID and displays the order details
     * and status for the corresponding order.
     *
     * @param br the Branch object containing the list of orders
     */
    public void request(Branch br){
        System.out.println("Please enter order ID: ");
        int orderID = SafeReadInt.request();
        ArrayList<Order> orders = br.getOrderlist();
        for (int i = 0; i < orders.size(); i++){
            if (orders.get(i).getOrderID() == orderID){
                orders.get(i).printOrder();
                System.out.println("Your order status is: " + orders.get(i).getOrderStatus());
                return;
            }
        }
        System.out.println("Wrong Order ID. Please try again.");
    }
}

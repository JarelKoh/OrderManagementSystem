import java.util.ArrayList;
/**
 * The CollectFood class extends the PermutableBranch class and provides
 * functionality for collecting a completed food order.
 */
public class CollectFood extends PermutableBranch{
    /**
     * Constructs a new CollectFood object.
     */
    public CollectFood(){}
     /**
     * Requests the user to enter an order ID and marks the corresponding order
     * as "Completed" if it is ready for pickup.
     *
     * @param br the Branch object containing the list of orders
     */
    public void request(Branch br){
        System.out.println("Please enter order ID: ");
        int orderID = SafeReadInt.request();
        ArrayList<Order> orders = br.getOrderlist();
        for (int i = 0; i < orders.size(); i++){
            if (orders.get(i).getOrderID() == orderID){
                if (orders.get(i).getOrderStatus().equals("Ready to Pickup")){
                    System.out.println("You have collected your order. Thanks for visiting :-)");
                    orders.get(i).setOrderStatus("Completed");
                    br.setOrderlist(orders);
                    super.setBranch(br);
                    return;
                }else{
                    System.out.println("Your order is not ready. Please try again later.");
                    return;
                }
            }
        }System.out.println("Wrong Order ID. Please try again.");
        return;
    }
}

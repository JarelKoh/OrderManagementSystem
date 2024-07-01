import java.util.ArrayList;

public class CheckOrderStatus implements NonPermutableBranch{
    public CheckOrderStatus(){}
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

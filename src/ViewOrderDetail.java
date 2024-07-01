import java.util.ArrayList;
import java.util.Scanner;

public class ViewOrderDetail implements NonPermutableBranch{
    public ViewOrderDetail(){}
    public void request(Branch b) {
        ArrayList<Order> orders = b.getOrderlist();
        Scanner sc = new Scanner(System.in);
        int id = 0;
        do {
            if (orders.size() == 0) {
                System.out.println("There are no orders at the moment.");
                break;
            }else {
                System.out.println("Enter Order ID: (Enter -1 to Quit)");
                id = sc.nextInt();

                for (Order order : orders) {
                    if (order.getOrderID() == id) {
                        order.printOrder();
                        break;
                    }
                }
            }
        } while (id != -1);
    }
}

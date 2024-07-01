import java.util.ArrayList;
import java.util.Scanner;

/**
 * The {@code ViewOrderDetail} class implements the {@code NonPermutableBranch} interface
 * and provides functionality to view the details of an order in a specific branch.
 */
public class ViewOrderDetail implements NonPermutableBranch{
    /**
     * Constructs a new instance of the {@code ViewOrderDetail} class.
     */
    public ViewOrderDetail(){}
    
    /**
     * Displays the details of an order in the specified branch.
     *
     * @param b The {@code Branch} instance containing the list of orders.
     */
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

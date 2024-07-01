import java.util.Scanner;

/**
 * The {@code ProcessOrder} class extends the {@code PermutableBranch} class
 * and provides functionality to process orders by updating their status.
 */
public class ProcessOrder extends PermutableBranch{
    /**
     * Constructs a new instance of the {@code ProcessOrder} class.
     */
    public ProcessOrder(){}
    /**
     * Processes an order by updating its status based on user input.
     *
     * @param br The {@code Branch} instance containing the list of orders.
     */
    public void request(Branch br) {
        Scanner sc = new Scanner(System.in);
        int id = 0, choice, found = 0;

        do {
            if (br.getOrderlist().size() == 0) {
                System.out.println("There are no orders at the moment.");
                break;
            }else {
                System.out.println("Enter Order ID to process: (Enter -1 to Quit)");
                id = sc.nextInt();
                
                for (Order order : br.getOrderlist()) {
                    if (order.getOrderID() == id) {
                        System.out.println("Current order status: " + order.getOrderStatus());
                        System.out.println("""
                            Change Status to:
                            1. Processing
                            2. Ready to Pickup
                            3. Completed
                            4. Expired
                            """);
                        
                        choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                order.setOrderStatus("Processing");
                                break;
                            case 2:
                                order.setOrderStatus("Ready to Pickup");
                                break;
                            case 3:
                                order.setOrderStatus("Completed");
                                break;
                            case 4:
                                order.setOrderStatus("Expired");
                                break;
                            default:
                                System.out.println("Invalid input!");
                                break;
                        }
                        found = 1;
                        break;
                    }
                }
                if (found == 0){
                    System.out.println("Order does not exist!");
                } else{
                    br.setOrderlist(br.getOrderlist());
                    super.setBranch(br);
                    System.out.println("Order processed!");
                }
            }
        } while (id != -1);
    }
}
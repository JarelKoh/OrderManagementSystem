import java.util.ArrayList;
import java.util.Scanner;

public class DisplayOrders implements NonPermutableBranch{
    public DisplayOrders(){}
    public void request(Branch b) {
        ArrayList<Order> orders = b.getOrderlist();
        Scanner sc = new Scanner(System.in);
        String filter = "All";

        int choice;
        do {
            System.out.println("""
                Filter By Status:
                1. All
                2. New
                3. Processing
                4. Ready to Pickup
                5. Completed
                6. Expired
                7. Quit
                """);
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    filter = "All";
                    break;
                case 2:
                    filter = "New";
                    break;
                case 3:
                    filter = "Processing";
                    break;
                case 4:
                    filter = "Ready to Pickup";
                    break;
                case 5:
                    filter = "Completed";
                    break;
                case 6:
                    filter = "Expired";
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid input, please try again!");
            }
            if (choice != 7){
                FilterOrders.request(orders, filter);
            }
        } while (choice != 7);
    }
}
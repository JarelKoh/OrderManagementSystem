import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * The CustomerView class implements the UserView interface and provides a user interface
 * for customers to interact with the restaurant system.
 */
public class CustomerView implements UserView{
    private Branch b;
    /**
     * Constructs a new CustomerView object with the specified branch.
     *
     * @param b the branch associated with the customer view
     */
    public CustomerView(Branch b){
        this.b = b;
    }
    /**
     * Displays a menu of options for the customer and handles the user's choice.
     * The options include placing an order, tracking an order, collecting an order, and quitting.
     */
    public void view(){
        Scanner sc = new Scanner(System.in);
        PermutableController pcontroller = new PermutableController();
        NonPermutableController nController = new NonPermutableController();

        int choice;
        do {
            BranchApp bapp = new BranchApp();
            int i = bapp.getBranchIndex(b);
        
            System.out.println("""
                    Input Choice:
                    1. Place Order
                    2. Track Order
                    3. Collect Order
                    4. Quit
                    """);
            choice = 0;
            boolean valid = false;
            while (!valid) {
                try {
                    choice = sc.nextInt(); 
                    valid = true; 
                } catch (InputMismatchException ime) {
                    System.out.println("Invalid input. Please enter an integer.");
                    sc.next();  
                } catch (Exception e) {
                    System.out.println("An unexpected error occurred: " + e.getMessage());
                }
            }
            switch(choice){
                case 1:
                    PermutableBranch ordersys = new OrderSystem();
                    pcontroller.execute(ordersys, bapp.getBranchlList().get(i));
                    break;
                case 2:
                    NonPermutableBranch ordercheck = new CheckOrderStatus();
                    nController.execute(ordercheck, bapp.getBranchlList().get(i));
                    break;
                case 3:
                    PermutableBranch collectfood = new CollectFood();
                    pcontroller.execute(collectfood, bapp.getBranchlList().get(i));
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        } while (choice != 4);
    }
}

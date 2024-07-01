import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * The {@code StaffView} class implements the {@code UserView} interface, providing a console-based
 * user interface specifically for staff members to manage orders within a branch. It allows staff
 * to display orders, view order details, process orders, and quit the interface.
 */ 
public class StaffView implements UserView{
    private Branch branch;
     /**
     * Constructs a {@code StaffView} with a specific branch.
     * This constructor initializes the view with the branch where the staff will manage orders.
     *
     * @param branch The branch associated with this view, providing context and data for operations.
     */
    public StaffView(Branch branch){
        this.branch = branch;
    }
    /**
     * Provides an interactive command-line menu to the staff for managing orders. It presents
     * multiple options such as displaying orders, viewing order details, processing orders,
     * and quitting the application.
     */
    public void view(){
        Scanner sc = new Scanner(System.in);
        NonPermutableController ncontroller = new NonPermutableController();
        PermutableController pcontroller = new PermutableController();
        int choice;
        do {
            System.out.println("""
                    Input Choice:
                    1. Display orders
                    2. View order details
                    3. Process order
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
                    NonPermutableBranch orderdisplay = new DisplayOrders();
                    ncontroller.execute(orderdisplay, branch);
                break;
                case 2:
                    NonPermutableBranch orderdetail = new ViewOrderDetail();
                    ncontroller.execute(orderdetail, branch);
                    break;
                case 3:
                    PermutableBranch orderprocess = new ProcessOrder();
                    pcontroller.execute(orderprocess, branch);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid input, please try again!");
            }
        } while (choice != 4);
    }
}
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * This class provides the user interface for managers in the application.
 * It allows managers to interact with various management functions such as viewing and processing orders, managing staff, and editing menus.
 */
public class ManagerView implements UserView{
    private Branch b;
     /**
     * Constructs a new ManagerView associated with a specific branch.
     * @param b the branch this view will interact with
     */
    public ManagerView(Branch b){
        this.b = b;
    }
     /**
     * Displays the main menu and handles user input to navigate through various management options.
     * This method continuously prompts the user to choose an option until they decide to quit.
     * The options include displaying orders, viewing order details, processing orders, displaying the staff list, and editing the menu.
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
                    4. Display staff list
                    5. Edit menu
                    6. Quit
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
                    ncontroller.execute(orderdisplay, b);
                    break;
                case 2:
                    NonPermutableBranch orderdetail = new ViewOrderDetail();
                    ncontroller.execute(orderdetail, b);
                    break;
                case 3:
                    PermutableBranch orderprocess = new ProcessOrder();
                    pcontroller.execute(orderprocess, b);
                    break;
                case 4:
                    MDisplayStaff displaystaff = new MDisplayStaff();
                    ncontroller.execute(displaystaff, b);
                    break;
                case 5:
                    EditMenu menuedit = new EditMenu();
                    menuedit.request(b);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        } while (choice != 6);
    }
}
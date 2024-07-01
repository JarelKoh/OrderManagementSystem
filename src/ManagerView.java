import java.util.Scanner;
import java.util.InputMismatchException;
public class ManagerView implements UserView{
    private Branch b;
    public ManagerView(Branch b){
        this.b = b;
    }
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
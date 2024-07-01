import java.util.Scanner;
import java.util.InputMismatchException;

public class StaffView implements UserView{
    private Branch branch;
    public StaffView(Branch branch){
        this.branch = branch;
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
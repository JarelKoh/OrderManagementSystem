import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * The {@code AdminView} class provides an administrative interface to manage staff and branch operations.
 * It allows the admin to perform various functions like displaying staff lists, editing accounts,
 * assigning managers, promoting staff, transferring personnel, and modifying branch settings.
 */
public class AdminView implements UserView{
    /**
     * The branch for which the administrative tasks are performed.
     */
    private Branch b;
     /**
     * Constructs an {@code AdminView} object associated with a specific branch.
     *
     * @param b The branch associated with this view.
     */
    public AdminView(Branch b){
        this.b = b;
    }
/**
     * Displays an interactive menu to the admin user and processes the selected administrative actions.
     * The method continuously displays the menu and performs the selected action until the user chooses to quit.
     * The available options are:
     * 1. Display staff list
     * 2. Edit staff accounts
     * 3. Assign manager
     * 4. Promote staff
     * 5. Transfer staff/manager
     * 6. Add/remove payment method
     * 7. Open/close branch
     * 8. Quit
     *
     * Input errors are managed by catching {@code InputMismatchException} and prompting the user for correct input.
     */
    public void view(){
        PermutableController pcontroller = new PermutableController();
        NonPermutableController ncontroller = new NonPermutableController();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("""
                    Input Choice:
                    1. Display staff list
                    2. Edit staff accounts
                    3. Assign manager
                    4. Promote staff
                    5. Transfer staff/manager
                    6. Add/remove payment method
                    7. Open/close branch
                    8. Quit
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
                    ADisplayStaff displaystaff = new ADisplayStaff();
                    ncontroller.execute(displaystaff);
                    break;
                case 2:
                    Permutable staffedit = new EditStaff();
                    pcontroller.execute(staffedit);
                    break;
                case 3:
                    Permutable managerassign = new AssignManager();
                    pcontroller.execute(managerassign);
                    break;
                case 4:
                    Permutable staffpromote = new PromoteStaff();
                    pcontroller.execute(staffpromote);
                    break;
                case 5:
                    Permutable managertransfer = new TransferManager();
                    pcontroller.execute(managertransfer);
                    break;
                case 6:
                    AddPayment addpyament = new AddPayment();
                    ncontroller.execute(addpyament); 
                    break;
                case 7:
                    Permutable branchcreate = new CreateCloseBranch();
                    pcontroller.execute(branchcreate);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Please enter a valid input!");
                    break;
            }
        } while (choice != 8);
    }
}

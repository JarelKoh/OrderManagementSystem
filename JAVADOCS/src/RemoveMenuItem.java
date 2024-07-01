import java.util.Scanner;

/**
 * The {@code RemoveMenuItem} class extends {@code PermutableBranch} to provide functionality for
 * removing a menu item from a branch's menu. This class handles user interaction to identify which
 * item should be removed based on the item ID provided by the user.
 */ 
public class RemoveMenuItem extends PermutableBranch{
    /**
     * Constructs a new {@code RemoveMenuItem} instance. This constructor initializes the
     * RemoveMenuItem object.
     */
    public RemoveMenuItem(){}
    /**
     * Prompts the user to enter the ID of the menu item to be removed and performs the removal
     * process if the item exists. It updates the menu of the specified branch after the item is
     * removed. If the item ID does not exist, it informs the user.
     *
     * @param br The {@code Branch} from which a menu item is to be removed. The branch's menu is
     *           accessed and updated through this parameter.
     */
    public void request(Branch br){
        Menu menu = br.getMenu();        
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Item ID to remove:");
        int id = in.nextInt();

        if (br.getMenu().findMenuItem(id).getItemId() == 0){
            System.out.println("Item ID does not exist!");
            return;
        }
        
        menu.removeMenuItem(id); 

        br.setMenu(menu);
        super.setBranch(br);
        System.out.println("Menu item removed successfully!");
    }
}

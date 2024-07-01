import java.util.Scanner;

public class RemoveMenuItem extends PermutableBranch{
    public RemoveMenuItem(){}
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

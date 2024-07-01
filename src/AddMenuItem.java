import java.util.Scanner;

public class AddMenuItem extends PermutableBranch{
    public AddMenuItem(){}
    public void request(Branch br){
        Menu menu = br.getMenu();
        int id;
        double price;
        String name, desc, avail, cat;        

        Scanner in = new Scanner(System.in);
        System.out.println("Enter Item ID:");
        id = in.nextInt();
        if (menu.checkItemExistence(id) != false){
            System.out.println("ERROR! Item already exists!");
        } else{
            System.out.println("Enter Item Name:");
            name = in.next();
            
            //edited
            
            if (menu.checkItemExistence(name) != false){
                System.out.println("ERROR! Item already exists!");
            }else{
                System.out.println("Enter Item Price:");
                price = in.nextFloat();
                in.nextLine();
                System.out.println("Enter Item Description:");
                desc = in.nextLine();
                System.out.println("Enter Item Category:");
                cat = in.next();
                System.out.println("Enter Item Availability (Yes/No):");
                avail = in.next();
                menu.addMenuItem(new MenuItem(id, name, price, desc, cat, avail));
                br.setMenu(menu);
                super.setBranch(br);
                System.out.println("Menu item added successfully!");
            }
        }
    }
}

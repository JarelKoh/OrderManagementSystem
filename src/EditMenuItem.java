import java.util.Scanner;

public class EditMenuItem extends PermutableBranch{
    public EditMenuItem(){}
    public void request(Branch br){
        Menu menu = br.getMenu();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Item ID to edit:");
        int id = in.nextInt();
        
        if (br.getMenu().findMenuItem(id).getItemId() == 0){
            System.out.println("Item ID does not exist!");
            return;
        }

        int editchoice = 0, editted = 0;
        do {
            System.out.println("Enter choice to edit");
            System.out.println("(1) Item Name");
            System.out.println("(2) Item Price");
            System.out.println("(3) Item Description");
            System.out.println("(4) Item Category");
            System.out.println("(5) Item Availability");
            System.out.println("(6) Quit");

            editchoice = in.nextInt();
            in.nextLine();

            switch (editchoice) {
                case 1:
                    System.out.println("Enter new Item Name:");
                    String name = in.nextLine();
                    menu.findMenuItem(id).setName(name);
                    editted++;
                    break;
                case 2:
                    System.out.println("Enter new Item Price:");
                    float price = in.nextFloat();
                    menu.findMenuItem(id).setPrice(price);
                    editted++;
                    break;
                case 3:
                    System.out.println("Enter new Item Description:");
                    String desc = in.nextLine();
                    menu.findMenuItem(id).setDescription(desc);
                    editted++;
                    break;
                case 4:
                    System.out.println("Enter new Item Category:");
                    String cat = in.nextLine();
                    menu.findMenuItem(id).setCategory(cat);
                    editted++;
                    break;
                case 5:
                    System.out.println("Enter new Item Availability (Yes/No):");
                    String avail = in.nextLine();
                    menu.findMenuItem(id).setAvailability(avail);
                    editted++;
                    break;
                case 6:
                    System.out.println("Quitted");
                    break;
                default:
                    System.out.println("Please enter a valid choice!");
                    break;
            }
        } while (editchoice != 6);

        if (editted > 0){
            br.setMenu(menu);
            super.setBranch(br);
            System.out.println("Menu item edited successfully!");
        }
    }
}


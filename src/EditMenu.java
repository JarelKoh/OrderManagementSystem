import java.util.Scanner;
import java.util.InputMismatchException;

public class EditMenu {
    public EditMenu(){}
    public void request(Branch br){
        Scanner sc = new Scanner(System.in);
        PermutableController pController = new PermutableController();
        NonPermutableController nController = new NonPermutableController();
        int choice;
        try {
            do {
                System.out.println("""
                    Choose option:
                    1. Edit Menu Item
                    2. Add Menu Item
                    3. Remove Menu Item
                    4. Display Menu
                    5. Quit
                    """);
                choice = sc.nextInt();
                switch(choice){
                    case 1:
                        PermutableBranch menuEdit = new EditMenuItem();
                        pController.execute(menuEdit, br);
                        break;
                    case 2:
                        PermutableBranch menuAdd = new AddMenuItem();
                        pController.execute(menuAdd, br);
                        break;
                    case 3:
                        PermutableBranch menuRemove = new RemoveMenuItem();
                        pController.execute(menuRemove, br);
                        break;
                    case 4:
                        NonPermutableBranch displaymenu = new MenuDisplay();
                        nController.execute(displaymenu, br);
                        break;
                    case 5:
                        System.out.println("Quitted");
                        break;
                    default:
                        System.out.println("Invalid input!");
                        break;
                }
            } while (choice != 5);
        } catch (InputMismatchException ime) {
            System.out.println("Invalid input. Please enter an integer.");
        }
    }
}

/**
 * Represents a display mechanism for showing the menu of a specific branch.
 * This class is part of a system where different operations on a branch are handled by different classes,
 * adhering to a command pattern-like structure where this class could be seen as a specific command.
 */
public class MenuDisplay implements NonPermutableBranch{ 
      /**
     * Constructs a MenuDisplay object. This constructor is typically used when an instance
     * needs to be created without any initial setup.
     */
    public MenuDisplay(){}
 
        /**
     * Retrieves and displays the menu items from the menu of the specified branch.
     * This method prints each menu item to the standard output, providing a simple way to view all available items in the menu.
     * @param br the branch whose menu is to be displayed
     */
    public void request(Branch br) {
        Menu menu = br.getMenu();
        System.out.println("Menu:");
        for (MenuItem item : menu.getMenuItems()) {
            System.out.println(item);
        }
    }
}
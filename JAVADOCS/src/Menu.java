import java.util.ArrayList;
import java.io.Serializable;

/**
 * The {@code Menu} class represents a menu and manages a list of menu items.
 * It implements the {@code Serializable} interface to allow for object serialization.
 */
public class Menu implements Serializable{
    private ArrayList<MenuItem> menuItems;

    /**
     * Constructs a new empty {@code Menu} object.
     */
    public Menu() {
        this.menuItems = new ArrayList<>();
    }

    /**
     * Constructs a new {@code Menu} object with the provided list of menu items.
     *
     * @param menulist The list of {@code MenuItem} objects to initialize the {@code Menu} object with.
     */
    public Menu(ArrayList<MenuItem> menulist){
        this.menuItems = menulist;
    }

    /**
     * Adds a new menu item to the menu.
     *
     * @param item The {@code MenuItem} object to be added to the menu.
     * @return {@code true} if the item was added successfully, {@code false} if the item already exists.
     */
	public boolean addMenuItem(MenuItem item) {
	    if (checkItemExistence(item.getName()))
	    {
	        return false;
	    }
	    menuItems.add(item);
	    return true;
	}

    /**
     * Removes a menu item from the menu based on the item ID.
     *
     * @param itemId The ID of the menu item to be removed.
     */
    public void removeMenuItem(int itemId) {
        menuItems.removeIf(item -> item.getItemId() == itemId);
    }

    /**
     * Returns the list of menu items.
     *
     * @return The list of {@code MenuItem} objects in the menu.
     */
    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    /**
     * Finds a menu item in the menu based on the item ID.
     *
     * @param itemId The ID of the menu item to be found.
     * @return The {@code MenuItem} object with the specified ID, or a new {@code MenuItem} object if not found.
     */
    public MenuItem findMenuItem(int itemId){
        MenuItem foundItem = new MenuItem();
        for (MenuItem item : menuItems) {
            if (item.getItemId() == itemId){
                foundItem = item;
            }
        }
        return foundItem;
    }

    /**
     * Prints the names of all menu items in the menu.
     */
    public void printMenu(){
        for (int i = 0; i < menuItems.size(); i++){
            System.out.println(menuItems.get(i).getName());
        }
    }

    /**
     * Checks if a menu item with the specified name already exists in the menu.
     *
     * @param name The name of the menu item to check.
     * @return {@code true} if the item exists, {@code false} otherwise.
     */
    public boolean checkItemExistence (String name){
        for (MenuItem item : menuItems) {
           
            if (name.equalsIgnoreCase(item.getName())) {
                
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a menu item with the specified ID already exists in the menu.
     *
     * @param itemid The ID of the menu item to check.
     * @return {@code true} if the item exists, {@code false} otherwise.
     */
    public boolean checkItemExistence (int itemid){
        for (MenuItem item : menuItems) {
           
            if (item.getItemId() == itemid) {
                
                return true;
            }
        }
        return false;
    }
}
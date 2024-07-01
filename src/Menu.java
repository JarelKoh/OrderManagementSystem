import java.util.ArrayList;
import java.io.Serializable;

public class Menu implements Serializable{
    private ArrayList<MenuItem> menuItems;

    public Menu() {
        this.menuItems = new ArrayList<>();
    }

    public Menu(ArrayList<MenuItem> menulist){
        this.menuItems = menulist;
    }

	public boolean addMenuItem(MenuItem item) {
	    if (checkItemExistence(item.getName()))
	    {
	        return false;
	    }
	    menuItems.add(item);
	    return true;
	}


    public void removeMenuItem(int itemId) {
        menuItems.removeIf(item -> item.getItemId() == itemId);
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public MenuItem findMenuItem(int itemId){
        MenuItem foundItem = new MenuItem();
        for (MenuItem item : menuItems) {
            if (item.getItemId() == itemId){
                foundItem = item;
            }
        }
        return foundItem;
    }

    public void printMenu(){
        for (int i = 0; i < menuItems.size(); i++){
            System.out.println(menuItems.get(i).getName());
        }
    }

    public boolean checkItemExistence (String name){
        for (MenuItem item : menuItems) {
           
            if (name.equalsIgnoreCase(item.getName())) {
                
                return true;
            }
        }
        return false;
    }

    public boolean checkItemExistence (int itemid){
        for (MenuItem item : menuItems) {
           
            if (item.getItemId() == itemid) {
                
                return true;
            }
        }
        return false;
    }
}
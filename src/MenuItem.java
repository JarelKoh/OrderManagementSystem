import java.io.Serializable;

public class MenuItem implements Serializable {
    public enum MenuCategory { SETMEAL, BURGER, SIDES, DRINKS, DESSERT };
    private int itemId;
    private String name;
    private double price;
    private String description;
    private String category;
    private String available;

    public MenuItem(){
        itemId = 0; name = ""; price = 0; description = ""; category = ""; available = "";
    }

    public MenuItem(int itemId, String name, double price, String description, String category, String available) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.available = available;
    }

    // Getters
    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getAvailability(){
        return available;
    }

    // Setters
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAvailability(String available) {
        this.available = available;
    }

    public String toString() {
        String str = String.format("MenuItem {itemId: %d, name: %s, price: %.2f, description: %s, category: %s, availability: %s", itemId, name, price, description, category, available);
        return str;
    }
}


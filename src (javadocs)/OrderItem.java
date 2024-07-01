import java.util.Scanner;

/**
 * Represents an item within an order, extending {@code MenuItem} with additional features like quantity
 * and customisation options. This class is used to handle the specifics of each item in an order,
 * such as how many are ordered and any special instructions associated with them.
 */
public class OrderItem extends MenuItem{
    /**
     * The quantity of the item ordered.
     */
    private int quantity = 0;
    /**
     * Customisation details for the item, if any.
     */
    private String customisation = "";
    /**
     * Constructs a new {@code OrderItem} with specified details and initial quantity.
     *
     * @param itemId The item's unique identifier.
     * @param available Indicates if the item is available.
     * @param category The category of the item.
     * @param price The price of the item.
     * @param name The name of the item.
     * @param description A description of the item.
     * @param quantity The quantity of this item being ordered.
     */
    public OrderItem(int itemId, String available, String category, double price, String name, String description, int quantity) {
        super(itemId, name, price, description, category, available);
        this.quantity = quantity;
    }
    
    //getters and setters
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCustomisation() {
        return customisation;
    }

    public void setCustomisation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you wish to customise your order? Press any integer for no customisation, or type your customisation:");
        
        if (scanner.hasNextInt()) {
            scanner.nextInt(); // Consume the integer input
            System.out.println("No customisation added.");
        } else {
            String customisation = scanner.nextLine();
            this.customisation = customisation;
            System.out.println("Customisation added: " + customisation);
        }
    }
}
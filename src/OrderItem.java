import java.util.Scanner;

public class OrderItem extends MenuItem{
    private int quantity = 0;
    private String customisation = "";

    //constructor
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
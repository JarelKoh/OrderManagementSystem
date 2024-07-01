import java.io.*;
import java.util.*;

/**
 * The {@code PaymentManager} class manages payment methods and provides functionality
 * to display available payment options and retrieve payment types by ID.
 */
public class PaymentManager {
    private Map<Integer, PaymentList.PaymentType> paymentMethods = new HashMap<>();

    /**
     * Constructs a new {@code PaymentManager} instance and loads the payment methods
     * from the "PaymentList.txt" file.
     */
    public PaymentManager() {
        loadPaymentMethods();
    }

    /**
     * Loads the payment methods from the "PaymentList.txt" file and populates the
     * {@code paymentMethods} map.
     */
    private void loadPaymentMethods() {
        try (BufferedReader reader = new BufferedReader(new FileReader("PaymentList.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                PaymentList.PaymentType paymentType = PaymentList.PaymentType.valueOf(parts[1].trim().toUpperCase());
                paymentMethods.put(id, paymentType);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays the available payment options by printing the ID and name of each payment type.
     */
    public void displayPaymentOptions() {
        System.out.println("Please choose a payment method:");
        paymentMethods.forEach((id, type) -> System.out.println(id + ". " + type));
    }

    /**
     * Retrieves the payment type associated with the given ID.
     *
     * @param id The ID of the payment type to retrieve.
     * @return The {@code PaymentType} associated with the given ID, or {@code null} if not found.
     */
    public PaymentList.PaymentType getPaymentTypeById(int id) {
        return paymentMethods.get(id);
    }
}

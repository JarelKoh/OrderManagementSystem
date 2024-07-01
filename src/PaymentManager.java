import java.io.*;
import java.util.*;

public class PaymentManager {
    private Map<Integer, PaymentList.PaymentType> paymentMethods = new HashMap<>();

    public PaymentManager() {
        loadPaymentMethods();
    }

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

    public void displayPaymentOptions() {
        System.out.println("Please choose a payment method:");
        paymentMethods.forEach((id, type) -> System.out.println(id + ". " + type));
    }

    public PaymentList.PaymentType getPaymentTypeById(int id) {
        return paymentMethods.get(id);
    }
}

import java.util.Scanner;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.NoSuchMethodException;
import java.lang.InstantiationException;
import java.lang.IllegalAccessException;
import java.lang.ClassNotFoundException;

public class CustomerPaymentView {
    private PaymentManager paymentManager;

    public CustomerPaymentView() {
        this.paymentManager = new PaymentManager();
    }

    public void showPaymentOptions() {
        paymentManager.displayPaymentOptions(); // Display the list of payments
        System.out.println("Enter the number corresponding to your payment choice:");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        try {
            PaymentList.PaymentType selectedType = paymentManager.getPaymentTypeById(choice);
            makePayment(selectedType);
        } catch (Exception e) {
            System.out.println("Invalid choice. Please try again.");
        } 
    }

    private void makePayment(PaymentList.PaymentType paymentType) {
        try {
            
            String className = convertEnumToString(paymentType);
            Class<?> cls = Class.forName(className);
            Object paymentInstance = cls.getDeclaredConstructor().newInstance();
    
            // Invoke the finalPayment method
            Method finalPaymentMethod = cls.getMethod("finalPayment");
            Boolean result = (Boolean) finalPaymentMethod.invoke(paymentInstance);
    
            // Output the result
            if (result) {
                System.out.println(paymentType + " payment processed successfully.");
            } else {
                System.out.println(paymentType + " payment failed.");
            }
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            System.out.println("Error processing payment type: " + paymentType);
            e.printStackTrace();
        }
    }
    
    private String convertEnumToString(PaymentList.PaymentType paymentType) {
        // Here we just capitalize the first letter as no package name is needed.
        return paymentType.toString().substring(0, 1).toUpperCase() + paymentType.toString().substring(1).toLowerCase();
    }
}

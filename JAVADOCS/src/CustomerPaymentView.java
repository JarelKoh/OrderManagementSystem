import java.util.Scanner;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.NoSuchMethodException;
import java.lang.InstantiationException;
import java.lang.IllegalAccessException;
import java.lang.ClassNotFoundException;
/**
 * The CustomerPaymentView class provides a user interface for customers to select and process
 * different payment methods.
 */
public class CustomerPaymentView {
    private PaymentManager paymentManager;
    /**
     * Constructs a new CustomerPaymentView object and initializes the PaymentManager.
     */
    public CustomerPaymentView() {
        this.paymentManager = new PaymentManager();
    }
    /**
     * Displays the available payment options to the user, prompts for a choice, and processes
     * the selected payment method.
     */
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
    /**
     * Processes the selected payment method by creating an instance of the corresponding payment class,
     * invoking the finalPayment method, and displaying the result.
     *
     * @param paymentType the selected payment type
     */
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
    /**
     * Converts the PaymentType enum to a string representation suitable for class names.
     *
     * @param paymentType the PaymentType enum value
     * @return the string representation of the PaymentType
     */
    private String convertEnumToString(PaymentList.PaymentType paymentType) {
        // Here we just capitalize the first letter as no package name is needed.
        return paymentType.toString().substring(0, 1).toUpperCase() + paymentType.toString().substring(1).toLowerCase();
    }
}

import java.io.IOException;
import java.util.Scanner;
/**
 * This class handles the addition of new payment types to a payment list from user input.
 */
public class AddPayment implements NonPermutableNull{
    /**
     * Constructs an AddPayment instance.
     */
    public AddPayment(){}
    /**
     * Prompts the user to enter details for a new payment type and attempts to add it to the payment list.
     * It supports three types of payment: CREDIT, ONLINE, and ALIPAY.
     * Errors are handled for invalid input and file I/O issues.
     */
    public void request() {
        int id;
        String type;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter Item ID:");
        id = in.nextInt();
        System.out.println("Enter Payment Type Name (CREDIT, ONLINE, ALIPAY):");
        type = in.next();

        try {
            PaymentList.PaymentType paymentType = PaymentList.PaymentType.valueOf(type.toUpperCase());
            Payment payment = new Payment(PaymentDB.readPaymentItem("PaymentList.txt"));
            payment.addPaymentItem(new PaymentList(id, paymentType));
            PaymentDB.savePaymentItem("PaymentList.txt", payment.getPaymentItems());
            System.out.println("Payment type added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Invalid payment type entered. Please use CREDIT, ONLINE, or ALIPAY.");
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        } finally {
            //in.close(); // Close scanner to avoid resource leak
        }
    }
}
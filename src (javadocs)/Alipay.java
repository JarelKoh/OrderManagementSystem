import java.util.Scanner;
/**
 * The {@code Alipay} class represents an implementation of the {@code PaymentMethod} interface,
 * specifically catering to payments via Alipay. It provides a method for finalizing payments
 * by scanning a QR code.
 */
public class Alipay implements PaymentMethod {
    /**
     * A {@code Scanner} object for reading input from the console.
     */
    Scanner scanAli = new Scanner(System.in);
    /**
     * Stores the user's input to simulate the action of scanning a QR code.
     */
    int number;
    /**
     * Simulates the final payment process for Alipay by asking the user to scan a QR code.
     * The user must input '1' to simulate scanning the QR code.
     *
     * @return Always returns {@code true} to indicate the simulation of the payment process.
     */
	public boolean finalPayment() {
        System.out.println("Scan QR code, enter 1 to scan: ");
        number = scanAli.nextInt();
		return true;
	}
    
}

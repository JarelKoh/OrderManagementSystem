import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * The {@code Online} class implements the {@code PaymentMethod} interface to provide 
 * an online payment method via QR code scanning. This class utilizes a {@link Scanner} 
 * to accept user input to simulate the scanning process.
 */
public class Online implements PaymentMethod {
    /**
     * Scanner to read user input for simulating the online payment process.
     */
    Scanner scanOn = new Scanner(System.in);
    /**
     * Stores the last number entered by the user during the payment process.
     */
    int number;
     /**
     * Processes the final payment by requiring the user to simulate scanning a QR code 
     * through entering an integer. This method ensures that the payment can only proceed 
     * with valid integer input, handling incorrect inputs gracefully by prompting the user 
     * until a valid integer is entered.
     *
     * @return always returns {@code true} indicating that the payment has been successfully made.
     */
	public boolean finalPayment() {
        while (true){

            System.out.println("Scan QR code, enter any integer to scan: ");
            try{
                number = scanOn.nextInt();
                break;
            } catch (InputMismatchException e){
                    System.out.println("Invalid input. Please enter a number.");
                    scanOn.nextLine();
            }
        }
		return true;
	}

}
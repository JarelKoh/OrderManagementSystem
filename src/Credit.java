import java.util.Scanner;
import java.util.InputMismatchException;
public class Credit implements PaymentMethod {
	
    Scanner scanCredit = new Scanner(System.in);
    String cardNum;
    int exp;
    int cvc;

    public boolean finalPayment() {
		// TODO - implement CreditorDebit.PaymentGate
		System.out.println("Enter card number: ");
        cardNum = scanCredit.nextLine();

        while (true) {
            try {
                System.out.println("Enter expiry date: ");
                exp = scanCredit.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanCredit.nextLine();
            }
        }
		
        while (true) {
            try {
                System.out.println("Enter CVC: ");
                cvc = scanCredit.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanCredit.nextLine();
            }
        }

        return true;
	}
}
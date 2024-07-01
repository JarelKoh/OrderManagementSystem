import java.util.Scanner;
import java.util.InputMismatchException;

public class Online implements PaymentMethod {

    Scanner scanOn = new Scanner(System.in);
    int number;

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
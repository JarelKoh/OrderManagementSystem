import java.util.Scanner;

public class Alipay implements PaymentMethod {
    Scanner scanAli = new Scanner(System.in);
    int number;

	public boolean finalPayment() {
        System.out.println("Scan QR code, enter 1 to scan: ");
        number = scanAli.nextInt();
		return true;
	}
    
}

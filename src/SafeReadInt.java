import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeReadInt {
    public SafeReadInt(){}
    public static int request(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int input = sc.nextInt();
                sc.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
            }
        }
    }
}

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * The {@code SafeReadInt} class provides a utility method to safely read an integer input from the console.
 * It ensures that input errors due to non-integer inputs are handled gracefully by continuously prompting
 * the user until a valid integer is entered.
 */
public class SafeReadInt {
    /**
     * Constructs a new {@code SafeReadInt} instance. This constructor is not necessary for utility classes
     * that are meant to be used statically, but it is included to allow instantiation if required.
     */
    public SafeReadInt(){}
     /**
     * Reads an integer from the console input safely. If a non-integer is entered, it will prompt the user
     * again until a valid integer is provided. This method uses a {@link Scanner} object to read from the console.
     *
     * @return The integer input by the user.
     */
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

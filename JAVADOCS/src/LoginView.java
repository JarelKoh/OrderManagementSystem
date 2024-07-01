import java.util.Scanner;
/**
 * This class represents the view for the login process in an application.
 * iSx responsible for interacting with the user to gather login credentials and initiate the authentication process.
 */
public class LoginView {
    private Branch b;
    
    /**
     * Constructs a new instance of LoginView.
     * This constructor takes a Branch object to maintain the branch-specific data throughout the login process.
     * @param b the branch object associated with this login view
     */
    public LoginView(Branch b){
        this.b = b;
    }
     /**
     * Handles the user login process.
     * This method prompts the user to enter a userID and password, then attempts to authenticate these credentials.
     * If authentication fails, the user is repeatedly prompted until they either succeed or cancel the login process.
     * @param controller the UserController that manages the user authentication
     * @return User the authenticated user object or null if the user cancels the login attempt
     */
    public User operate(UserController controller){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input userID");
        String name = sc.nextLine();
        System.out.println("input password");
        String password = sc.nextLine();
        password = PasswordHide.encrypt(password);
        User result = controller.authenticate(name, password, b);
        while(result == null){
            System.out.println("""
                    Incorrect name and password.
                    Please try again (input 1 to cancel)
                    """);
            System.out.println("Input userID");
            name = sc.nextLine();
            if(name.equals("1")) return null;
            System.out.println("input password");
            password = sc.nextLine();
            password = PasswordHide.encrypt(password);
            result = controller.authenticate(name, password, b);
        }
        if(result != null){
            if(result.checkchanged() == false){
                PasswordChange.request(result);
            }
        }
        return result;
    }
}
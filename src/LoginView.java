import java.util.Scanner;
public class LoginView {
    private Branch b;
    
    public LoginView(Branch b){
        this.b = b;
    }
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
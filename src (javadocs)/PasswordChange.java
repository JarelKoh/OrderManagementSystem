/**
 * This class facilitates changing the user's password in the context of a Branch Application.
 */

import java.util.Scanner;

public class PasswordChange {
    /**
     * Constructs a new PasswordChange instance.
     */
    public PasswordChange(){};

    /**
     * Requests a new password from the user and updates it if it is not the same as the old password.
     * The user's password changed status is set to true and the corresponding branch information is updated.
     *
     * @param u the User object whose password is to be changed
     */
    public static void request(User u){
        Scanner sc = new Scanner(System.in);
        BranchApp bapp = new BranchApp();
        System.out.println("Enter new Password");
        String newpassword = PasswordHide.encrypt(sc.nextLine());
        while(newpassword.equals(u.getPassword())){
            System.out.println("The new password is the same as the old password");
            System.out.println("Enter new Password");
            newpassword = PasswordHide.encrypt(sc.nextLine());
        }
        u.setPassword(newpassword);
        u.setPasswordChanged(true);
        Branch b = u.getBranch();
        b.setUser(u);
        bapp.setBranch(b);
        System.out.println("Password Changed");
    }
}
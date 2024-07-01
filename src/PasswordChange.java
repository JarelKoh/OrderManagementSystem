import java.util.Scanner;

public class PasswordChange {
    public PasswordChange(){};
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
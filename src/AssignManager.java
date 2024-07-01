import java.util.ArrayList;
import java.util.Scanner;
public class AssignManager extends Permutable{
    public AssignManager(){}
    public void request(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Branch> branchlist = super.getBranchlList();
        int i;
        System.out.println("Enter Branch");
        String newbranch = sc.nextLine();
        Branch b = null;
        for (i=0; i<branchlist.size(); i++) {
            if (branchlist.get(i).getBranchname().equals(newbranch)){
                b = branchlist.get(i);
                if(b.quotaChecker() == false) return;
                break;
            }else if(i == branchlist.size() - 1){
                System.out.println("Branch not found");
                return;
            }
        }
        System.out.println("Enter username");
        String newusername = sc.nextLine();
        System.out.println("Enter gender");
        String gender = sc.nextLine();
        String userID = b.useridvalidate();
        System.out.println("enter age");
        int age = sc.nextInt();
        User newuser = new User(newusername,PasswordHide.encrypt("Password"),b,"Manager",gender,age,userID);
        b.addUser(newuser);
        System.out.println("Manager Assigned");
        super.setBranch(b);
    }
}
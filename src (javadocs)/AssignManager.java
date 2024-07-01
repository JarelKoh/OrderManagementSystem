import java.util.ArrayList;
import java.util.Scanner;
/**
 * The {@code AssignManager} class handles the assignment of a manager to a specific branch.
 * It extends the {@code Permutable} class, inheriting its methods and properties.
 * This class provides functionality to request and assign a manager to a branch after performing necessary checks.
 */
public class AssignManager extends Permutable{
    /**
     * Constructs a new {@code AssignManager} instance.
     */
    public AssignManager(){}
    /**
     * Requests and assigns a manager to a branch. This method prompts the user for input to identify the branch,
     * checks if the branch exists and has quota, then creates and assigns a new manager.
     * If the branch does not exist or the quota is full, the process is terminated.
     *
     * The process involves the following steps:
     * 1. User inputs the branch name.
     * 2. Validates the existence of the branch and checks the quota.
     * 3. User inputs the manager's username, gender, and age.
     * 4. A new {@code User} object is created and assigned as manager to the branch.
     * 5. The branch is updated in the superclass with the new manager added.
     *
     * Outputs to the console include prompts for user input and messages indicating process results like errors or success.
     */
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
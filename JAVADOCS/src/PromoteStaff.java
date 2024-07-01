import java.util.ArrayList;
import java.util.Scanner;
/**
 * The {@code PromoteStaff} class extends the {@code Permutable} class
 * and provides functionality to promote staff members to the manager role
 * in a specific branch.
 */
public class PromoteStaff extends Permutable{
    /**
     * Constructs a new instance of the {@code PromoteStaff} class.
     */
    public PromoteStaff(){};

    /**
     * Requests the promotion of a staff member to the manager role in a specific branch.
     * The user is prompted to enter the branch name and the user ID of the staff member
     * to be promoted. If the branch and user are found, and the promotion quota is not
     * exceeded, the staff member's role is updated to "Manager".
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
                if(b.promotionquotaChecker() == false) return;
                break;
            }else if(i == branchlist.size() - 1){
                System.out.println("Branch not found");
                return;
            }
        }
        System.out.println("Enter userID to be promoted");
        String u = sc.nextLine();
        for(int t = 0;t<branchlist.get(i).getUserlist().size();t++){
            if(b.getUserlist().get(t).getUserID().equals(u)){
                User promoted = b.getUserlist().get(t);
                promoted.setRole("Manager");
                b.setUser(promoted);
                super.setBranch(b);
                System.out.println("User Promoted");
                break;
            }else if(t == branchlist.get(i).getUserlist().size() - 1){
                System.out.println("User not found");
            }
        }
    }
}
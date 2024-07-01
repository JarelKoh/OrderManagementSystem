import java.util.ArrayList;
import java.util.Scanner;

/**
 * The {@code TransferManager} class extends the {@code Permutable} class and provides
 * functionality to transfer users between branches.
 */
public class TransferManager extends Permutable{
    /**
     * Constructs a new instance of the {@code TransferManager} class.
     */
    public TransferManager(){};

    /**
     * Requests the transfer of a user from one branch to another.
     * The user is prompted to enter the current branch of the user, the user ID,
     * and the new branch to transfer the user to. If the user is a manager,
     * the quota of the new branch is checked before the transfer.
     */
    public void request(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Branch> branchlist = super.getBranchlList();
        int i;
        int j;
        System.out.println("Enter Current Branch of User");
        String curbranch = sc.nextLine();
        Branch oldbranch = null;
        for (i=0; i<branchlist.size(); i++) {
            if (branchlist.get(i).getBranchname().equals(curbranch)){
                oldbranch = branchlist.get(i);
                break;
            }else if(i == branchlist.size() - 1){
                System.out.println("Branch not found");
                return;
            }
        }
        System.out.println("Enter userID to be transferred");
        String u = sc.nextLine();
        User current;
        for(j = 0;j<branchlist.get(i).getUserlist().size();j++){
            if(oldbranch.getUserlist().get(j).getUserID().equals(u)){
                current = oldbranch.getUserlist().get(j);
                System.out.println("Enter new Branch");
                String newbranch = sc.nextLine();
                Branch newBranch = null;
                for (int t =0; t<branchlist.size(); t++) {
                    if (branchlist.get(t).getBranchname().equals(newbranch)){
                        newBranch = branchlist.get(t);
                        if(current.getRole().equals("Manager")){
                            if(newBranch.quotaChecker() == false) return; 
                        }
                        oldbranch.removeUser(current);
                        setBranch(oldbranch);
                        current.setBranch(newBranch);
                        newBranch.getUserlist().add(current);
                        setBranch(newBranch);
                        System.out.println("User Transferred");
                        break;
                    }else if(t == branchlist.size() - 1){
                        System.out.println("Branch not found");
                        return;
                    }
                }
                break;
            }else if(j == branchlist.get(i).getUserlist().size() - 1){
                System.out.println("User not found");
                return;
            }
        }
        super.saveBranch(branchlist);
    }
}
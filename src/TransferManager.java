import java.util.ArrayList;
import java.util.Scanner;
public class TransferManager extends Permutable{
    public TransferManager(){};
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
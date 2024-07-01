import java.util.ArrayList;
import java.util.Scanner;

public class PromoteStaff extends Permutable{
    public PromoteStaff(){};
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
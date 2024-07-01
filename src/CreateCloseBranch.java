import java.util.ArrayList;
import java.util.Scanner;
public class CreateCloseBranch extends Permutable{
    public CreateCloseBranch(){};
    public void request(){
        Scanner sc = new Scanner(System.in);
        String choice = "h";
        while(!(choice.equals("1") || choice.equals("2"))){
            System.out.println("""
                Input Choice:
                1. Open a new branch
                2. Close a branch
                """);
            choice = sc.nextLine();
        }

        ArrayList<Branch> branchlist = super.getBranchlList();
        if(choice.equals("1")){
            System.out.println("Input name of new Branch");
            String branchname = sc.nextLine();
            for (int i=0; i<branchlist.size(); i++) {
                if (branchlist.get(i).getBranchname().equals(branchname)){
                    System.out.println("Branch already exists");
                    return;
                }
            }
            Branch b = new Branch(branchname);
            branchlist.add(b);
            System.out.println("Branch added");
        }else if(choice.equals("2")){
            System.out.println("Input Branch to be deleted");
            String deletedbranch = sc.nextLine();
            for (int i=0; i<branchlist.size(); i++) {
                if (branchlist.get(i).getBranchname().equals(deletedbranch)){
                    branchlist.remove(i);
                    System.out.println("Branch is removed");
                    break;
                }else if(i == branchlist.size()-1){
                    System.out.println("Branch does not exist");
                }
            }
        }
        BranchApp.saveBranch(branchlist);
    }
}
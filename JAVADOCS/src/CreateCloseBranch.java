import java.util.ArrayList;
import java.util.Scanner;
/**
 * The CreateCloseBranch class extends the Permutable class and provides
 * functionality for creating a new branch or closing an existing branch.
 */
public class CreateCloseBranch extends Permutable{
    /**
     * Constructs a new CreateCloseBranch object.
     */
    public CreateCloseBranch(){};
    /**
     * Prompts the user to choose between creating a new branch or closing an existing branch.
     * If creating a new branch, it checks if the branch name already exists and adds the new branch if it doesn't.
     * If closing a branch, it prompts the user for the branch name and removes the corresponding branch if it exists.
     * After the operation, it saves the updated branch list.
     */
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
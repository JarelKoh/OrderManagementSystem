import java.util.ArrayList;
import java.io.IOException;

public class InitialiseApp {
    public InitialiseApp(){}
    public static void execute(){
        try{
            ArrayList<Branch> branchlist = new ArrayList<>();
            Branch HQ = new Branch("HQ");
            User boss = new User("boss", PasswordHide.encrypt("Password"), HQ, "Admin", "M", 58,"boss");
            HQ.getUserlist().add(boss);
            branchlist.add(HQ);
            branchlist = TextDB.readUsers("User.txt", branchlist);
            Menu menu = MenuDB.readMenu("MenuItems.txt");
            for (Branch br: branchlist){
                br.setMenu(menu);
            }
            BranchApp.saveBranch(branchlist);
        } catch (IOException e){
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}

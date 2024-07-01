import java.util.ArrayList;
import java.io.IOException;

/**
 * The {@code InitialiseApp} class handles the initialization of the application.
 * It sets up the initial state including creating branches, default users, and loading data
 * from files into the application's memory.
 */
public class InitialiseApp {
    /**
     * Constructs a new {@code InitialiseApp} object.
     * This constructor currently does not perform any specific operations.
     */
    public InitialiseApp(){}
     /**
     * Executes the application initialization process. It creates a list of branches,
     * adds a default admin user, loads users from a text file, and sets up the menu
     * for each branch from another text file.
     * The method handles IOExceptions that might occur during file operations, and logs
     * an appropriate message if an error occurs.
     *
     * @throws IOException If there is an issue with reading data from the files.
     */

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

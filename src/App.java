import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception{
        while (true) {
            try{
                BranchApp bapp = new BranchApp();
                ArrayList<Branch> branchlist = bapp.getBranchlList();
                int index=0, t=0;
                Scanner sc = new Scanner(System.in);
                int choice;
                for(t = 1;t<branchlist.size();t++){
                    System.out.println(t + ". " + branchlist.get(t).getBranchname());
                }
                System.out.println("Choose Branch: (Enter -1 to Quit)");
                index = sc.nextInt();
                sc.nextLine();
                if (index == -1) {
                    System.out.println("SYSTEM CLOSED!!");
                    System.exit(1);
                }
                Branch b = branchlist.get(index);
        
                do {
                    bapp = new BranchApp();
                    branchlist = bapp.getBranchlList();
                    
                    int flag = 0;
                    for (t=0; t<bapp.getBranchlList().size(); t++) {
                        if (bapp.getBranchlList().get(t).getBranchname().equals(b.getBranchname())){
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 1){
                        b = branchlist.get(t);
                    }
        
                    LoginView login = new LoginView(b);
                    UserInterface exectuable = new UserInterface();
                    User user;
                    System.out.println("""
                            Input user type:
                            1. Customer
                            2. Staff
                            3. Manager
                            4. Admin
                            5. Quit
                            """);
        
                    choice = sc.nextInt();
                    switch(choice){
                        case 1:
                            CustomerView customerview = new CustomerView(b);
                            exectuable.execute(customerview);
                            break;
                        case 2:
                            Staff_Controller staff = new Staff_Controller();
                            user = login.operate(staff);
                            if(user == null) continue;
                            StaffView staffview = new StaffView(b);
                            exectuable.execute(staffview);
                            break;
                        case 3:
                            ManagerController manager = new ManagerController();
                            user = login.operate(manager);
                            if(user == null) continue;
                            ManagerView managerview = new ManagerView(b);
                            exectuable.execute(managerview);
                            break;
                        case 4:
                            AdminController admin = new AdminController();
                            user = login.operate(admin);
                            if(user == null) continue;
                            AdminView adminview = new AdminView(b);
                            exectuable.execute(adminview);
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Invalid input!");
                    }
                } while (choice != 5);
            } catch (NullPointerException npe){
                Scanner in = new Scanner(System.in);
                int dec = in.nextInt();

                if (dec == 1){
                    InitialiseApp.execute();
                } else{
                    System.exit(1);
                }
            } catch (Exception e){
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        } 
    }
}
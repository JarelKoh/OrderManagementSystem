import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
public class ADisplayStaff implements NonPermutableNull{
    public ADisplayStaff (){};
    public void request(){
        Scanner sc = new Scanner(System.in);
        BranchApp bapp = new BranchApp();
        ArrayList<Branch> branchlist= bapp.getBranchlList();
        ArrayList<User> userlist = new ArrayList<>();
        for(int t=0;t<branchlist.size();t++){
            userlist.addAll(branchlist.get(t).getUserlist());
        }
        int choice;
        choice = -1;
        boolean valid = false;
        while (!valid  || choice>5 || choice<1) {
            try {
                System.out.println("""
                    Input filter:
                    1. age
                    2. gender
                    3. role
                    4. branch
                    5. Print All
                    """);
                choice = sc.nextInt(); 
                valid = true; 
            } catch (InputMismatchException ime) {
                System.out.println("""
                    Input filter:
                    1. age
                    2. gender
                    3. role
                    4. branch
                    """);
                sc.next();  
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());

            }
        }
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Input lower range");
                int lrange = sc.nextInt();
                System.out.println("Input upper range");
                int urange = sc.nextInt();
                for(int t = 0;t<userlist.size();t++){
                    if((userlist.get(t).getAge() >= lrange) && (userlist.get(t).getAge() <= urange)){
                        System.out.println("UserID: " + userlist.get(t).getUserID());
                        System.out.println("Username: " + userlist.get(t).getUsername());
                        System.out.println("Age: " + userlist.get(t).getAge());
                        System.out.println("Gender: " + userlist.get(t).getGender());
                        if(userlist.get(t).getBranch().equals("HQ")){   
                        }else System.out.println("Branch: " +userlist.get(t).getBranch().getBranchname());
                        System.out.println("Role: " +userlist.get(t).getRole());
                        System.out.println("");
                    }
                }
                break;
            case 2:
                System.out.println("Input Gender filter(M/F):");
                String genderfilter = sc.nextLine();
                for(int t = 0;t<userlist.size();t++){
                    if((userlist.get(t).getGender().equals(genderfilter))){
                        System.out.println("UserID: " + userlist.get(t).getUserID());
                        System.out.println("Username: " + userlist.get(t).getUsername());
                        System.out.println("Age: " + userlist.get(t).getAge());
                        System.out.println("Gender: " + userlist.get(t).getGender());
                        if(userlist.get(t).getBranch().equals("HQ")){   
                        }else System.out.println("Branch: " +userlist.get(t).getBranch().getBranchname());
                        System.out.println("Role: " +userlist.get(t).getRole());
                        System.out.println("");
                    }
                }
                break;
            case 3:
                System.out.println("Enter role to filter (Admin/Manager/Staff)");
                String rolefilter = sc.nextLine();
                for(int t = 0;t<userlist.size();t++){
                    if((userlist.get(t).getRole().equals(rolefilter))){
                        System.out.println("UserID: " + userlist.get(t).getUserID());
                        System.out.println("Username: " + userlist.get(t).getUsername());
                        System.out.println("Age: " + userlist.get(t).getAge());
                        System.out.println("Gender: " + userlist.get(t).getGender());
                        if(userlist.get(t).getBranch().equals("HQ")){   
                        }else System.out.println("Branch: " +userlist.get(t).getBranch().getBranchname());
                        System.out.println("Role: " +userlist.get(t).getRole());
                        System.out.println("");
                    }
                }
                break;
            case 4:
                for(int t = 1;t<branchlist.size();t++){
                    System.out.println(t + "." + branchlist.get(t).getBranchname());
                }
                System.out.println("Input number");
                int index = sc.nextInt();
                Branch bb = branchlist.get(index);
                for(int t = 0;t<bb.getUserlist().size();t++){
                        System.out.println("UserID: " + bb.getUserlist().get(t).getUserID());
                        System.out.println("Username: " + bb.getUserlist().get(t).getUsername());
                        System.out.println("Age: " + bb.getUserlist().get(t).getAge());
                        System.out.println("Gender: " + bb.getUserlist().get(t).getGender());
                        System.out.println("Branch: " +bb.getUserlist().get(t).getBranch().getBranchname());
                        System.out.println("Role: " +bb.getUserlist().get(t).getRole());
                        System.out.println("");
                }
                break;
            case 5:
                for(int t = 0;t<userlist.size();t++){
                        System.out.println("UserID: " + userlist.get(t).getUserID());
                        System.out.println("Username: " + userlist.get(t).getUsername());
                        System.out.println("Age: " + userlist.get(t).getAge());
                        System.out.println("Gender: " + userlist.get(t).getGender());
                        if(userlist.get(t).getBranch().equals("HQ")){   
                        }else System.out.println("Branch: " +userlist.get(t).getBranch().getBranchname());
                        System.out.println("Role: " +userlist.get(t).getRole());
                        System.out.println("");
                }
                break;
            default:
                break;
        }
    }
}

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * This class is designed to display staff information based on various filters such as age, gender, role, or displaying all.
 * It interfaces with a Branch object to retrieve and manipulate user data.
 */
public class MDisplayStaff implements NonPermutableBranch{
     /**
     * Constructor for MDisplayStaff.
     */
    public MDisplayStaff(){};
        /**
     * Requests and processes user input to filter and display staff information.
     * The method provides a menu for the user to choose the type of filter they want to apply:
     * 1. Age range
     * 2. Gender
     * 3. Role
     * 4. Display all staff members
     * After selecting a filter, it prompts the user for additional specifics (like exact age range, gender, or role) and displays matching staff details.
     * @param b the branch from which the staff information is retrieved and displayed
     */
    public void request(Branch b){
        Scanner sc = new Scanner(System.in);
        ArrayList<User> userlist= b.getUserlist();
        int choice;
        choice = -1;
        boolean valid = false;
        while (!valid  || (choice>4 || choice<1)) {
            try {
                System.out.println("""
                    Input filter:
                    1. age
                    2. gender
                    3. role
                    4. print all
                    """);
                choice = sc.nextInt(); 
                valid = true; 
            } catch (InputMismatchException ime) {
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
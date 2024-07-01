import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
public class EditStaff extends Permutable{
    public EditStaff(){};
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
                break;
            }else if(i == branchlist.size() - 1){
                System.out.println("Branch not found");
                return;
            }
        }
        System.out.println("""
                1. Add Staff Account
                2. Edit Staff Account
                """);     
        int choice;
        choice = -1;
        boolean valid = false;
        while (!valid || choice>2 || choice<=0) {
            try {
                choice = sc.nextInt(); 
                valid = true; 
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input. Please enter an integer.");
                sc.next();  
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());

            }
        }
        if (choice == 1){
        sc.nextLine();
        System.out.println("Enter username");
        String newusername = sc.nextLine();
        System.out.println("Enter gender");
        String gender = sc.nextLine();
        String userID = branchlist.get(i).useridvalidate();
        System.out.println("enter age");
        int age = sc.nextInt();
        User newuser = new User(newusername,PasswordHide.encrypt("Password"),b,"Staff",gender,age,userID);
        b.addUser(newuser);
        super.setBranch(b);
        System.out.println("User added");
        }else{
            System.out.println("Enter UserID");
            sc.nextLine();
            String u = sc.nextLine();
            for(int t = 0;t<b.getUserlist().size();t++){
                if(b.getUserlist().get(t).getUserID().equals(u)){
                    User editeduser = b.getUserlist().get(t);
                    b.removeUser(editeduser);
                    System.out.println("""
                            Input attribute to be changed:
                            1. Username
                            2. UserID
                            3. Age
                            4. Gender
                            """);
                    choice = sc.nextInt();
                    String n;
                    sc.nextLine();
                    switch (choice) {
                        case 1:
                        System.out.println("Input new Username");
                        n = sc.nextLine();
                        editeduser.setUsername(n);
                        break;
                        case 2:
                        n = b.useridvalidate();
                        editeduser.setUserID(n);
                        break;
                        case 3:
                        System.out.println("Input new Age");
                        int age = sc.nextInt();
                        editeduser.setAge(age);
                        break;
                        case 4:
                        System.out.println("Input new Gender");
                        n = sc.nextLine();
                        editeduser.setGender(n);
                        break;  
                    
                        default:
                            break;
                    }
                    b.addUser(editeduser);
                    setBranch(b);
                    System.out.println("User edited");
                    break;
                }else if(t == branchlist.get(i).getUserlist().size() - 1){
                    System.out.println("User not found");
                }
            }
        }          
    }
}
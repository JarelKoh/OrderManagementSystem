import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
public class Branch implements Serializable{
    private ArrayList<User> userlist;
    private Menu menu;
    private ArrayList<Order> orderlist;
    private String branchname;
    
    public Branch(String branchname){
        this.branchname = branchname;
        userlist = new ArrayList<>();
        orderlist = new ArrayList<>();
    }

    public String getBranchname(){
        return branchname;
    }
    public ArrayList<User> getUserlist(){
        return userlist;
    }
    public void setUserlist(ArrayList<User> userlist){
        this.userlist = userlist;
    }
    public Menu getMenu(){
        return menu;
    }
    public void setMenu(Menu new_menu){
        menu = new_menu;
    }
    public ArrayList<Order> getOrderlist(){
        return orderlist;
    }
    public void setOrderlist(ArrayList<Order> orderlist) {
        this.orderlist = orderlist;
    }

    public void setUser(User u){
        int i = this.getUserIndex(u);
        this.userlist.remove(i);
        this.userlist.add(i, u);
    }

    public int getUserIndex(User u){
        int i;

        for (i=0; i<userlist.size(); i++) {
            if (userlist.get(i).getUserID().equals(u.getUserID())){
                return i;
            }
        }
        return -1;
    }

    public void addUser(User u){
        this.userlist.add(u);
    }
    public void removeUser(User u){
        for(int t = 0;t<this.userlist.size();t++){
            if(this.userlist.get(t).getUserID().equals(u.getUserID())){
                this.userlist.remove(t);
            }
        }
    }
    
    public boolean quotaChecker(){
        int staffcount = 0;
        int managercount = 0;
        for(int t = 0;t<this.userlist.size();t++){
            if(this.userlist.get(t).getRole().equals("Staff")) staffcount++;
            if(this.userlist.get(t).getRole().equals("Manager")) managercount++;
        }
            if(staffcount <= 4 && managercount>=1){
                System.out.println("The quota for managers has been reached");
                return false;
            }else if(staffcount <= 8 && managercount>=2){
                System.out.println("The quota for managers has been reached");
                return false;
            }else if(staffcount <= 12 && managercount>=3){
                System.out.println("The quota for managers has been reached");
                return false;
            }
        return true;
    }

    public boolean promotionquotaChecker(){
        int staffcount = 0;
        int managercount = 0;
        for(int t = 0;t<this.userlist.size();t++){
            if(this.userlist.get(t).getRole().equals("Staff")) staffcount++;
            if(this.userlist.get(t).getRole().equals("Manager")) managercount++;
        }
            if(staffcount <= 5 && managercount>=1){
                System.out.println("The quota for managers has been reached");
                return false;
            }else if(staffcount <= 9 && managercount>=2){
                System.out.println("The quota for managers has been reached");
                return false;
            }else if(staffcount <= 13 && managercount>=3){
                System.out.println("The quota for managers has been reached");
                return false;
            }
        return true;
    }
    public String useridvalidate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input new UserID");
        String n = sc.nextLine();
        int checker = 0;
        if(this.userlist.size() != 0){
            while(checker == 0){
                for(int k = 0;k<this.userlist.size();k++){
                    if(this.userlist.get(k).getUserID().equals(n)){
                        System.out.println("UserID already exists. Please enter a new UserID");
                        n = sc.nextLine();
                        break;
                    }else if(k == userlist.size() - 1){
                        checker = 1;
                    }
                }
            }
        }
        return n;
    }
}
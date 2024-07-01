import java.util.ArrayList;

public class AdminController implements UserController{
    public AdminController(){}
    private User user;
    public User authenticate(String userID, String password,Branch b){
        BranchApp bapp = new BranchApp();
        ArrayList<User> userlist = bapp.getBranchlList().get(0).getUserlist();
        for(int t = 0;t<userlist.size();t++){
            if(userlist.get(t).getUserID().equals(userID)){
                user = userlist.get(t);
                break;
            }
        }
        if(user == null) return user;
        if(user.getPassword().equals(password) && user.getRole().equals("Admin")) return user;
        else return null;
    }
}
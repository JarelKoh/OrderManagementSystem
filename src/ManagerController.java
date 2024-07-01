import java.util.ArrayList;

public class ManagerController implements UserController {
    private User user;
    
    public ManagerController(){}
    public User authenticate(String userID, String password,Branch b){
        ArrayList<User> userlist = b.getUserlist();
        for(int t = 0;t<userlist.size();t++){
            if(userlist.get(t).getUserID().equals(userID)){
                user = userlist.get(t);
                break;
            }
        }
        if(user == null) return user;
        if(user.getPassword().equals(password) && user.getRole().equals("Manager")) return user;
        else return null;
    }
}
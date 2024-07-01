import java.util.ArrayList;

public class Staff_Controller implements UserController{
    public Staff_Controller(){}
    private User user;
    public User authenticate(String userID, String password,Branch b){
        ArrayList<User> userlist = b.getUserlist();
        for(int t = 0;t<userlist.size();t++){
            if(userlist.get(t).getUserID().equals(userID)){
                user = userlist.get(t);
                break;
            }
        }
        if(user == null) return user;
        if(user.getPassword().equals(password) && user.getRole().equals("Staff")) return user;
        else return null;
    }
}

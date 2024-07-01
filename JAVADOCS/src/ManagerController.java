import java.util.ArrayList;

/**
 * This class handles user management tasks. 
 * It checks user credentials and authenticates managers only.
 */ 
public class ManagerController implements UserController {
    private User user;
    
        /**
     * Default constructor.
     */
    public ManagerController(){}
    /**
     * Attempts to authenticate a user as a manager.
     * Checks if the user ID and password match a manager's credentials.
     * @param userID The user's ID.
     * @param password The user's password.
     * @param b The branch where the user is trying to authenticate.
     * @return User object if the user is a manager and credentials are correct, otherwise returns null.
     */
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
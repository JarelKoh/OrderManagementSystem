import java.util.ArrayList;
/**
 * The {@code AdminController} class is responsible for managing user authentication specifically for admin users.
 * It interacts with a {@code BranchApp} to retrieve user information and validate credentials.
 */
public class AdminController implements UserController{
     /**
     * Constructs an {@code AdminController} object.
     */
    public AdminController(){}
    /**
     * The user currently being authenticated.
     */
    private User user;
    
    /**
     * Authenticates a user as an admin based on the provided user ID and password. The authentication process
     * retrieves a list of users from the first branch of the branch list in {@code BranchApp} and checks
     * whether the given user ID exists within that list. If the user ID exists, it then checks if the password
     * and role ('Admin') match.
     *
     * @param userID The user ID of the user attempting to authenticate.
     * @param password The password provided for authentication.
     * @param b The branch where the authentication attempt is made (currently not used in the method).
     * @return Returns the authenticated {@code User} object if the credentials are valid and the user is an admin;
     *         otherwise, returns {@code null}.
     */
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
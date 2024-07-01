import java.util.ArrayList;

/**
 * The {@code Staff_Controller} class implements the {@code UserController} interface
 * to manage authentication processes specifically for staff users within a system.
 * It verifies user credentials against a list of users associated with a specific branch.
 */
public class Staff_Controller implements UserController{
    /**
     * Constructs a new {@code Staff_Controller}. This constructor initializes the controller
     * without any initial user data.
     */
    public Staff_Controller(){}
    /**
    * A reference to the currently authenticated user.
    */
    private User user;
    /**
     * Authenticates a user based on the provided user ID and password. The method checks if
     * the user exists within the given branch's user list and whether the password matches the
     * one on record. It also verifies that the user's role is "Staff".
     *
     * @param userID The user ID of the staff attempting to authenticate.
     * @param password The password provided by the user for authentication.
     * @param b The {@code Branch} containing the list of users to authenticate against.
     * @return the {@code User} object if authentication is successful and the user is a staff member;
     *         {@code null} if the user does not exist, the password does not match, or the user
     *         is not a staff member.
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
        if(user.getPassword().equals(password) && user.getRole().equals("Staff")) return user;
        else return null;
    }
}

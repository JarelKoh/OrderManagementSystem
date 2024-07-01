/**
 * The {@code UserController} interface defines methods for user authentication.
 * Implementing classes provide functionality to authenticate users based on their
 * name, password, and associated branch.
 */
public interface UserController {
    /**
     * Authenticates a user based on the provided name, password, and branch.
     *
     * @param name     the name of the user to authenticate
     * @param password the password of the user
     * @param branch   the branch associated with the user
     * @return the authenticated {@code User} object if authentication is successful, or {@code null} otherwise
     */
    public User authenticate(String name, String password, Branch branch);
}
/**
 * The {@code PermutableController} class provides methods to execute requests
 * on instances of the {@code Permutable} and {@code PermutableBranch} classes.
 */

public class PermutableController {
    /**
     * Constructs a new instance of the {@code PermutableController} class.
     */
    public PermutableController(){};
    /**
     * Executes the {@code request()} method on the provided {@code Permutable} instance.
     *
     * @param perm The {@code Permutable} instance on which to execute the request.
     */
    public void execute(Permutable perm){
        perm.request();
    }
    /**
     * Executes the {@code request(Branch)} method on the provided {@code PermutableBranch}
     * instance with the specified {@code Branch}.
     *
     * @param perm The {@code PermutableBranch} instance on which to execute the request.
     * @param b    The {@code Branch} instance to be passed as a parameter to the request method.
     */
    public void execute(PermutableBranch perm, Branch b){
        perm.request(b);
    }
}

/**
 * The {@code UserInterface} class provides a way to execute user views.
 */
public class UserInterface {
    /**
     * Constructs a new instance of the {@code UserInterface} class.
     */
    public UserInterface(){}
    
    /**
     * Executes the specified {@code UserView} by calling its {@code view()} method.
     *
     * @param view The {@code UserView} instance to be executed.
     */
    public void execute(UserView view){
        view.view();
    }
}

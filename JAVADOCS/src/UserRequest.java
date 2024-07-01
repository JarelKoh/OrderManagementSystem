/**
 * The {@code UserRequest} interface defines a method for processing user requests.
 * Implementing classes provide functionality to handle user requests and return
 * an integer value as a response.
 */

public interface UserRequest {
    /**
     * Processes a user request and returns an integer response.
     *
     * @return an integer value representing the response to the user request
     */
    public int request();
}

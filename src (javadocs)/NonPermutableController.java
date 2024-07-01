/**
 * The {@code NonPermutableController} class manages execution of requests 
 * that are non-permutable in nature. Controller is responsible for handling 
 * different types of requesters which define their own request execution logic.
 */

public class NonPermutableController {
     /**
     * Constructs a new instance of {@code NonPermutableController}.
     */
    public NonPermutableController(){}
    
    /**
     * Executes a request using the specified {@code NonPermutableNull} requester.
     * This method allows the requester to process a request without additional parameters.
     *
     * @param requester The {@code NonPermutableNull} requester that executes the request.
     */
    
    public void execute(NonPermutableNull requester){
        requester.request();
    }
     /**
     * Executes a request using the specified {@code NonPermutableBranch} requester and 
     * a {@code Branch} object as a parameter. This method allows the requester to process 
     * the request with a specific branch context.
     *
     * @param requester The {@code NonPermutableBranch} requester that executes the request.
     * @param b The {@code Branch} object that is used in the request execution.
     */
    public void execute(NonPermutableBranch requester, Branch b){
        requester.request(b);
    }
}

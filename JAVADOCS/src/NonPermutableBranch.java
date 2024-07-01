/**
 * The {@code NonPermutableBranch} interface represents a contractual obligation
 * for classes that need to handle requests to process or manage different types of {@code Branch} objects.
 * Purpose of this interface is for systems where branches of operation or execution
 * needs to be manipulated in a controlled manner.
 * Classes can define how it implements the request
 */


public interface NonPermutableBranch {
    /**
     * Processes a request involving a {@code Branch}. This method is intended to handle
     * or delegate the branch specific tasks or requests based on the implementing class's functionality.
     *
     * @param b the {@code Branch} object that needs to be processed or managed.
     *          Parameter must not be {@code null}.
     * @throws NullPointerException if the provided {@code Branch} is {@code null}.
     * @throws IllegalStateException if the request cannot be processed due to system or branch state.
     */
    public void request(Branch b);

}

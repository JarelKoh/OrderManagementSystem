/**
 * The {@code NonPermutableNull} interface defines a standard method for executing requests
 * without requiring additional parameters. This interface is intended for implementations
 * that handle simple, parameter-less requests.
 */

public interface NonPermutableNull {
    /**
     * Executes a request. This method should be implemented to define specific
     * request handling behavior without any parameters.
     */
    public void request();
}

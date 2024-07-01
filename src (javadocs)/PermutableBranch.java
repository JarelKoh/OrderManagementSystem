/**
 * The {@code PermutableBranch} class is an abstract class that extends {@code BranchApp} and
 * provides a method for requesting permutations of a branch.
 * <p>
 * Subclasses of {@code PermutableBranch} must implement the {@code request} method, which
 * takes a {@code Branch} object as a parameter and defines the behaviour for requesting permutations
 * of the given branch.
 */
public abstract class PermutableBranch extends BranchApp {
	/**
	 * request class
	 */
    public abstract void request(Branch b);
}

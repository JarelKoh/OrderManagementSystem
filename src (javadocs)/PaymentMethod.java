/**
 * The {@code PaymentMethod} interface defines a contract for payment methods.
 * Classes implementing this interface must provide an implementation for the
 * {@code finalPayment()} method.
 */

public interface PaymentMethod {
	public boolean finalPayment();
}
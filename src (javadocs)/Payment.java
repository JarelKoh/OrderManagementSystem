import java.util.ArrayList;
import java.util.Optional;

/**
 * The {@code Payment} class manages a list of payment items, allowing for the addition,
 * retrieval, and searching of payment details within the list.
 */
public class Payment {
    private ArrayList<PaymentList> paymentItems;

    /**
     * Constructs an empty {@code Payment} object with an empty list of payment items.
     */
    public Payment() {
        this.paymentItems = new ArrayList<>();
    }

    /**
     * Constructs a {@code Payment} object with the provided list of payment items.
     *
     * @param menulist The list of payment items to initialize the {@code Payment} object with.
     */

    public Payment(ArrayList<PaymentList> menulist){
        this.paymentItems = menulist;
    }

    /**
     * Adds a new payment item to the list of payment items.
     *
     * @param item The payment item to be added to the list.
     */
    public void addPaymentItem(PaymentList item) {
        paymentItems.add(item);
    }

    /**
     * Returns the list of payment items.
     *
     * @return The list of payment items managed by the {@code Payment} object.
     */
    public ArrayList<PaymentList> getPaymentItems() {
        return paymentItems;
    }

    /**
     * Finds and returns a payment item with the specified item ID. If no item is found,
     * an empty {@code Optional} is returned.
     *
     * @param itemId The ID of the payment item to search for.
     * @return An {@code Optional} containing the payment item with the specified ID,
     *         or an empty {@code Optional} if no item is found.
     */
    public Optional<PaymentList> findPaymentItem(int itemId) {
        for (PaymentList item : paymentItems) {
            if (item.getItemId() == itemId) {
                return Optional.of(item);
            }
        }
        return Optional.empty(); // Return an empty Optional if no item found
    }
}
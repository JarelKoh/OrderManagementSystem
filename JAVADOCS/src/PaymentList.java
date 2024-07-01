/**
 * The {@code PaymentList} class represents a payment item with an item ID and a payment type.
 */
public class PaymentList {
    /**
     * An enumeration representing the different types of payment methods.
     */
    public enum PaymentType { CREDIT, ONLINE, ALIPAY, PAYNOW}
    
    private int itemId;
    private PaymentType type;

    /**
     * Constructs a {@code PaymentList} object with the specified item ID and payment type.
     *
     * @param itemId The ID of the payment item.
     * @param type   The payment type of the payment item.
     */
    public PaymentList(int itemId, PaymentType type) {
        this.itemId = itemId;
        this.type = type;
    }

    public int getItemId() {
        return itemId;
    }

    public PaymentType getType() {
        return type;
    }

    /**
     * Returns a string representation of the {@code PaymentList} object.
     *
     * @return A string representation of the {@code PaymentList} object in the format
     *         "PaymentList {itemId: <itemId>, type: <type>}".
     */

    @Override
    public String toString() {
        return String.format("PaymentList {itemId: %d, type: %s}", itemId, type);
    }
}

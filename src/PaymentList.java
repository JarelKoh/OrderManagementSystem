public class PaymentList {
    public enum PaymentType { CREDIT, ONLINE, ALIPAY, PAYNOW}
    
    private int itemId;
    private PaymentType type;

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

    @Override
    public String toString() {
        return String.format("PaymentList {itemId: %d, type: %s}", itemId, type);
    }
}

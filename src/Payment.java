import java.util.ArrayList;
import java.util.Optional;
public class Payment {
    private ArrayList<PaymentList> paymentItems;

    public Payment() {
        this.paymentItems = new ArrayList<>();
    }

    public Payment(ArrayList<PaymentList> menulist){
        this.paymentItems = menulist;
    }

    public void addPaymentItem(PaymentList item) {
        paymentItems.add(item);
    }

    public ArrayList<PaymentList> getPaymentItems() {
        return paymentItems;
    }

    public Optional<PaymentList> findPaymentItem(int itemId) {
        for (PaymentList item : paymentItems) {
            if (item.getItemId() == itemId) {
                return Optional.of(item);
            }
        }
        return Optional.empty(); // Return an empty Optional if no item found
    }
}

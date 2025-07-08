public class PurchaseResult {
    private String deliveryMessage;
    private float paidAmount;

    public PurchaseResult(float amountPaid, String deliveryMessage) {
        this.paidAmount = amountPaid;
        this.deliveryMessage = deliveryMessage;
    }

    public float getPaidAmount() {
        return paidAmount;
    }

    public String getDeliveryMessage() {
        return deliveryMessage;
    }
}

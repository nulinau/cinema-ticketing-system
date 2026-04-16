public class Order {
    private String orderId;
    private String orderDate;
    private double totalAmount;

    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public boolean confirmOrder(double amount) {
        totalAmount = amount;
        System.out.println("Order confirmed!");
        return true;
    }

    public void cancelOrder() {
        System.out.println("Order cancelled.");
    }
}

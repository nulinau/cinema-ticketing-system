import java.util.Date;

public class Order {

    private String orderId;
    private Date orderDate;
    private double totalAmount;
    private Customer orderByCustomer;

    public Order() {
    }

    // Parameterized Constructor
    public Order(String orderId, Date orderDate, double totalAmount, Customer orderByCustomer) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.orderByCustomer = orderByCustomer;
    }

    public boolean confirmOrder() {
        if (orderByCustomer != null) {
            System.out.println("Order confirmed for customer: " + orderByCustomer.getName());
            return true;
        }
        System.out.println("Order failed: No customer assigned.");
        return false;
    }

    // Getter for orderId
    public String getOrderId() {
        return orderId;
    }
}

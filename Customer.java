
public class Customer extends User {

    //属性
    private String phoneNo;

    //构造方法
    public Customer() {
        this(0,"","","");
    }

    public Customer(int userId, String userName, String password, String phoneNo) {
        super(userId, userName, password); 
        this.phoneNo = phoneNo;
    }

    //方法
    public void bookTicket() {
        System.out.println("Customer is booking a ticket...");
    }

    public void makePayment() {
        System.out.println("Customer is making a payment...");
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    //toString 方法
    @Override
    public String toString() {
        return super.toString() 
        	  +"\nCustomer type: Customer"
              +"\nphoneNo: " + phoneNo;
    }
}

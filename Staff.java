
public class Staff extends User {

    //attribute
    private String role;

    // 构造方法
    public Staff() {
        super();
    }

    public Staff(int userId, String userName, String password, String role) {
        super(userId, userName, password);
        this.role = role;
    }

    //Getter 和 Setter
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String reportGenerate(Order order) {
        String Report_CustomerName =   String.valueOf(order.getOrderByCustomer().getUserName());
        String Report_OrderId      =   String.valueOf(order.getOrderId());
		String Report_OrderDate    =   String.valueOf(order.getOrderDate());
		String Report_TotalAmount  =   String.valueOf(order.getTotalAmount());
		String Report_HallId       =   String.valueOf(order.getHall().getHallId());
		String Report_MovieName   =   String.valueOf(order.getMovie().getTitle());
		
        Report newReport = new Report(Report_CustomerName, Report_OrderId, Report_OrderDate, Report_TotalAmount, Report_HallId, Report_MovieName);
        
        
        String finalReport = newReport.toString(); 
        System.out.print(finalReport); 
        return finalReport;
    }

    // toString 方法 (用于显示 Staff 自己的信息)
    @Override
    public String toString() {
        return super.toString() 
        	  +"\nUser type : Staff"
              +"\nRole      : " + role
              +"----------------------------------------\n";
    }
}

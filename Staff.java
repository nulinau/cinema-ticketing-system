
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

    //方法
    public boolean validateTicket(int ticket) {
		// 先给一个默认返回值，保证编译通过
        
        System.out.println("Validating ticket...");
        return true;
        
        //需要取决于irleesya怎么写，先置空
    }

    public String reportGenerate(Order order, Hall hall, Movie movie) {
        String Report_CustomerName =   getUserName();
        String Report_OrderId      =   String.valueOf(order.getOrderId());//class 未定义
		String Report_OrderDate    =   String.valueOf(order.getOrderDate());//class 未定义
		String Report_TotalAmount  =   String.valueOf(order.getTotalAmount());;//class 未定义
		String Report_HallId       =   String.valueOf(hall.getHallId());//class 未定义
		String Report_MoviveName   =   String.valueOf(movie.getTitle());//class 未定义
		
        Report newReport = new Report(Report_CustomerName, Report_OrderId, Report_OrderDate, Report_TotalAmount, Report_HallId, Report_MoviveName);
        
        return newReport.toString(); 
    }

    // toString 方法 (用于显示 Staff 自己的信息)
    @Override
    public String toString() {
        return super.toString() 
        	  +"\nCustomer type: Staff"
              +"\nRole: " + role;
    }
}

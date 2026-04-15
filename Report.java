
public class Report {
	
	//属性
    private String customerName;
    private String orderId;
    private String orderDate;
	private String totalAmount;
	private String hallId;
	private String movieName;
	
	//构造方法
	public Report(){
		this("","","","","","");
	}
	
    public Report(String customerName, String orderId, String orderDate, String totalAmount, String hallId, String movieName) {
        this.customerName = customerName;
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.hallId = hallId;
        this.movieName = movieName;
    }
    
	//toString 方法
	@Override
    public String toString() {
        return " > Order ID   : " + orderId + 
               "\n   Date       : " + orderDate + 
               "\n   Movie      : " + movieName + 
               "\n   Hall       : " + hallId + 
               "\n   Staff      : " + customerName + 
               "\n   Amount     : $" + totalAmount + 
               "\n----------------------------------------";
    }
}

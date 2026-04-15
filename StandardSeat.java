//ticket and seat booking mgmt
//written by Irleesya

public class StandardSeat extends Seat {
	
	
	public StandardSeat(String seatNumber, double basePrice){
		super(seatNumber, "Available", basePrice);
	}
	
	public double calculatePrice(){
		return getBasePrice();
	}
}
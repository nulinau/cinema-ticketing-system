public class StandardSeat extends Seat {
	
	public StandardSeat(){
		this("A0", 0.0);
	}
	
	public StandardSeat(String seatNumber, double basePrice){
		super(seatNumber, "Available", basePrice);
	}
	
	@Override
	public double calculatePrice(){
		return getBasePrice();
	}
}

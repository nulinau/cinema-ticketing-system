public class VIPSeat extends Seat{
	
	private double luxurySurcharge;
	
	public VIPSeat(){
		this("A0", 0.0, 20.0);
	}
	
	public VIPSeat(String seatNumber, double basePrice, double luxurySurcharge){
		super(seatNumber, "Available", basePrice);
		this.luxurySurcharge = 20.0;
	}
	
	public double calculatePrice(){
		return getBasePrice() + luxurySurcharge;
	}
	
}

public class VIPSeat extends Seat{
	
	private double luxurySurcharge;
	
	public VIPSeat(String seatNumber, double basePrice, double luxurySurcharge){
		super(seatNumber, "Available", basePrice);
		this.luxurySurcharge = luxurySurcharge;
	}
	
	public double calculatePrice(){
		return getBasePrice() + luxurySurcharge;
	}
	
}
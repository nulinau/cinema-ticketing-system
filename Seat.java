

public abstract class Seat { 

    private String seatNumber;
    private String status;
    private double basePrice;
    	

    public Seat() { 
		this("A0", "Available", 0.0);
    }

    public Seat(String seatNumber, String status, double basePrice){
        this.seatNumber = seatNumber;
        this.status = "Available";
        this.basePrice = basePrice;
    }
    
    public String getSeatNumber(){
    	return seatNumber;
    }
    
    public void setSeatNumber(String seatNumber){
    	this.seatNumber = seatNumber;
    }
    
    public String getStatus(){
    	return status;
    }
    
    public void setStatus(String status){
    	this.status = status;
    }
    
    public double getBasePrice(){
    	return basePrice;
    }
    
    public void setBasePrice(double basePrice){
    	this.basePrice = basePrice;
    }
    
    
    public abstract double calculatePrice();
    
    public String toString(){
    	return String.format("Seat %s [%s] - Price: RM%.2f", seatNumber, status, calculatePrice());
    }
    
} 
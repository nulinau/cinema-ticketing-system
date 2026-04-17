import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Booking {

    private String bookingId;
    private Date bookingDate;
    private double totalPrice;
    private List<ConcessionItem> concession;
    private Seat selectedSeat; 
    private boolean booked = false;
    
    public Booking(){
    	
    }

    public Booking(String bookingId, Date bookingDate, boolean booked) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.concession = new ArrayList<>();
        this.totalPrice = 0.0;
        this.booked = false;
    }
    
    public boolean isBooked() {
        return booked;
    }
    
    public Seat getSeat() {
        return selectedSeat;
    }
    
    public String getBookingId() {
        return bookingId;
    }
    
    public void bookSeat() {
        this.booked = true;
    }

    public boolean selectSeat(Seat seat) {
        if (!seat.isBooked()) {
            seat.bookSeat();
            return true;
        }
        return false;
    }

    public void addConcession(ConcessionItem item) {
        concession.add(item);
    }

    public double calcTotal() {
        double total = 0.0;

        for (ConcessionItem item : concession) {
            total += item.getPrice();
        }

        this.totalPrice = total;
        return totalPrice;
    }

    // generate ticket
    public void generateTicket() {
        System.out.println("===== DIGITAL TICKET =====");
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Date: " + bookingDate);
        System.out.println("Total Price: RM " + totalPrice);

        System.out.println("Concessions:");
        for (ConcessionItem item : concession) {
            System.out.println("- " + item.getName() + " (RM " + item.getPrice() + ")");
        }

        System.out.println("==========================");
    }
}

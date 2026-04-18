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
    private Showtime showtime;

    public Booking() {
        this("", new Date(), null, false);
    }

    public Booking(String bookingId, Date bookingDate, Showtime showtime, boolean booked) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.showtime = showtime;
        this.concession = new ArrayList<>();
        this.totalPrice = 0.0;
        this.booked = false;
    }

    public boolean isBooked() {
        return booked;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public Seat getSeat() {
        return selectedSeat;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void bookSeat() {
        this.booked = true;
    }

    public boolean selectSeat(Seat seat) {
        if (!seat.isBooked()) {
            seat.bookSeat();
            this.selectedSeat = seat;
            return true;
        }
        return false;
    }

    public void addConcession(ConcessionItem item) {
        concession.add(item);
    }

    public double calcTotal() {
        double total = 0.0;

        if (selectedSeat != null) {
            total += selectedSeat.calculatePrice();
        }

        for (ConcessionItem item : concession) {
            total += item.getPrice();
        }

        this.totalPrice = total;
        return totalPrice;
    }

    // generate ticket
    public void generateTicket() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        calcTotal();

        System.out.println("\n===== DIGITAL TICKET =====");
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Date: " + sdf.format(bookingDate));

        if (showtime != null) {
            System.out.println("Movie Title   : " + showtime.getMovie().getTitle());
            System.out.println("Showtime      : " + showtime.getDateTime());
            System.out.println("Hall          : " + showtime.getHall().getHallId());
        }

        if (selectedSeat != null) {
            System.out.println("Seat Number   : " + selectedSeat.getSeatNumber());
            // Check seat type using instanceof
            String type = (selectedSeat instanceof VIPSeat) ? "VIP" : "Standard";
            System.out.println("Seat Type     : " + type);
        }

        System.out.println("Concessions:");
        for (ConcessionItem item : concession) {
            System.out.println("- " + item.getName() + " (RM " + item.getPrice() + ")");
        }

        System.out.println("--------------------------");
        System.out.println("Total Price   : RM " + totalPrice);
        System.out.println("==========================");
    }
}

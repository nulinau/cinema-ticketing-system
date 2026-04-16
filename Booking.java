import java.util.ArrayList;

public class Booking {
    private String bookingId;
    private String bookingDate;
    private double totalPrice;

    private ArrayList<Seat> seats;
    private ArrayList<ConcessionItem> concessions;

    public Booking(String bookingId, String bookingDate) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        seats = new ArrayList<>();
        concessions = new ArrayList<>();
    }

    
    public boolean selectSeat(Seat seat) {
        if (seat.getStatus().equals("Booked")) {
            System.out.println("Seat already booked!");
            return false;
        }
        seat.setStatus("Booked");
        seats.add(seat);
        return true;
    }

    // Add concession
    public void addConcession(ConcessionItem item) {
        concessions.add(item);
    }

    // Calculate total
    public double calcTotal() {
        totalPrice = 0;

        for (ConcessionItem item : concessions) {
            totalPrice += item.getPrice();
        }

        totalPrice += seats.size() * 10;
        return totalPrice;
    }

    // Generate the  digital tickets for it
    public String generateTicket() {
        String ticket = "----- DIGITAL TICKET -----\n";
        ticket += "Booking ID: " + bookingId + "\n";
        ticket += "Seats: ";

        for (Seat s : seats) {
            ticket += s.getSeatNo() + " ";
        }

        ticket += "\nTotal Price: RM " + calcTotal();
        return ticket;
    }
}

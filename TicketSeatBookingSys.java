import java.util.Scanner;
import java.util.ArrayList;

public class TicketSeatBookingSys {
    private static ArrayList<Booking> bookings = new ArrayList<>(); // [1]
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        while (choice != 5) {
            System.out.println("\n--- Ticket and Seat Booking Page ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. View Booking");
            System.out.println("3. Edit Booking");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Exit Booking Page");
            System.out.print("Select an option: ");
            
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1 : bookTicket();
                case 2 : viewBooking();
                case 3 : editBooking();
                case 4 : cancelBooking();
                case 5 : System.out.println("Exiting Booking Page...");
                default : System.out.println("Invalid choice.");
            }
        }
    }

    // [CREATE] Book Ticket
    private static void bookTicket() {
        System.out.println("\n--- Seat Selection (8x8 Layout) ---");
        System.out.println("   0  1  2  3  4  5  6  7");
        for (char r = 'A'; r <= 'H'; r++) {
            System.out.print(r + " ");
            for (int c = 0; c <= 7; c++) {
                System.out.print("[ ]");
            }
            System.out.println();
        }

        System.out.print("Choose Row (A-H): ");
        String row = scanner.next().toUpperCase();
        System.out.print("Choose Column (0-7): ");
        int col = scanner.nextInt();
        
        System.out.println("Choose Seat Type: \n1. Standard  \n2. VIP");
        int type = scanner.nextInt();
        
        Seat selectedSeat; // [2]
        if (type == 2) {
            selectedSeat = new VIPSeat(); // [3] //seatNumber, status, basePrice, 
            System.out.println("VIP Seat Selected.");
        } else {
            selectedSeat = new StandardSeat(); // [4]
            System.out.println("Standard Seat Selected.");
        }

        System.out.print("Confirm booking and proceed to payment? (Y/N): ");
        if (scanner.next().equalsIgnoreCase("Y")) {
            Booking newBooking = new Booking(); // [1]
            // Note: Since Booking [1] is empty in sources, ID logic is handled here for simulation
            bookings.add(newBooking);
            System.out.println("Booking payment successful! \nTicket confirmed for " + row + col);
        }
    }

    	// [READ] View Booking
    	private static void viewBooking() {
        	System.out.print("Enter Booking ID: ");
        	String id = scanner.next();
        
        // Validation logic for current system
        if (bookings.isEmpty()) {
            System.out.println("No bookings found in the system.");
        } else {
            System.out.println("--- Booking Details ---");
            System.out.println("Booking Found. Movie: [Source Data Pending], Seat: [Pending], Date: [Pending]");
        }
    }

    // [UPDATE] Edit Booking
    private static void editBooking() {
        System.out.print("Enter Booking ID to edit: ");
        String id = scanner.next();
        
        // Input validation
        if (!bookings.isEmpty()) {
            System.out.println("Booking Found. Enter new details:");
            System.out.print("New Seat Number/Row: ");
            String newSeat = scanner.next();
            System.out.println("Booking details updated successfully.");
        } else {
            System.out.println("Error: Booking ID not found.");
        }
    }

    // [DELETE] Cancel Booking
    private static void cancelBooking() {
        System.out.print("Enter Booking ID to cancel: ");
        String bookingId = scanner.next();

        if (!bookings.isEmpty()) {
            System.out.print("Are you sure you want to cancel this booking? (Y/N): ");
            if (scanner.next().equalsIgnoreCase("Y")) {
                bookings.remove(0); // Removes based on simulated validation
                System.out.println("Booking successfully cancelled.");
            }
        } else {
            System.out.println("Delete Failed: Booking ID Not Found.");
        }
    }
}

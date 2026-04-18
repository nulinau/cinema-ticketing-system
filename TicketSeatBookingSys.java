import java.util.Scanner;
import java.util.ArrayList;

public class TicketSeatBookingSys {
    private static ArrayList<Booking> bookings = new ArrayList<>(); // [1]
    private static ArrayList<Movie> availableMovies = new ArrayList<>();
    private static ArrayList<Showtime> availableShowtimes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    static {
        // Initialize Halls
        Hall hall1 = new Hall(1, "IMAX", 8, 8);
        Hall hall2 = new Hall(2, "Standard", 8, 8);

        // Initialize Movies
        Movie m1 = new Movie("M1", "Avengers: Endgame", "Action", 181, "PG-13", "English");
        Movie m2 = new Movie("M2", "The Dark Knight", "Action", 152, "PG-13", "English");
        availableMovies.add(m1);
        availableMovies.add(m2);

        // Initialize Showtimes
        availableShowtimes.add(new Showtime("S1", m1, "18-04-2026 10:00", hall1));
        availableShowtimes.add(new Showtime("S2", m1, "18-04-2026 14:00", hall2));
        availableShowtimes.add(new Showtime("S3", m2, "18-04-2026 18:00", hall1));
    }

    public static void main(String[] args) {
        int choice = 0;
        while (choice != 5) {
            System.out.println("\n========== CINEMA TICKET AND SEAT BOOKING SYSTEM ==========\n");
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
                System.out.println("Please enter a valid number (1-5)");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1:
                    bookTicket();
                    break;
                case 2:
                    viewBooking();
                    break;
                case 3:
                    editBooking();
                    break;
                case 4:
                    cancelBooking();
                    break;
                case 5:
                    System.out.println("\nExiting Booking Page...");
                    break;
                default:
                    System.out.println("\nInvalid choice.");
            }
        }
    }

    // [CREATE] Book Ticket
    private static void bookTicket() {
        System.out.println("\n--- Select a Movie ---");
        for (int i = 0; i < availableMovies.size(); i++) {
            System.out.println((i + 1) + ". " + availableMovies.get(i).getTitle());
        }
        System.out.print("Select Movie (number): ");
        int movieChoice = scanner.nextInt();
        if (movieChoice < 1 || movieChoice > availableMovies.size()) {
            System.out.println("Invalid selection.");
            return;
        }
        Movie selectedMovie = availableMovies.get(movieChoice - 1);

        System.out.println("\n--- Select Showtime for " + selectedMovie.getTitle() + " ---");
        ArrayList<Showtime> filteredShowtimes = new ArrayList<>();
        for (Showtime st : availableShowtimes) {
            if (st.getMovie().getMovieId().equals(selectedMovie.getMovieId())) {
                filteredShowtimes.add(st);
            }
        }

        if (filteredShowtimes.isEmpty()) {
            System.out.println("No showtimes available for this movie.");
            return;
        }

        for (int i = 0; i < filteredShowtimes.size(); i++) {
            Showtime st = filteredShowtimes.get(i);
            System.out.println((i + 1) + ". " + st.getDateTime() + " (Hall " + st.getHall().getHallId() + ")");
        }
        System.out.print("Select Showtime (number): ");
        int showtimeChoice = scanner.nextInt();
        if (showtimeChoice < 1 || showtimeChoice > filteredShowtimes.size()) {
            System.out.println("Invalid selection.");
            return;
        }
        Showtime selectedShowtime = filteredShowtimes.get(showtimeChoice - 1);
        Hall selectedHall = selectedShowtime.getHall();

        selectedHall.displaySeatMap();

        System.out.println("\n--- Seat Types ---");
        System.out.println("- VIP Seat (Row A) - Premium spacious seating with extra comfort (RM " + selectedHall.getSeat(0, 0).calculatePrice() + ")");
        System.out.println("- Standard Seat (Row B-H) - Regular seating with excellent viewing angles (RM " + selectedHall.getSeat(1, 0).calculatePrice() + ")");

        String row;
        while (true) {
            System.out.print("\nChoose Row (A-H): ");
            row = scanner.next().toUpperCase();
            if (row.length() == 1 && Character.isLetter(row.charAt(0))) {
                break;
            } else {
                System.out.println("\nInvalid input. Please enter a valid letter (A-H).");
            }
        }

        System.out.print("Choose Column (1-8): ");
        int col = scanner.nextInt();
        
        int rIndex = row.charAt(0) - 'A';
        int cIndex = col - 1;

        if (rIndex < 0 || rIndex >= 8 || cIndex < 0 || cIndex >= 8) {
            System.out.println("Invalid seat selection.");
            return;
        }

        Seat selectedSeat = selectedHall.getSeat(rIndex, cIndex);

        if (selectedSeat.isBooked()) {
            System.out.println("\nSorry, this seat is already booked! Please select another one.");
            System.out.println("Press Enter to return to menu...");
            scanner.nextLine(); // clear buffer
            scanner.nextLine(); // wait for user
            return;
        }

        System.out.println("\nYou have selected: " + selectedSeat.getSeatNumber());
        if (selectedSeat instanceof VIPSeat) {
            System.out.println("Seat Type: VIP - Premium spacious seating with extra comfort (RM " + selectedSeat.calculatePrice() + ")");
        } else {
            System.out.println("Seat Type: Standard - Regular seating with excellent viewing angles (RM " + selectedSeat.calculatePrice() + ")");
        }

        System.out.print("Confirm booking? (Y/N): ");
        if (scanner.next().equalsIgnoreCase("Y")) {

            String bookingId = "BK" + (bookings.size() + 1001);
            java.util.Date dateNow = new java.util.Date();

            Booking newBooking = new Booking(bookingId, dateNow, selectedShowtime, false);

            if (newBooking.selectSeat(selectedSeat)) {
                // Interactive Concession Menu
                boolean choosingConcessions = true;
                while (choosingConcessions) {
                    System.out.println("\n--- Food & Beverage Menu ---");
                    System.out.println("1. Popcorn Combo (RM 15.00)");
                    System.out.println("2. Large Soda (RM 6.00)");
                    System.out.println("3. Hotdog (RM 8.00)");
                    System.out.println("4. Nachos (RM 10.00)");
                    System.out.println("5. Done / Proceed to Ticket");
                    System.out.print("Select an item to add to your booking: ");

                    if (scanner.hasNextInt()) {
                        int choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                newBooking.addConcession(new ConcessionItem("Popcorn Combo", 15.00, "Food"));
                                System.out.println("Added Popcorn Combo.");
                                break;
                            case 2:
                                newBooking.addConcession(new ConcessionItem("Large Soda", 6.00, "Beverage"));
                                System.out.println("Added Large Soda.");
                                break;
                            case 3:
                                newBooking.addConcession(new ConcessionItem("Hotdog", 8.00, "Food"));
                                System.out.println("Added Hotdog.");
                                break;
                            case 4:
                                newBooking.addConcession(new ConcessionItem("Nachos", 10.00, "Food"));
                                System.out.println("Added Nachos.");
                                break;
                            case 5:
                                choosingConcessions = false;
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next(); // clear bad input
                    }
                }

                bookings.add(newBooking);

                // Generates the ticket summary
                newBooking.generateTicket();

                System.out.println("Process completed. Press Enter to return to menu...");
                scanner.nextLine(); // clear buffer
                scanner.nextLine(); // wait for user
            }
        } else {
            System.out.print("Do you want to book again? (Y/N): ");
            if (scanner.next().equalsIgnoreCase("Y")) {
                bookTicket();
            }
        }
    }

    // [READ] View Booking
    private static void viewBooking() {
        System.out.print("Enter Booking ID: ");
        String id = scanner.next();

        // Find the booking by ID
        Booking foundBooking = null;
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(id)) {
                foundBooking = booking;
                break;
            }
        }

        if (foundBooking != null) {
            System.out.println("\n--- Booking Details ---");
            String seatStr = (foundBooking.getSeat() != null) ? foundBooking.getSeat().getSeatNumber()
                    : "[No Seat Selected]";
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm");
            String dateStr = (foundBooking.getBookingDate() != null) ? sdf.format(foundBooking.getBookingDate())
                    : "[Unknown Date]";
            String movieTitle = (foundBooking.getShowtime() != null) ? foundBooking.getShowtime().getMovie().getTitle()
                    : "[Source Data Pending]";
            String hallStr = (foundBooking.getShowtime() != null)
                    ? "Hall " + foundBooking.getShowtime().getHall().getHallId()
                    : "[Unknown Hall]";

            System.out.println(
                    "Booking Found. \nMovie: " + movieTitle + " \nHall: " + hallStr + " \nSeat: " + seatStr
                            + " \nDate: " + dateStr);
        } else {
            System.out.println("Error: Booking ID not found.");
        }
        System.out.println("\nPress Enter to return to menu...");
        scanner.nextLine(); // clear buffer
        scanner.nextLine(); // wait for user
    }

    // [UPDATE] Edit Booking
    private static void editBooking() {
        System.out.print("Enter Booking ID to edit: ");
        String bookingId = scanner.next();

        // Find the booking by ID
        Booking foundBooking = null;
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(bookingId)) {
                foundBooking = booking;
                break;
            }
        }

        if (foundBooking != null) {
            System.out.println("Booking Found. Enter new details:");
            System.out.print("New Seat Number/Row: ");
            String newSeat = scanner.next();

            // Actually update the seat
            if (foundBooking.getSeat() != null) {
                foundBooking.getSeat().setSeatNumber(newSeat);
            }

            System.out.println("Booking details updated successfully.");
        } else {
            System.out.println("Error: Booking ID not found.");
        }
        System.out.println("\nPress Enter to return to menu...");
        scanner.nextLine(); // clear buffer
        scanner.nextLine(); // wait for user
    }

    // [DELETE] Cancel Booking
    private static void cancelBooking() {
        System.out.print("Enter Booking ID to cancel: ");
        String bookingId = scanner.next();

        // Find the booking by ID
        Booking foundBooking = null;
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(bookingId)) {
                foundBooking = booking;
                break;
            }
        }

        if (foundBooking != null) {
            System.out.print("Are you sure you want to cancel this booking? (Y/N): ");
            if (scanner.next().equalsIgnoreCase("Y")) {
                bookings.remove(foundBooking);
                System.out.println("Booking successfully cancelled.");
            }
        } else {
            System.out.println("Delete Failed: Booking ID Not Found.");
        }
        System.out.println("\nPress Enter to return to menu...");
        scanner.nextLine(); // clear buffer
        scanner.nextLine(); // wait for user
    }
}

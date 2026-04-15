//===================
//MAIN DRIVER PROGRAM
//===================

import java.util.ArrayList;

public class TicketSeatBookingSys {
    public static void main(String[] args) {
    	
    	//arrayList
    	private static ArrayList<Seat> bookings = new ArrayList<>();
    	
        // 1. Create a Hall (Hall ID: 101, Screen: IMAX, 5 Rows, 8 Columns)
        // Note: Row 0 will be VIP based on your initialiseSeats() logic
        Hall hall = new Hall(101, "IMAX", 5, 8);
	
		System.out.println("\n");
        System.out.println("Cinema Ticket and Seat Booking");
        System.out.println("=======================================");
        
        //CREATE (Booking a seat)
        System.out.println("1. Book Seat)");
        Seat seatToBook = hall.getSeat(0,0); //for seat [0,0]
        seatToBook.setStatus("Booked!");
        bookings.add(seatToBook);
        
        //READ (VIEW Bookings)
        System.out.println("\n2. View Current Booking List");
        for(Seat s : bookings) {
        	System.out.println(s.toString());
        }
        hall.displaySeatMap();
        
        //UPDATE (Changing a seat, ex: swapping a seat to another)
        System.out.println("\n3. Edit Booking");
        hall.getSeat(0, 0).setStatus("Available");
        bookings.remove(seatToBook);
        
        // Book new seat
        Seat newSeat = myHall.getSeat(0, 4); // A5
        newSeat.setStatus("Booked");
        bookings.add(newSeat);
        
        System.out.println("Update successful. New map:");
        hall.displaySeatMap();
        
        
        // 4. DELETE (Cancelling a booking)
        System.out.println("\n[DELETE] Cancelling all bookings...");
        if (!bookings.isEmpty()) {
            Seat cancelThis = bookings.get(0);
            cancelThis.setStatus("Available");
            bookings.remove(0);
        }
        
        System.out.println("Cancellation complete. Final map:");
        myHall.displaySeatMap();
        

        // 2. Display the initial seat map (All should be [ ])
        hall.displaySeatMap();

        // 3. Simulate booking some seats
        System.out.println("\nBooking seats: A1 (VIP), A2 (VIP), and B5 (Standard)...");
        
        // Booking A1 (Row 0, Col 0)
        Seat s1 = myHall.getSeat(0, 0);
        s1.setStatus("Booked");

        // Booking A2 (Row 0, Col 1)
        Seat s2 = myHall.getSeat(0, 1);
        s2.setStatus("Booked");

        // Booking B5 (Row 1, Col 4)
        Seat s3 = myHall.getSeat(1, 4);
        s3.setStatus("Booked");
        
        /*because it's an array, it starts from 0, layout:
         *
         *[0,0] [0,1] [0,2] [0,3] [0,4] [0,5] [0,6] [0,7]
         *[1,0] [1,1] [1,2] [1,3] [1,4] [1,5] [1,6] [1,7]
         *[2,0] [2,1] [2,2] [2,3] [2,4] [2,5] [2,6] [2,7]
         *[3,0] [3,1] [3,2] [3,3] [3,4] [3,5] [3,6] [3,7]
         *[4,0] [4,1] [4,2] [4,3] [4,4] [4,5] [4,6] [4,7]
         *[5,0] [5,1] [5,2] [5,3] [5,4] [5,5] [5,6] [5,7]
         *[6,0] [6,1] [6,2] [6,3] [6,4] [6,5] [6,6] [6,7]
         *[7,0] [7,1] [7,2] [7,3] [7,4] [7,5] [7,6] [7,7]
         *
         **/

        // Display the updated seat map (Should show [X] for booked seats)
        hall.displaySeatMap();

        // Calculate and Display the Total Price
        double totalRevenue = s1.calculatePrice() + s2.calculatePrice() + s3.calculatePrice();
        
        System.out.println("\n--- Booking Summary ---");
        System.out.println(s1.toString()); 
        System.out.println(s2.toString());
        System.out.println(s3.toString());
        System.out.println("-----------------------");
        System.out.printf("Total Amount to Pay: RM%.2f\n", totalRevenue);
        System.out.println("===================================");

    }
}
public class Hall {


    private int hallId;
    private String screenSize;
    private int seatingCapacity;
    //private boolean isBooked;
    
    //2d array definition
    private int row;
    private int col;
    private Seat[][] seatMap;
    
    
    //constructor
    public Hall(int hallId, String screenSize, int row, int col){
    	this.hallId = hallId;
    	this.screenSize = screenSize;
    	this.row = row;
    	this.col = col;
    	this.seatingCapacity = row * col;
    	this.seatMap = new Seat[row][col];
    	initialiseSeats();
    }

    
    //hallId getter and setter
    public int getHallId(){
    	return hallId;
    }
    
    public void setHallId(int hallId){
    	this.hallId = hallId;
    }
    
    
    //screenSize getter and setter
    public void getScreenSize(String screenSize){
    	this.screenSize = screenSize;
    }
    
    public String setScreenSize(){
    	return screenSize;
    }
    
    //seatingCapacity getter and setter
    public void getSeatingCapacity(int seatingCapacity){
    	this.seatingCapacity = seatingCapacity;
    }
    
    public int setSeatingCapacity(){
    	return seatingCapacity;
    }
    
    private void initialiseSeats(){
    	for(int i = 0; i < row; i++){
    		for(int j = 0; j < col; j++){
    			String seatNum = (char)('A' + i) + String.valueOf(j + 1);
    			
    			if (i == 0){
    				seatMap[i][j] = new VIPSeat(seatNum, 15.0, 25.0);
    			}
    			else {
    				seatMap[i][j] = new StandardSeat(seatNum, 7.0);
    			}
    		}
    	}
    }
    
    public void displaySeatMap() {
        System.out.println("\n--- Hall: " + hallId + " | Screen: " + screenSize + " ---");
        System.out.println("      [ SCREEN THIS WAY ]\n");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // If status is "Available", show [ ], otherwise show [X]
                String display = seatMap[i][j].getStatus().equals("Available") ? "[ ]" : "[X]";
                System.out.print(seatMap[i][j].getSeatNumber() + display + "  ");
            }
            System.out.println(); // Next row
        }
        System.out.println("\nLegend: [ ] = Available  [X] = Booked");
    }
    
    public Seat getSeat(int r, int c) {
        return seatMap[r][c];
    }

}

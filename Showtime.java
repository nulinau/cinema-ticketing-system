public class Showtime {
    
    // 属性
    private String showtimeId;
    private String date;
    private String time;
    private Hall assignedHall;
    private Movie movie; 

    //构筑方法
    public Showtime() {}

    public Showtime(String showtimeId, String date, String time, Hall assignedHall, Movie movie) {
        this.showtimeId = showtimeId;
        this.date = date;
        this.time = time;
        this.assignedHall = assignedHall;
        this.movie = movie;
    }

    // Getters 和 Setters
    public String getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(String showtimeId) {
        this.showtimeId = showtimeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Hall getAssignedHall() {
        return assignedHall;
    }

    public void setAssignedHall(Hall assignedHall) {
        this.assignedHall = assignedHall;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    //toString方法
	@Override
    public String toString() {
        return 
        "Showtime ID: " + showtimeId
      + "\nDate: " + date
      + "\nTime: " + time
      + "\nHall: " + (hall != null ? hall.getHallId() : "Not Assigned")
      + "\nMovie: " + (movie != null ? movie.getTitle() : "Not Assigned");
    }
}

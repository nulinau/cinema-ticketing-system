public class Showtime {
    private String showtimeId;
    private Movie movie;
    private String dateTime;
    private Hall hall;

    public Showtime(String showtimeId, Movie movie, String dateTime, Hall hall) {
        this.showtimeId = showtimeId;
        this.movie = movie;
        this.dateTime = dateTime;
        this.hall = hall;
    }

    public String getShowtimeId() {
        return showtimeId;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getDateTime() {
        return dateTime;
    }

    public Hall getHall() {
        return hall;
    }

    @Override
    public String toString() {
        return String.format("%s - %s | %s | Hall %d", 
            showtimeId, movie.getTitle(), dateTime, hall.getHallId());
    }
}

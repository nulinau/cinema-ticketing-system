public class Movie {

    String movieId;
    String title;
    String genre;
    int duration;
    String ageRating;

    public Movie(String movieId, String title, String genre, int duration, String ageRating) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.ageRating = ageRating;
    }

    public void displayMovie() {
        System.out.println("Movie ID: " + movieId);
        System.out.println("Title: " + title);
        System.out.println("Genre: " + genre);
        System.out.println("Duration: " + duration + " mins");
        System.out.println("Age Rating: " + ageRating);
    }
}

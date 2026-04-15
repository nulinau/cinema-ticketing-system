public class Movie {
	
	//属性
    private String movieId;
    private String title;
    private String genre;
    private int duration; 
    private String ageRating;
    private String language;
	
	//构筑方法
    public Movie() {}

    public Movie(String movieId, String title, String genre, int duration, String ageRating, String language) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.ageRating = ageRating;
        this.language = language;
    }

    // Getters 和 Setters
    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    // toString方法
    @Override
    public String toString() {
        return
            "Movie ID: "+movieId
           +"\nTitle: "+title
           +"\nGenre: "+genre
           +"\nDuration: "+duration
           +"\nRating: "+ageRating
           +"\nLanguage: "+language;
    }
}

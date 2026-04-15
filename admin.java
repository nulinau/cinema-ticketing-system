import java.util.ArrayList;

public class Admin extends Staff {
    
    // 属性
    private ArrayList<Movie> movieList;
    private ArrayList<Showtime> showtimeList;

    // 构造方法
    public Admin(){
    	this("","","");
    }
    
    public Admin(String userId, String userName, String password) {
        super(userId, userName, password); 
        this.movieList = new ArrayList<>();
        this.showtimeList = new ArrayList<>();
    }

    //------------------------------------------
    //             电影管理方法
    //------------------------------------------

    // 赠加电影
    public void addMovie(Movie m) {
        movieList.add(m);
        System.out.println("Add Movie Success: " + m.getTitle());
    }

    // 查看所有电影
    public void viewMovie() {
        if (movieList.isEmpty()) {
            System.out.println("No Movie Found");
            return;
        }
        System.out.println("----- Movie List -----");
        for (Movie m : movieList) {
            // This will call the toString() method of the Movie class
            System.out.println(m); 
        }
    }

    // 更新电影
    public void updateMovie(Movie m) {
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getMovieId().equals(m.getMovieId())) {
                movieList.set(i, m);
                System.out.println("Movie Information Update Success");
                return;
            }
        }
        System.out.println("Movie ID Not Found");
    }

    // 删除电影
    public void deleteMovie(String movieId) {
        boolean removed = movieList.removeIf(m -> m.getMovieId().equals(movieId));
        if (removed) {
            System.out.println("Movie ID " + movieId + " Delete Success");
        } else {
            System.out.println("Delete Failed, Movie ID Not Found.");
        }
    }

    //------------------------------------------
    //      Showtime 管理方法
    //------------------------------------------

    // 排程 Showtime
    public void scheduleShowtime(Showtime s) {
        showtimeList.add(s);
        System.out.println("New Showtime added to the system.");
    }

    // 更新 Showtime
    public void updateShowtime(Showtime s) {
        for (int i = 0; i < showtimeList.size(); i++) {
            if (showtimeList.get(i).getShowtimeId().equals(s.getShowtimeId())) {
                showtimeList.set(i, s);
                System.out.println("Showtime updated successfully.");
                return;
            }
        }
        System.out.println("Showtime ID Not Found");
    }

    // 删除 Showtime
    public void deleteShowtime(String showtimeId) {
        boolean removed = showtimeList.removeIf(s -> s.getShowtimeId().equals(showtimeId));
        if (removed) {
            System.out.println("Showtime ID " + showtimeId + " deleted.");
        } else {
            System.out.println("Delete Failed, Showtime ID Not Found.");
        }
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Staff {
    
    // 属性
    private ArrayList<Movie> movieList;
    private ArrayList<Showtime> showtimeList;

    // 构造方法 
    public Admin() {
        this(0, "", "");
    }
    
    public Admin(int userId, String userName, String password) {
        super(userId, userName, password, "Admin"); 
        this.movieList = new ArrayList<>();
        this.showtimeList = new ArrayList<>();
    }

    // 新增：让 Customer 类可以获取电影和场次列表
    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public ArrayList<Showtime> getShowtimeList() {
        return showtimeList;
    }

    //------------------------------------------
    //             电影管理方法
    //------------------------------------------
    public void addMovie(Movie m) {
        movieList.add(m);
        System.out.println("Add Movie Success: " + m.getTitle());
    }

    public void viewMovie() {
        if (movieList.isEmpty()) {
            System.out.println("No Movie Found");
            return;
        }
        System.out.println("----- Movie List -----");
        for (Movie m : movieList) {
            System.out.println(m); 
        }
    }

    public void updateMovie(Movie m) {
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getMovieId().equals(m.getMovieId())) {
                movieList.set(i, m);
                System.out.println("Movie updated successfully.");
                return;
            }
        }
    }

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
    public void scheduleShowtime(Showtime s) {
        showtimeList.add(s);
        System.out.println("New Showtime added to the system.");
    }

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

    public void deleteShowtime(String showtimeId) {
        boolean removed = showtimeList.removeIf(s -> s.getShowtimeId().equals(showtimeId));
        if (removed) {
            System.out.println("Showtime ID " + showtimeId + " deleted.");
        } else {
            System.out.println("Delete Failed, Showtime ID Not Found.");
        }
    }

    public void showMenu() {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n=== Admin Menu ===");
                System.out.println("1. View Movies");
                System.out.println("2. Add Movie");
                System.out.println("3. Schedule Showtime");
                System.out.println("4. Logout");
                System.out.print("Choice: ");
                String choice = sc.nextLine();

                if (choice.equals("1")) {
                    viewMovie();
                } else if (choice.equals("2")) {
                    System.out.print("Enter Movie ID: "); String id = sc.nextLine();
                    System.out.print("Enter Title: "); String title = sc.nextLine();
                    System.out.print("Enter Genre: "); String genre = sc.nextLine();
                    System.out.print("Enter Duration (min): "); int duration = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Age Rating: "); String rating = sc.nextLine();
                    System.out.print("Enter Language: "); String lang = sc.nextLine();
                    addMovie(new Movie(id, title, genre, duration, rating, lang));
                } else if (choice.equals("3")) {
                    // 这里假设简化处理，先让Admin选择已有的Movie
                    System.out.print("Enter Showtime ID: "); String sId = sc.nextLine();
                    System.out.print("Enter Movie Index (0 for first movie): "); int mIdx = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Date and Time (e.g., 2023-12-25 20:00): "); String dt = sc.nextLine();
                    // 这里为了演示方便，创建了一个默认的Hall，你可以根据需求扩展
                    Hall h = new Hall(1, "Standard", 5, 5);
                    scheduleShowtime(new Showtime(sId, getMovieList().get(mIdx), dt, h));
                } else {
                    break; // Logout
                }
            }
        }
    }
}


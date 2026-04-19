import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User {

    //属性
    private String phoneNo;
    private static int NumOfCustomers = 0;
    private Admin admin;

    //构造方法
    public Customer() {
        this(0,"","","", null);
    }

    public Customer(int userId, String userName, String password, String phoneNo, Admin admin) {
        super(userId, userName, password); 
        this.phoneNo = phoneNo;
        this.admin = admin;
        NumOfCustomers++;
    }

    //方法
    public void makePayment() {
        System.out.println("Customer is making a payment...");
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public static int getNumOfCustomers() {
        return NumOfCustomers;
    }

    //菜单方法
    @Override
    public void showMenu() { 
    Scanner sc = new Scanner(System.in);

    while (true) {
        System.out.println("\n=== Customer Menu ===");
        System.out.println("1. Order Ticket");
        System.out.println("2. Make Payment");
        System.out.println("3. User Information");
        System.out.println("4. Exit");

        String choice = sc.nextLine();

        switch (choice) {
            case "1":
                bookTicket(); 
                break;

            case "2":
                makePayment();
                break;

            case "3":
                // 必须使用 System.out.println 才能打印 toString 的内容
                System.out.println(this.toString());
                break;

            case "4":
                System.out.println("Exie System。");
                sc.close();
                return; // 结束循环

            default:
                System.out.println("Invalid input. Please try again.");
        }
    }
}

    public void bookTicket() {
    Scanner sc = new Scanner(System.in);

    // 第一步：显示所有电影并让用户选择
    System.out.println("\n===== Step 1: Select a Movie =====");
    // Note: You will need to pass Admin instance or store it as a class member to access movie list
    ArrayList<Movie> movies = this.admin.getMovieList();
    if (movies.isEmpty()) {
        System.out.println("No movies available.");
        sc.close();
        return;
    }
    for (int i = 0; i < movies.size(); i++) {
        System.out.println((i + 1) + ". " + movies.get(i).getTitle() + " [" + movies.get(i).getMovieId() + "]");
    }
    System.out.print("Enter Movie ID: ");
    String movieId = sc.nextLine();

    // 寻找匹配的电影对象
    Movie selectedMovie = null;
    for (Movie m : movies) {
        if (m.getMovieId().equalsIgnoreCase(movieId)) {
            selectedMovie = m;
            break;
        }
    }
    if (selectedMovie == null) {
        System.out.println("Invalid Movie ID.");
        sc.close();
        return;
    }

    // 第二步：根据选定的电影，显示该电影的所有场次 (Showtime)
    System.out.println("\n===== Step 2: Select a Showtime for " + selectedMovie.getTitle() + " =====");
    ArrayList<Showtime> allShowtimes = admin.getShowtimeList();
    ArrayList<Showtime> movieShowtimes = new ArrayList<>();
    
    // 过滤出属于这部电影的场次
    for (Showtime s : allShowtimes) {
        if (s.getMovie().getMovieId().equalsIgnoreCase(selectedMovie.getMovieId())) {
            movieShowtimes.add(s);
        }
    }

    if (movieShowtimes.isEmpty()) {
        System.out.println("No showtimes for this movie.");
        sc.close();
        return;
    }

    for (int i = 0; i < movieShowtimes.size(); i++) {
        System.out.println((i + 1) + ". " + movieShowtimes.get(i).getDateTime() + " (Hall " + movieShowtimes.get(i).getHall().getHallId() + ")");
    }
    System.out.print("Select a showtime (Enter number 1-" + movieShowtimes.size() + "): ");
    int stChoice = sc.nextInt();
    sc.nextLine(); // 清掉换行符

    Showtime selectedShowtime = movieShowtimes.get(stChoice - 1);
    Hall selectedHall = selectedShowtime.getHall();

    // 第三步：显示座位图并选座
    System.out.println("\n===== Step 3: Select a Seat =====");
    selectedHall.displaySeatMap(); // 调用你写好的显示座位图方法
    System.out.print("Enter Seat Number (e.g., A1): ");
    String seatNum = sc.nextLine().toUpperCase();

    // 在 Hall 里寻找该座位对象
    Seat selectedSeat = null;
    // 假设 Hall 类里你已经写了根据 String 获取 Seat 对象的方法，
    // 如果没有，我们直接通过解析 seatNum (如 A1 -> row 0, col 0)
    int row = seatNum.charAt(0) - 'A';
    int col = Integer.parseInt(seatNum.substring(1)) - 1;
    
    selectedSeat = selectedHall.getSeatMap()[row][col];

    if (selectedSeat == null || selectedSeat.isBooked()) {
        System.out.println("Seat is not available.");
        sc.close();
        return;
    }

    // 第四步：锁定座位并计算价格
    selectedSeat.bookSeat(); // 将状态设为 Booked
    double finalPrice = selectedSeat.calculatePrice(); // 核心：调用 Seat 自己的计价逻辑！

    // 第五步：生成订单 (Order)
    String orderId = "ORD-" + System.currentTimeMillis() % 10000;
    String orderDate = selectedShowtime.getDateTime();
    
    // 创建 Order 对象 (传入当前 Customer 对象, 即 'this')
    Order newOrder = new Order(orderId, orderDate, finalPrice, selectedHall, selectedMovie, this);

    System.out.println("\n✅ Booking Successful!");
    System.out.println("----------------------------------------");
    System.out.println("Order ID   : " + newOrder.getOrderId());
    System.out.println("Movie      : " + selectedMovie.getTitle());
    System.out.println("Seat       : " + seatNum);
    System.out.println("Total Paid : $" + finalPrice);
    System.out.println("----------------------------------------");
    sc.close();
}
    
    //toString 方法
    @Override
    public String toString() {
        return super.toString() 
        	  +"\nUser type : Customer"
              +"\nphoneNo   : " + phoneNo
              +"----------------------------------------\n";
    }
}

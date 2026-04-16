import java.sql.*;
import java.util.*;

public class OnlineExamPortal {

    static final String URL = "jdbc:mysql://localhost:3306/exam_portal";
    static final String USER = "root";
    static final String PASS = "root";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        if (login()) {
            startExam();
        } else {
            System.out.println("Invalid login!");
        }
    }

    public static boolean login() {
        System.out.println("===== LOGIN =====");
        System.out.print("Username: ");
        String username = sc.next();
        System.out.print("Password: ");
        String password = sc.next();

        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            String query = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void startExam() {
        int score = 0;

        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            String query = "SELECT * FROM questions";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println("\n" + rs.getString("question"));
                System.out.println("1. " + rs.getString("option1"));
                System.out.println("2. " + rs.getString("option2"));
                System.out.println("3. " + rs.getString("option3"));
                System.out.println("4. " + rs.getString("option4"));

                System.out.print("Your Answer: ");
                int ans = sc.nextInt();

                if (ans == rs.getInt("correct_option")) {
                    score++;
                }
            }

            System.out.println("\n===== RESULT =====");
            System.out.println("Your Score: " + score);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

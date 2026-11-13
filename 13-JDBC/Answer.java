import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Answer {
    public static void main(String[] args) {
        String url = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        if (url == null || user == null || password == null) {
            System.out.println("កំណត់ DB_URL, DB_USER និង DB_PASSWORD សម្រាប់ lab ជាមុន");
            return;
        }

        String sql = "SELECT id, name FROM students WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, 1);
            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    System.out.println(result.getInt("id") + ": " + result.getString("name"));
                }
            }
        } catch (SQLException exception) {
            System.out.println("Database operation failed: " + exception.getMessage());
        }
    }
}

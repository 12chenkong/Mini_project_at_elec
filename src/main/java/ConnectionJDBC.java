import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionJDBC {
    public static Connection connection() {
        Connection con=null;
        try {
            String url = "jdbc:mysql://localhost:3306/stduent";
            String password = "1234567";
            String user = "root";
             con = DriverManager.getConnection(url, user, password);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return  con;
    }
}

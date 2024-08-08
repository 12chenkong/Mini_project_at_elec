import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionJDBC {
    public static Connection Connector() {
        Connection con=null;
        try {
            String url = "jdbc:mysql://localhost:3306/studentdb";
            String password = "1234567";
            String user = "root";
             con = DriverManager.getConnection(url, user, password);

        } catch (Exception ex) {
            System.out.println("Connection fail to connect..");
        }
        return  con;
    }
}

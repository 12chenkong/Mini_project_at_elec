import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetALLBookStudent {
    Connection con=ConnectionJDBC.Connector();
    public  void getBookStudentInfo(){
//        query for fetching data both student and book
     String sql="SELECT s.id,s.Name,b.book_name,b.Author " +
             "FROM student AS s INNER JOIN book AS b " +
             "ON s.book_id=b.book_id ";
        try {
            Statement st= con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()){
               int id=rs.getInt("id");
               String name=rs.getString("Name");
               String bookName=rs.getString("book_name");
               String author=rs.getString("Author");
                System.out.println("ID:"+id);
                System.out.println("Name:"+bookName);
                System.out.println("Author:"+author);
            }

        }catch (Exception e){
            System.out.println("something went wrong "+e.getMessage());
        }

    }
}

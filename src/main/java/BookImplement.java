import java.sql.*;
import java.util.Scanner;

public class BookImplement {
    Scanner scanner=new Scanner(System.in);
    Connection con=ConnectionJDBC.Connector();
    public  void getAllBooks(){
        String sql="SELECT*FROM book";
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()){
                System.out.println("id:"+rs.getInt("book_id"));
                System.out.println("Name:"+rs.getString("book_name"));
                System.out.println("Author:"+rs.getString("Author"));
                System.out.println("");
            }

        }catch (SQLException e){
            System.out.println("Something went wrong!");
        }
    }
    public void insertBook(){
        System.out.println("Enter book id");
        int id=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter book name");
        String name=scanner.nextLine();
        System.out.println("Enter author of book");
        String author=scanner.nextLine();
        try {
            String sql="INSERT INTO book VALUES(?,?,?)";
                     PreparedStatement pt =con.prepareStatement(sql);
                     pt.setInt(1,id);
                     pt.setString(2,name);
                     pt.setString(3,author);

                     if( pt.executeUpdate()!=0){
                         System.out.println("have been insert a record");
                     }

        }catch (SQLException e){
            System.out.println("someting went wrong");
        }
    }


}

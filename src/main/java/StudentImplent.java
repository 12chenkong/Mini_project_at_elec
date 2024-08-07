import java.sql.*;
import java.util.Scanner;

public class StudentImplent {

   Connection con=ConnectionJDBC.Connector();
  // get student via JDBC from student table
   public void getAllStudent(){
      String query="SELECT*FROM student";
      try {
         Statement st=con.createStatement();
         ResultSet rs=st.executeQuery(query);
         while (rs.next()){
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("name"));
            System.out.println(rs.getFloat("Score"));
         }
      }catch (SQLException e){
         System.out.println("something went wrong");
      }

   }
   // insert student's info to student table
   public void insertStudent(){
       Scanner scanner=new Scanner(System.in);
       System.out.println("Enter your id:");
       int id=scanner.nextInt();
       System.out.println("Enter your name:");
       scanner.nextLine();
       String name=scanner.nextLine();
       System.out.println("Enter your Score:");
       float score= scanner.nextFloat();
      try{
            String query="INSERT INTO student(ID,name,Score)" +
                  " VALUES(?,?,?)";
               PreparedStatement pt = con.prepareStatement(query);
               pt.setInt(1,id);
               pt.setString(2,name);
               pt.setFloat(3,score);
               int num=pt.executeUpdate();
               if(num!=0){
                  System.out.println("Correctly");
               }

      }catch (SQLException e){
         System.out.println("something went wrong ");
      }
   }
   //search student by id
    public  void getStudentByid(int id){
      String query="SELECT *FROM student WHERE id= ?";
      try{
          // for security we use Prepare statement
        PreparedStatement pt=con.prepareStatement(query);
        pt.setInt(1,id);
        ResultSet rs=pt.executeQuery();
        while (rs.next()){
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("name"));
            System.out.println(rs.getFloat("Score"));
        }

      }catch (Exception e){
          System.out.println("something went wrong....");
      }
    }
    // search student by name
    public  void getstudentByName(String name){
        String query="SELECT *FROM student WHERE name= ?";
        try{
            PreparedStatement pt=con.prepareStatement(query);
            name=name.toLowerCase();
            pt.setString(1,name);
            ResultSet rs=pt.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getFloat("Score"));
            }
        }catch (SQLException e){
            System.out.println("Something went wrong");
        }
    }
    //sorted by id
    public void sortedId(){
        String query="SELECT*FROM student ORDER BY id ASC  ";
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getFloat("Score"));
            }
        }catch (SQLException e){
            System.out.println("something went wrong");
        }
    }
    //Sorted by name
    public void sortedByName(){
        String query="SELECT*FROM student ORDER BY name ASC ";
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next()){
                System.out.print(rs.getInt("id")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.print(rs.getFloat("Score")+" ");
                System.out.println(" ");
            }
        }catch (SQLException e){
            System.out.println("something went wrong");
        }
    }
}

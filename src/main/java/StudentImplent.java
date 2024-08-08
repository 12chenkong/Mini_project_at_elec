import java.sql.*;
import java.util.Scanner;

public class StudentImplent {
   Scanner scanner=new Scanner(System.in);
   Connection con=ConnectionJDBC.Connector();
  // get student via JDBC from student table
   public void getAllStudent(){
      String query="SELECT*FROM student";
      try {
         Statement st=con.createStatement();
         ResultSet rs=st.executeQuery(query);
         while (rs.next()){
            System.out.print(rs.getInt("id")+" ");
            System.out.print(rs.getString("name")+" ");
            System.out.print(rs.getFloat("Score")+" ");
             System.out.print(rs.getString("subject")+" ");
             System.out.println(" ");
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
       scanner.nextLine();
       System.out.println("Enter your subject");
       String subject=scanner.nextLine();
      try{
            String query="INSERT INTO student(ID,name,Score,subject)" +
                  " VALUES(?,?,?,?)";
               PreparedStatement pt = con.prepareStatement(query);
               pt.setInt(1,id);
               pt.setString(2,name);
               pt.setFloat(3,score);
               pt.setString(4,subject);
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
    //delete student's info by id
    public  void deletedById(int id){
       String sql="DELETE FROM student WHERE id= ?";
        try{
           PreparedStatement pt= con.prepareStatement(sql);
           pt.setInt(1,id);
           pt.executeUpdate();
        }catch (Exception e){
            System.out.println("something went wrong");
        }
    }
    //update student's info by id
    public  void updateById(){
        System.out.println("Enter to id to update");
        int id=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter updated name: ");
        String name=scanner.nextLine();
        System.out.println("Enter updated Score: ");
        float score=scanner.nextFloat();
       String sql="UPDATE student SET name=?,Score=? WHERE id=?";
       try{
           PreparedStatement pt=con.prepareStatement(sql);
           pt.setString(1,name);
           pt.setFloat(2,score);
           pt.setInt(3,id);
          if(pt.executeUpdate()==1){
              System.out.println(" Have updated student's info successfully!");
          }else
              System.out.println("id:"+id+" does not exist in our System!");

       }catch (Exception e){
           System.out.println("something went wrong!!!!");
       }
    }
}

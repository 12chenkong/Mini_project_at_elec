import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
//this is student class
public class Student {
    public static void main (String[]args){
                Scanner scanner = new Scanner(System.in);
                int op;
                  Connection con=ConnectionJDBC.Connector();
                  StudentImplent stu=new StudentImplent();
                  stu.insertStudent();
                  /*
                do {
                    System.out.println("1.SELECT");
                    System.out.println("2.INSERT");
                    System.out.println("3.Search BY ID");
                    System.out.println("4.Search BY NAME");
                    System.out.println("5.UPDATE BY ID:");
                    System.out.println("6.DELETE BY id: ");
                    System.out.println("7.SORT BY ID DESC");
                    System.out.println("8.SORT BY NAME Z-A");
                    System.out.println("Please chose one of them:");
                    op = scanner.nextInt();
                    switch (op) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        case 6:break;
                        case 7:
                            break;
                        default:
                            System.out.println("Invalid input please try again ");
                    }

                } while (true);




                   */

            }
        }

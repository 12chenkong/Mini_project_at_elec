import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
//this is student class
public class Student {
    public static void main (String[]args){
                Scanner scanner = new Scanner(System.in);
                int op;
                   ConnectionJDBC.connection();
                do {
                    System.out.println("1.INSERT");
                    System.out.println("2.SELECT");
                    System.out.println("3.INSERT BY ID");
                    System.out.println("4.INSERT BY NAME");
                    System.out.println("5.UPDATE BY ID:");
                    System.out.println("6.DELETE BY id: ");
                    System.out.println("7.SORT BY ID DESC");
                    System.out.println("8.SORT BY NAME A-Z");
                    System.out.println("Please chose one of them:");
                    op = scanner.nextInt();
                    switch (op) {
                        case 1 -> System.out.println("sdf");
                    }

                } while (true);
            }
        }

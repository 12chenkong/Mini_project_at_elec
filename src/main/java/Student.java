import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
//this is student class
public class Student {
    public static void main (String[]args){
                Scanner scanner = new Scanner(System.in);
                int op,outerOp;
                  Connection con=ConnectionJDBC.Connector();
                    BookImplement book=new BookImplement();
                    GetALLBookStudent obj=new GetALLBookStudent();
                    do {
                        System.out.println("1.Student section");
                        System.out.println("2.Book section");
                        System.out.println("3.Exit the program!");
                        System.out.println("Choose one of them above!");
                        outerOp=scanner.nextInt();

                        switch (outerOp){
                            case 1:{
                                // these lines of code for student section
                                StudentImplent stu=new StudentImplent();
                                do {
                                    System.out.println("1.SELECT");
                                    System.out.println("2.INSERT");
                                    System.out.println("3.Search BY ID");
                                    System.out.println("4.Search BY NAME");
                                    System.out.println("5.UPDATE BY ID:");
                                    System.out.println("6.DELETE BY id: ");
                                    System.out.println("7.SORT BY ID DESC");
                                    System.out.println("8.SORT BY NAME Z-A");
                                    System.out.println("9.go back to main menu");
                                    System.out.println("Please chose one of them:");
                                    op = scanner.nextInt();
                                    switch (op) {
                                        case 1:
                                            stu.getAllStudent();
                                            break;
                                        case 2:
                                            stu.insertStudent();
                                            break;
                                        case 3:
                                            System.out.println("Enter id to search student's info");
                                            int searchId=scanner.nextInt();
                                            stu.getStudentByid(searchId);
                                            break;
                                        case 4:
                                            System.out.println("enter name to search");
                                            scanner.nextLine();
                                            String name=scanner.nextLine();
                                            stu.getstudentByName(name);
                                            break;
                                        case 5:
                                            stu.updateById();
                                            break;
                                        case 6:
                                            System.out.println("Enter id to delete");
                                            int deletedId=scanner.nextInt();
                                            stu.deletedById(deletedId);
                                            break;
                                        case 7:
                                            stu.sortedId();
                                            break;
                                        case 8:
                                            stu.sortedByName();
                                            break;


                                    }

                                } while(op!=9);

                            }
                            break;
                            case 2:{
                                int innerOp;
                                System.out.println("This is book section!!");
                                do {
                                    System.out.println("1.View all books");
                                    System.out.println("2.Add new to to list");
                                    System.out.println("3.Your cart");
                                    System.out.println("4.go back to main manu");
                                    System.out.println("Choose one of them");
                                    innerOp=scanner.nextInt();
                                    switch (innerOp){
                                        case 1:
                                            book.getAllBooks();
                                        break;
                                        case 2:
                                            book.insertBook();
                                        break;
                                        case 3:
                                            System.out.println("Here what you have bought");
                                            GetALLBookStudent getALLBookStudent=new GetALLBookStudent();
                                            getALLBookStudent.getBookStudentInfo();
                                            break;
                                    }
                                }while (innerOp!=4);


                            }
                            break;

                        }
                    }while (outerOp!=3);



            }
        }

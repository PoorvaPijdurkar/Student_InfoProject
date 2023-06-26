import java.sql.*;
import java.util.Scanner;

public class PerformOperations {

    public void selectData() {
        try {
            Connection conn = new DatabaseConnection().getConn();
            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Student");

            while (rs.next()) {
                int id = rs.getInt("Stud_rollNo");
                String name = rs.getString("Stud_name");
                String email = rs.getString("Stud_email");
                String gender = rs.getString("Stud_gender");

                System.out.println("id : " + id);
                System.out.println("Name : " + name);
                System.out.println("email : " + email);
                System.out.println("gender : " + gender);
                System.out.println("-------------------------------");
            }

            // Close the connection
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new SelectOperations().SelectOperations();
    }

    public void insertData() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please Enter RollNo: ");
        int rollNo = sc.nextInt();

        System.out.print("Please Enter Name : ");
        String name = sc.next();

        System.out.print("Please Enter Email : ");
        String email = sc.next();

        System.out.print("Please Enter Gender : ");
        String gender = sc.next();

        try {
            Connection conn = new DatabaseConnection().getConn();

            // Prepare an SQL INSERT statement
            String sql = "INSERT INTO Student (Stud_rollNo, Stud_name, Stud_email, Stud_gender) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, rollNo);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, gender);

            // Execute the prepared statement
            int rowsAffected = ps.executeUpdate();
            System.out.println("Data inserted successfully");

            // Close the connection
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Exception Occured While inserting data : " + e);
        }
        new SelectOperations().SelectOperations();
    }

    public void deleteData(){
        System.out.print("Enter roll_no for perform delete operation : ");
        Scanner sc = new Scanner(System.in);
        int rollNo = sc.nextInt();
        try {
            Connection conn = new DatabaseConnection().getConn();

            // Prepare an SQL DELETE statement
            String sql ="delete from Student where Stud_rollNo = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,rollNo);

            // Execute the prepared statement
            int rowsAffected = ps.executeUpdate();
            System.out.println("Data deleted successfully");

            // Close the connection
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Exception Occured While deleting data : " + e);
        }
        new SelectOperations().SelectOperations();
    }
    public void updateData() {
        System.out.print("Enter roll_no for performing the update operation: ");
        Scanner sc = new Scanner(System.in);
        int rollno = sc.nextInt();
        try {
            Connection conn = new DatabaseConnection().getConn();
            System.out.println("please choose what you want to update :");

            System.out.println("1: Name");
            System.out.println("2: Email");
            System.out.println("3: Gender");
            System.out.println("4: Entire Data");
            System.out.println("----------------------");
            //taking user choice
            System.out.print("Enter your choice : ");

            int userChoice = sc.nextInt();

            String sql;
            PreparedStatement ps=null;
            switch (userChoice) {
                case 1:
                    System.out.print("Enter Name which you want to update : ");
                    String name = sc.next();

                    sql = "update student set stud_name = ? where stud_rollno = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, name);
                    ps.setInt(2, rollno);
                    break;

                case 2:
                    System.out.print("Enter Email which you want to update : ");
                    String email = sc.next();

                    sql = "update Student set Stud_email = ? where stud_rollno = ? ";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1,email);
                    ps.setInt(2,rollno);
                    break;

                case 3:
                    System.out.print("Enter Email which you want to update : ");
                    String gender = sc.next();

                    sql = "update Student set Stud_gender = ? where stud_rollno = ? ";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1,gender);
                    ps.setInt(2,rollno);
                    break;

                case 4:
                    System.out.print("Enter Name which you want to update : ");
                    String name1 = sc.next();

                    System.out.print("Enter Email which you want to update : ");
                    String email1 = sc.next();

                    System.out.print("Enter Gender which you want to update : ");
                    String gender1 = sc.next();

                    sql = "update Student set stud_name =? ,stud_email= ? ,Stud_gender = ? where stud_rollNo= ? ";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1,name1);
                    ps.setString(2,email1);
                    ps.setString(3,gender1);
                    ps.setInt(4,rollno);
                    break;


            }
            int row = ps.executeUpdate();
            System.out.println("Data Successfully Updated");


//            PreparedStatement ps = conn.prepareStatement(sql);





        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    }



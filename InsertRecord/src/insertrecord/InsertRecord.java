package insertrecord;
import java.sql.*;
import java.util.Scanner;

public class InsertRecord {
    static String url = "jdbc:derby://localhost:1527/sample";
    static String uid = "app";
    static String pwd = "app";
    static Connection con;
    static PreparedStatement ps;

    static int id;
    static String name;
    static long mobinum;
    static String query;

    public static void main(String[] args) {
        int n = 0;
        Scanner scn = new Scanner(System.in);
        try {
            System.out.print("Connecting to database\n");
            con = DriverManager.getConnection(url, uid, pwd);
            System.out.print("Connected\n");

            System.out.print("Enter id, name, mobile number: \n");
            id = scn.nextInt();
            name = scn.next();
            mobinum = scn.nextLong();

            // Set the query string before preparing the statement
            query = "insert into usertable values(?,?,?)";
            ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setLong(3, mobinum);

            n = ps.executeUpdate();

            if (n != 0) {
                System.out.println("1 Record Inserted\n");
            } else {
                System.out.println("Unable to insert record\n");
            }
            
            con.commit();
            con.close();
        } catch (SQLException e) {
            System.out.println("Exception " + e.toString());
        }
    }
}

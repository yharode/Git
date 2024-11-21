package updaterecord;
import java.sql.*;
import java.util.Scanner;

public class UpdateRecord {
    static String url="jdbc:derby://localhost:1527/sample";
    static String uid="app";
    static String pwd="app";
    static Connection con;
    static PreparedStatement ps;
    
    static int id;
    static String name;
    static long mobinum;
    static String query;
    
    public static void main(String[] args) {
        int n=0;
        try{
        System.out.print("Connecting to database\n");
        con=DriverManager.getConnection(url,uid,pwd);
        System.out.print("Connected\n");
        
        System.out.print("Enter id of user and mobile No. you want to update \n");
        Scanner scn=new Scanner(System.in);
        id=scn.nextInt();
        mobinum=scn.nextLong();
        
        query="Update usertable set mobinum=? where id=?";
        ps=con.prepareStatement(query);
        ps.setLong(1,mobinum);
        ps.setInt(2, id);
        
        n=ps.executeUpdate();
        if(n!=0)
            System.out.print("1 record updated\n");
        else{
            System.out.print("No record updated");
            con.close();
            ps.close();
        }
        }
        catch(SQLException e){
            System.out.print("Exception "+e.toString());
        }
    }
    
}

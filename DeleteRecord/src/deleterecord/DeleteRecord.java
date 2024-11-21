package deleterecord;
import java.sql.*;
import java.util.Scanner;

public class DeleteRecord {
    static String url="jdbc:derby://localhost:1527/sample";
    static String uid="app";
    static String pwd="app";
    static Connection con;
    static PreparedStatement ps;
    
    //variable used for DB
    static int id;
    static String name;
    static long mobinum;
    static String query;
    
    public static void main(String[] args) {
        int n=0;
        try{
            System.out.print("Connecting to database.\n");
            con=DriverManager.getConnection(url,uid,pwd);
            System.out.print("Connected\n");
            
            System.out.print("Enter id to delete a record\n");
            Scanner scn=new Scanner(System.in);
            id=scn.nextInt();
            
            query="delete from usertable where id=?";
            ps=con.prepareStatement(query);
            ps.setInt(1,id);
            n=ps.executeUpdate();
            if(n>0)
                System.out.print("1 record deleted successsfully\n");
            else
                System.out.print("No record Deleted\n");
            con.commit();
            ps.close();
            con.close();        
        }
        catch(SQLException e){
            System.out.print("Exception "+e.toString());
        }
    }
}

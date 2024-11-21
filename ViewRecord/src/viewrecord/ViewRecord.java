package viewrecord;
import java.sql.*;
import java.util.Scanner;

public class ViewRecord {
    static String url="jdbc:derby://localhost:1527/sample";
    static String uid="app";
    static String pwd="app";
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    
    static int id;
    static String name;
    static long mobinum;
    static String query;
    
    public static void main(String[] args) {
        
        try{
            System.out.print("Connecting to database\n");
            con=DriverManager.getConnection(url,uid,pwd);
            System.out.print("Connected\n");
            
            query="select * from usertable";
            ps=con.prepareStatement(query);
            rs=ps.executeQuery();
            
            while(rs.next())
                System.out.print("Id : "+rs.getInt("id")+" Name : "+rs.getString("name")+" Mobile No. : "+rs.getLong("mobinum")+"\n");
          
            con.close();
        }
        catch(SQLException e){
            System.out.print("Exception "+e.toString());
        }
    }
    
}

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author lenovo
 */
public class View extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        String url="jdbc:derby://localhost:1527/sample";
        String uid="app";
        String pwd="app";
        String query="select * from Book";
        int n=0;
        
        try {
            PrintWriter out = response.getWriter();
            Connection con=DriverManager.getConnection(url,uid,pwd);
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            
            out.print("<h1>BOOK DETAILS</h1>"); 
            out.print("<table border=1><tr><th>S.NO</th><th>BOOK_ID</th><th>BOOK_NAME</th><th>PRICE</th></tr>");

    while(rs.next())
    {
                out.print("<tr><td>"+n+"</td><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getDouble(3)+"</td></tr>");
        n++;
    }
out.print("</table>");

        }
        catch(SQLException e){
            out.println(e);
        }
    }

}

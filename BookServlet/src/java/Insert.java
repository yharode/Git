import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class Insert extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");

        String url = "jdbc:derby://localhost:1527/sample";
        String uid = "app";
        String pwd = "app";
        String query = "insert into book values(?,?,?)";

        try {
            PrintWriter out = res.getWriter();
            Connection con = DriverManager.getConnection(url, uid, pwd);
            PreparedStatement ps = con.prepareStatement(query);

            int bookId = Integer.parseInt(req.getParameter("bid"));
            String bookName = req.getParameter("bname");
            double bookPrice = Double.parseDouble(req.getParameter("bprice"));

            ps.setInt(1, bookId);
            ps.setString(2, bookName);
            ps.setDouble(3, bookPrice);

            int n = ps.executeUpdate();
            if (n == 1) {
                out.print("1 Record Inserted<br><br>");
                out.print("<a href=\"index.html\">Go to home</a>");
            } else {
                out.print("Insertion Failed");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Exception: " + e);
        }
    }
}

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.sql.DriverManager.getConnection;


/**
 * Created by Uzver on 11.02.2019.
 */
@WebServlet("/webapp")
public class TestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        PrintWriter pw = resp.getWriter();
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));

        String userName = "root";
        String pass = "root";

        String connectionURL = "jdbc:mysql://localhost:3306/myweb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try {Class.forName("com.mysql.cj.jdbc.Driver");}
        catch (ClassNotFoundException e) {e.printStackTrace();
        pw.print(e);}
        try (Connection conn = DriverManager.getConnection(connectionURL, userName, pass);
             Statement statement = conn.createStatement()   ) {


            int i = statement.executeUpdate("INSERT INTO users VALUES ('" + name + "','" + age + "')");
           if (i > 0)
                pw.println("Insert Successfull");
            else
                pw.println("Insert Unsuccessfull");
        } catch (SQLException e) {
            e.printStackTrace();
            pw.print(e);
        }

    }

}

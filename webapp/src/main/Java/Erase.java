import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Uzver on 01.03.2019.
 */
@WebServlet("/erase")
public class Erase extends HttpServlet {


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter pw = resp.getWriter();
        String userName = "root";
        String pass = "root";
        String connectionURL = "jdbc:mysql://localhost:3306/myweb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(connectionURL, userName, pass);
             Statement statement = conn.createStatement()) {
            statement.executeUpdate("DELETE FROM users");
            pw.print("Data successfull eresed");
        } catch (SQLException e) {
            e.printStackTrace();
            pw.print(e);
        }
    }}

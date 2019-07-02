package source.testJDBC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.*;

/**
Servlet implementation class TestJDBCServlet
 */
@WebServlet("/testJDBCServlet")
public class TestJDBCServlet extends HttpServlet {

    private static final long serialVersionUID=1L;

    /**
     Servlet implementation class TestJDBCServlet
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        String url="jdbc:mysql://localhost:3306/customers?useSSL=false&serverTimezone=UTC";
        String userName="root";
        String password="1";
        String driver="com.mysql.jdbc.Driver";

        try{
            PrintWriter pw = response.getWriter();
            pw.println("Connection to database: "+url);
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url,userName,password);
            pw.println("Connection successful");

            connection.close();
        }
        catch (Exception exp){
            exp.printStackTrace();
            throw new ServletException(exp);
        }
    }
}

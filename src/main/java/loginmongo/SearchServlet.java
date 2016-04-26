package loginmongo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by hsenid on 4/26/16.
 */
public class SearchServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,HttpServletResponse response){
        String searchName = request.getParameter("form-searchname");
        try {
        Class.forName("com.mysql.jdbc.Driver");

        //creating connection with the database
        Connection con= DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/login_form", "username","fname");


            PreparedStatement ps=con.prepareStatement
                    ("SELECT * FROM TranslateUsers WHERE firstname=searchName");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

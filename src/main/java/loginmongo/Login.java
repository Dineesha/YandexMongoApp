package loginmongo;

/**
 * Created by hsenid on 3/14/16.
 */

import com.mongodb.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.Parameters;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.UnknownHostException;

public class Login extends HttpServlet {
    final static Logger logger = Logger.getLogger(HttpClientCall.class);

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws UnknownHostException {
        BasicConfigurator.configure();
        response.setContentType("text/html");

        String username = request.getParameter("form-username"); // get the name entered by user's input
        String password = request.getParameter("form-password"); //get the password entered by user's input

     
        MongoClient mongo = new MongoClient("localhost", 27017);
       // DB db = mongo.getDB("logindata");
       // DBCollection table = db.getCollection("userinfo");
        DB db = mongo.getDB("login_form");
        DBCollection table = db.getCollection("test_user1");
        /**** Find and display ****/
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("username", username);
        searchQuery.put("password", password);

            DBCursor cursor = table.find(searchQuery);

            if (cursor.hasNext()) {


                try {
                    response.sendRedirect("success.jsp?name=" + username);
                } catch (IOException e) {
                    String er1=e.getMessage();
                    logger.error("Exception thrown  :\" + e");
                    logger.trace("exception :\" +er1");
                }

            } else {
                request.setAttribute("errorMessage", "Invalid username or password");
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                try {
                    rd.include(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();  String er1=e.getMessage();
                    logger.error("Exception thrown  :\" + e");
                    logger.trace("exception :\" +er1");
                } catch (IOException e) {
                    String er1=e.getMessage();
                    logger.error("Exception thrown  :\" + e");
                    logger.trace("exception :\" +er1");
                }
            }



        }
    }



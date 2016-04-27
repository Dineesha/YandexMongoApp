package loginmongo;

import com.mongodb.*;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Set;


/**
 * Created by hsenid on 4/26/16.
 */
public class SearchServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(SearchServlet.class);

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws UnknownHostException {
        String searchName = request.getParameter("form-searchname");
        /*try {
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
        }*/
        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("login_form");
        DBCollection table = db.getCollection("test_user1");

        /**** Find and display ****/
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("fname", searchName);

        DBCursor cursor = table.find(searchQuery);

        if (cursor.hasNext()) {


            try {
                Set<String> BasicDBObject = db.getCollectionNames();

                for (String collectionName : BasicDBObject) {
                   // System.out.println(collectionName);
                    logger.info(collectionName);
                }

                // get a single collection
               // System.out.println(table.toString());
logger.info(table.toString());
                //System.out.println("Done");

                response.sendRedirect("index.jsp?name=");
            } catch (IOException e) {
                String er1 = e.getMessage();
                logger.error("Exception thrown  :\" + e");
                logger.trace("exception :\" +er1");
            }

        } else {
            request.setAttribute("errorMessage", "Invalid username or password");
            RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
            try {
                rd.include(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
                String er1 = e.getMessage();
                logger.error("Exception thrown  :\" + e");
                logger.trace("exception :\" +er1");
            } catch (IOException e) {
                String er1 = e.getMessage();
                logger.error("Exception thrown  :\" + e");
                logger.trace("exception :\" +er1");
            }
        }


    }

}



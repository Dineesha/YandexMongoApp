package loginmongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Created by hsenid on 4/29/16.
 */
public class DeleteServlet extends HttpServlet{
    public void doPost(HttpServletResponse response,HttpServletRequest request) throws IOException, ServletException {
        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("login_form");
        DBCollection table = db.getCollection("test_user1");
       // table.remove(dock);
       /* RequestDispatcher rd = request.getRequestDispatcher("/searchuser.jsp");
        rd.include(request, response);*/


    }

}

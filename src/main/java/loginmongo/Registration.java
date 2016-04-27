package loginmongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by hsenid on 4/25/16.
 */
public class Registration extends HttpServlet {
    final static Logger logger = Logger.getLogger(Registration.class);

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
       // PrintWriter out = response.getWriter();

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String dob = request.getParameter("datepick");
        String phone = request.getParameter("phonenumber");
        String country = request.getParameter("country");
        String username = request.getParameter("uname");
        String password = request.getParameter("password");

        /*try{

            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database
            Connection  con=DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/login_form","username","password");

            PreparedStatement ps=con.prepareStatement
                    ("insert into TranslateUsers values(?,?,?,?,?,?,?,?)");

            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, email);
            ps.setString(4, dob);
            ps.setString(5, phone);
            ps.setString(6, country);
            ps.setString(7, username);
            ps.setString(8, password);
            int i=ps.executeUpdate();

            if(i>0)
            {
                logger.trace("You are sucessfully registered");
            }

        }
        catch(Exception se)
        {
            se.printStackTrace();
            logger.error("data not inserted");
        }
    }*/

        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("login_form");
        DBCollection coll = db.getCollection("test_user1");




        BasicDBObject doc = new BasicDBObject();

        doc.put("fname", fname);
        doc.put("lname", lname);
        doc.put("email", email);
        doc.put("dob", dob);
        doc.put("phone", phone);
        doc.put("country", country);
        doc.put("username", username);
        doc.put("password", password);



        //DBCollection coll = db.createCollection("test_user1", doc);




        coll.insert(doc);


    }
}

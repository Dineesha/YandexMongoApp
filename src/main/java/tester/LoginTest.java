package tester;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import loginmongo.GetApp;
import loginmongo.Login;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.servlet.ServletException;
import java.sql.*;

import static org.testng.Assert.fail;

import com.mongodb.BasicDBObject;
import loginmongo.CreateUser;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.UnknownHostException;

public class LoginTest {
    /* @BeforeTest
     public void createUser() throws UnknownHostException {
         String un = "dinitest";
         String pw = "test";
         CreateUser user1 = new CreateUser();
         user1.setPassword(pw);
         user1.setUsername(un);
         user1.connectToDBForTest();
         LoginTest test = new LoginTest();
        // test.testValidateQuery(un, pw);
     }

     @Test
     public void testValidateQuery() {
         System.out.println("logintest class");

         //DBCollection table = db.getCollection("userinfo");
         BasicDBObject searchQuery = new BasicDBObject();
         searchQuery.put("username", "dinitest");
         searchQuery.put("password", "wrong");
         Assert.assertEquals(searchQuery, false,"password is wrong ");






     }

     @Test
     public void test1() {
         System.out.println("testing errors");
     }

     @AfterTest
     public void destroyUser1(){


     }
      @BeforeMethod
     public void createUsernull(){
         CreateUser user1=new CreateUser();
         user1.setPassword(null);
         user1.setUsername(null);
     }*/
    Login validate = new Login();
    boolean res = false;


    public Object[][] users() {
        return new Object[][]{
                {"abc", "123", true},
                {" ", " ", false},
                {" ", "123", false},
                {"abc", " ", false},
                {"x", "123", false},
                {"abc", "x", false},
                {"ab", "xx", false}
        };

    }

    @BeforeMethod

    public void setConnection() throws UnknownHostException {

        GetApp prop2 = new GetApp();

        String dburl = prop2.getProperty("db.url");
        String database = prop2.getproperty("db.database");
        String dbUname = prop2.getproperty("db.username");
        String dbPasswd = prop2.getproperty("db.password");
        MongoClient mongo = new MongoClient("localhost", 27017);

        /**** Get database ****/

        DB db = mongo.getDB("logindata");

        /**** Get collection / table from 'testdb' ****/

        DBCollection table = db.getCollection("userinfo");

        /**** Insert ****/

           /* BasicDBObject document = new BasicDBObject();
            document.put("username", "dineesha");
            document.put("password", "1234");*/

        String user1 = table.insert(document);


    }
}

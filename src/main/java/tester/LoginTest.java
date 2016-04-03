package tester;

import org.testng.Assert;
import org.testng.annotations.*;

import javax.servlet.ServletException;
import java.sql.*;

import static org.testng.Assert.fail;

/**
 * Created by hsenid on 4/01/16.
 */
public class LoginTest {

    Login validate = new Login();
    boolean res = false;


    
    public Object[][] users() {
        return new Object[][]{
                {"abc", "123", true}, //valid username and password
                {" ", " ", false}, // both username and password empty
                {" ", "123", false}, // empty username, correct password
                {"abc", " ", false}, // correct password, empty username
                {"x", "123", false}, // wrong username, correct password
                {"abc", "x", false}, // correct username, wrong password
                {"ab", "xx", false} // both username and password wrong
        };
      
    }*/

    @BeforeMethod
    /**
     *call db connection
     *insert a user to db
     */
    public void setConnection() {

        GetApp prop2 = new GetApp();

        String dburl = prop2.getproperty("db.url"); 
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

            String user1=table.insert(document);

            

        try {
            PreparedStatement sta = conn.prepareStatement(user1);
            sta.executeUpdate(user1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void userTest(String username, String password, boolean exp) {
        Login validate = new Login();
        try {
            //boolean val = validate.loginValidate(uname, pass);
            Assert.assertEquals(act, exp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }*/

   /* @Test
    public void  validUserPass(){

        try{
            res=validate.loginValidate("abc","123");
        }catch (Exception ex){
            fail();
        }
        Assert.assertEquals(res,true,"Valid username and Valid password");
    }

    @Test
    public void invalidUserPass(){

        try{
            res =validate.loginValidate("aBc","765");
        }catch (Exception ex2){
            fail();
        }
        Assert.assertEquals(res,false,"Invalid username and Invalid password");
    }

    @Test
    public void validUn_InvalidPw(){

        try{
            res=validate.loginValidate("abc","111");
        }catch (Exception ex3){
            fail();
        }
        Assert.assertEquals(res,false,"Valid username but Invalid password");
    }

    @Test
    public void invalidUn_ValidPw(){

        try{
            res= validate.loginValidate("Abc","123");
        }catch (Exception ex4){
            fail();
        }
        Assert.assertEquals(res,false,"Invalid username but Valid password");
    }

    @Test
    public void emptyUn_ValidPw(){

        try{
            res=validate.loginValidate("","123");
        }catch (Exception ex){
            fail();
        }
        Assert.assertEquals(res,false,"Empty username and Valid password");
    }

    @Test
    public void validUn_emptyPw(){

        try{
            res=validate.loginValidate("abc","");
        }catch (Exception ex){
            fail();
        }
        Assert.assertEquals(res,false,"Valid username but Empty password");
    }

    @Test
    public void emptyUn_emptyPw(){

        try{
            res=validate.loginValidate("","");
        }catch (Exception ex){
            fail();
        }
        Assert.assertEquals(res,false,"Empty username and Password");
    }

    @AfterMethod
    /**
     *delete added user
     *connection close
     */
    public void conClose() {
        Connection conn = Database.getConn();

        String sql = "DELETE FROM tbl_user WHERE usrName='abc' AND usrPass=md5('123');";
        if (conn != null) {
            try {
                PreparedStatement sta = conn.prepareStatement(sql);
                sta.executeUpdate(sql);
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }*/
    }
}

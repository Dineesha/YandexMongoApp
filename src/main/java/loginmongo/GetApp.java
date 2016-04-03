package loginmongo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by hsenid on 3/28/16.
 */
public class GetApp {
    public static void main(String[] args) throws IOException {

        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("DB"));
            System.out.println(prop.getProperty("DBCollection"));
            System.out.println(prop.getProperty("username"));
            System.out.println(prop.getProperty("password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

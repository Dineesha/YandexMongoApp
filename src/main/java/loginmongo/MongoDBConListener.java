package loginmongo;

/**
 * Created by hsenid on 3/14/16.
 */
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.UnknownHostException;

public class MongoDBConListener implements ServletContextListener {

    static MongoClient cl = null;
    static DBCollection col = null;

    //@Override
    public void contextInitialized(ServletContextEvent sce) {
        /**
         * establish database connection
         */
        try {
            ServletContext ctx = sce.getServletContext();

            cl = new MongoClient(ctx.getInitParameter("MONGO_HOST"),
                    Integer.parseInt(ctx.getInitParameter("MONGO_PORT")));
            DB db = cl.getDB(ctx.getInitParameter("MONGO_DBNAME"));
            col = db.getCollection(ctx.getInitParameter("MONGO_COLLECTION"));

        } catch (UnknownHostException e) {

            throw new RuntimeException("MongoDBClient initialization failed");
        }
    }

    //@Override
    public void contextDestroyed(ServletContextEvent sce) {
        /**
         * close database connection
         */
        cl = (MongoClient) sce.getServletContext().getAttribute("MONGO_CLIENT");
        cl.close();
    }

}
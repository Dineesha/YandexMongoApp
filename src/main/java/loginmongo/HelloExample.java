package loginmongo;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Created by hsenid on 4/6/16.
 */
public class HelloExample {

    final static Logger logger = Logger.getLogger(HelloExample.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        HelloExample obj = new HelloExample();
        obj.runMe("mkyong");

        logger.trace("Trace Message!");
        logger.debug("Debug Message!");
        logger.info("Info Message!");
        logger.warn("Warn Message!");
        logger.error("Error Message!");
        logger.fatal("Fatal Message!");
    }

    private void runMe(String parameter){

        if(logger.isDebugEnabled()){
            logger.debug("This is debug : " + parameter);
        }

        if(logger.isInfoEnabled()){
            logger.info("This is info : " + parameter);
        }

        logger.warn("This is warn : " + parameter);
        logger.error("This is error : " + parameter);
        logger.fatal("This is fatal : " + parameter);

    }

}

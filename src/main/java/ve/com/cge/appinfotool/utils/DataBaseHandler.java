
package ve.com.cge.appinfotool.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cge
 */
public class DataBaseHandler {
    
    private static final Logger logger = LogManager.getLogger(DataBaseHandler.class);
    
    public String getDbName() {
        String result = "";
        try {
            AppConfig config = new AppConfig();
            result = config.getDBNAME();
        } catch (Exception ex) {
            logger.error("Failed to get DB connection string", ex);
            MessageHandler.Error("ERROR: " + ex, "DataBaseHandler");
        }
        return result;
    }
    
    public Connection conect() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(getDbName());
         } catch (Exception ex) {
            logger.error("Failed to create DB connection", ex);
            MessageHandler.Error("ERROR: " + ex, "DataBaseHandler");
        }
        return con;   
    }
    
}

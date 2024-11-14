
package ve.com.cge.appinfotool.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cge
 */
public class AppConfig {
    
    private static final Logger logger = LogManager.getLogger(AppConfig.class);
    
    private String DBNAME;
    
    public AppConfig() {
        try {
            this.DBNAME = java.util.ResourceBundle.getBundle("app").getString("DBNAME");
        } catch (Exception ex) {
            logger.error("Failed to load App Resource Bundle", ex);
            MessageHandler.Error("ERROR: " + ex, "AppConfig");
        }
    }

    public String getDBNAME() {
        return DBNAME;
    }

}

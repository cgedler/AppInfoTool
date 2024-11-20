
package ve.com.cge.appinfotool.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * AppConfig : This is the class that is used to load the application configuration data.
 * 
 * @author Christopher Gedler <cgedler@gmail.com>
 * @version 1.0
 * @since Nov 19, 2024
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

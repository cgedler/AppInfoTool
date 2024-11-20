
package ve.com.cge.appinfotool.utils;

import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * AppInfo : This is the class that is used to load the basic information data of the application.
 * 
 * @author Christopher Gedler <cgedler@gmail.com>
 * @version 1.0
 * @since Nov 19, 2024
 */
public class AppInfo {
    
    private static final Logger logger = LogManager.getLogger(AppInfo.class);
    
    private String SYSTEM;
    private String VERSION;
    private String DATE;
    private String LOCALE;
    private String COMPANY;
    private String RIF;

    public AppInfo() {
        try {
            this.SYSTEM = ResourceBundle.getBundle("app").getString("SYSTEM");
            this.VERSION = ResourceBundle.getBundle("app").getString("VERSION");
            this.DATE = ResourceBundle.getBundle("app").getString("DATE");
            this.LOCALE = ResourceBundle.getBundle("app").getString("LOCALE");
            this.COMPANY = ResourceBundle.getBundle("app").getString("COMPANY");
            this.RIF = ResourceBundle.getBundle("app").getString("RIF");
        } catch (Exception ex) {
            logger.error("Failed to load App Resource Bundle", ex);
            MessageHandler.Error("ERROR: " + ex, "AppInfo");
        }
    }

    public String getSYSTEM() {
        return SYSTEM;
    }

    public String getVERSION() {
        return VERSION;
    }

    public String getDATE() {
        return DATE;
    }

    public String getLOCALE() {
        return LOCALE;
    }

    public String getCOMPANY() {
        return COMPANY;
    }

    public String getRIF() {
        return RIF;
    }
    
}

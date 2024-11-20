
package ve.com.cge.appinfotool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.swing.UIManager;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import ve.com.cge.appinfotool.utils.AppInfo;
import ve.com.cge.appinfotool.utils.MessageHandler;
import ve.com.cge.appinfotool.views.Login;
import ve.com.cge.appinfotool.views.SplashScreen;

/**
 * AppInfoTool : This is the main class where the application starts.
 * 
 * @author Christopher Gedler <cgedler@gmail.com>
 * @version 1.0
 * @since Nov 19, 2024
 */
public class AppInfoTool {

    private static final Logger logger = LogManager.getLogger(AppInfoTool.class);
    private static final String LOOK = java.util.ResourceBundle.getBundle("app").getString("LOOK");

    public static void main(String[] args) {
        AppInfo app = new AppInfo();
        try {
            IconFontSwing.register(FontAwesome.getIconFont()); 
            /**
             * Select between Look and Feel
             */
            switch (LOOK) {
                case "1":
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                    break;
                case "2":
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    break;
                case "3":
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    break;
                case "4":
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    break;
                case "5":
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                    break;
                case "6":
                    UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
                    break;                    
                default:
                // code block
            }
            SplashScreen splashScreen = new SplashScreen(app);
            splashScreen.show(5000);
            splashScreen.hide();
            Login login = new Login(app);
        } catch (Exception ex) {
            logger.error("Failed to initialize Main App", ex);
            MessageHandler.Error("ERROR: " + ex, "AppInfoTool");
        }
    }
}

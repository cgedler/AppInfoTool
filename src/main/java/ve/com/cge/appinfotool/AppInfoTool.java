/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ve.com.cge.appinfotool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Locale;
import javax.swing.JFrame;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;
import ve.com.cge.appinfotool.utils.AppInfo;
import ve.com.cge.appinfotool.utils.DataBaseHandler;

import ve.com.cge.appinfotool.utils.MessageHandler;
import ve.com.cge.appinfotool.views.Login;
import ve.com.cge.appinfotool.views.SplashScreen;

/**
 *
 * @author cge
 */
public class AppInfoTool {

    private static final Logger logger = LogManager.getLogger(AppInfoTool.class);

    //private static final String LOCALE = java.util.ResourceBundle.getBundle("app").getString("LOCALE");
    

    public static void main(String[] args) {
        AppInfo app = new AppInfo();
        //System.out.println("Hello World!");
        //logger.debug("Hello from Log4j 2");

        //logger.error("Failed to initialize LaF");
        try {
            javax.swing.UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");

            //SplashScreen splashScreen = new SplashScreen(app);
            //splashScreen.show(8000);
            //splashScreen.hide();
            //DataBaseHandler db = new DataBaseHandler();
            //Connection cn = db.conect();
            
            Login login = new Login(app);
            //login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            /*
            String test_passwd = "abcdefghijklmnopqrstuvwxyz";
            String test_hash = "$2a$06$.rCVZVOThsIa97pEDOxvGuRRgzG64bvtJ0938xuqzv18d3ZpQhstC";

            System.out.println("Testing BCrypt Password hashing and verification");
            System.out.println("Test password: " + test_passwd);
            System.out.println("Test stored hash: " + test_hash);
            System.out.println("Hashing test password...");
            System.out.println();

            String computed_hash = hashPassword(test_passwd);
            System.out.println("Test computed hash: " + computed_hash);
            System.out.println();
            System.out.println("Verifying that hash and stored hash both match for the test password...");
            System.out.println();

            String compare_test = checkPassword(test_passwd, test_hash)
                    ? "Passwords Match" : "Passwords do not match";
            String compare_computed = checkPassword(test_passwd, computed_hash)
                    ? "Passwords Match" : "Passwords do not match";

            System.out.println("Verify against stored hash:   " + compare_test);
            System.out.println("Verify against computed hash: " + compare_computed);
            
            */

            //MessageHandler.Info("Mensaje", "Titulo");
            //Locale aLocale = Locale.getDefault(); // obtengo el valor locale del sistema operativo, con este valor puedo configurar mi aplicacion
            //System.out.println(aLocale.toString());
            //String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            //String appConfigPath = rootPath + "app.properties";
            //System.out.println(rootPath);
            //System.out.println(appConfigPath);
            //System.out.println(java.util.ResourceBundle.getBundle("resources/" + LOCALE).getString("HOLA"));
            //System.out.println(app.getCOMPANY());
            //java.awt.EventQueue.invokeLater(new Runnable() {
            //    public void run() {
            //        new Antenna().setVisible(true);
            //    }
            //});
        } catch (Exception ex) {
            logger.error("Failed to initialize Main App", ex);
            MessageHandler.Error("ERROR: " + ex, "AppInfoTool");
        }/* catch (ClassNotFoundException ex) {
            logger.error("Failed to initialize LaF {}", ex);
            MessageHandler.Error("ERROR: " + ex, "AppInfoTool");
        } catch (InstantiationException ex) {
            logger.error("Failed to initialize LaF {}", ex);
            MessageHandler.Error("ERROR: " + ex, "AppInfoTool");
        } catch (IllegalAccessException ex) {
            logger.error("Failed to initialize LaF {}", ex);
            MessageHandler.Error("ERROR: " + ex, "AppInfoTool");
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            logger.error("Failed to initialize LaF {}", ex);
            MessageHandler.Error("ERROR: " + ex, "AppInfoTool");
        }*/
        //System.exit(0);
    }
}

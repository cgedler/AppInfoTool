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
import javax.swing.UIManager;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
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
    private static final String LOOK = java.util.ResourceBundle.getBundle("app").getString("LOOK");

    //private static final String LOCALE = java.util.ResourceBundle.getBundle("app").getString("LOCALE");
    public static void main(String[] args) {
        AppInfo app = new AppInfo();
        //System.out.println("Hello World!");
        //logger.debug("Hello from Log4j 2");

        //logger.error("Failed to initialize LaF");
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
          
   
            //
            //SplashScreen splashScreen = new SplashScreen(app);
            //splashScreen.show(8000);
            //splashScreen.hide();

            Login login = new Login(app);


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


package ve.com.cge.appinfotool.utils;

import javax.swing.Icon;
import javax.swing.JOptionPane;

/**
 *
 * @author cge
 */
public class MessageHandler {
    
    public static void Info(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void Warning(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
    }
    
    public static void Error(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }
    
}

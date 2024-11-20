
package ve.com.cge.appinfotool.controllers;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ve.com.cge.appinfotool.views.About;
import ve.com.cge.appinfotool.views.MDIApp;

/**
 * AboutAction : This is the action class that calls the about window.
 * 
 * @author Christopher Gedler <cgedler@gmail.com>
 * @version 1.0
 * @since Nov 19, 2024
 */
public class AboutAction extends AbstractAction {
    
    private static final Logger logger = LogManager.getLogger(AboutAction.class);

    private MDIApp mdiApp;
    
    public AboutAction(MDIApp mdiApp) {
        this.mdiApp = mdiApp;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            About about = new About(this.mdiApp.appInfo);
        } catch (Exception ex) {
            logger.error("Failed to load About window", ex);
        }
    }
    
}

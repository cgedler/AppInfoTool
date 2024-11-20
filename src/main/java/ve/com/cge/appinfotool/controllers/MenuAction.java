
package ve.com.cge.appinfotool.controllers;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import ve.com.cge.appinfotool.views.MDIApp;

/**
 * MenuAction : This is the action class that updates the menu list by group code.
 * 
 * @author Christopher Gedler <cgedler@gmail.com>
 * @version 1.0
 * @since Nov 19, 2024
 */
public class MenuAction extends AbstractAction {
    
    private String code;
    private MDIApp mdiApp;

    public MenuAction(String code, MDIApp app) {
        this.code = code;
        this.mdiApp = app;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.mdiApp.updateList(this.code);
    }
    
}

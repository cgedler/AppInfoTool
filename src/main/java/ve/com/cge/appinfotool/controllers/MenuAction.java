
package ve.com.cge.appinfotool.controllers;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import ve.com.cge.appinfotool.views.MDIApp;

/**
 *
 * @author cge
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

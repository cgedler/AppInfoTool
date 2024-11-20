
package ve.com.cge.appinfotool.controllers;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 * ExitAction : This is the action class that closes the application.
 * 
 * @author Christopher Gedler <cgedler@gmail.com>
 * @version 1.0
 * @since Nov 19, 2024
 */
public class ExitAction extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    
}

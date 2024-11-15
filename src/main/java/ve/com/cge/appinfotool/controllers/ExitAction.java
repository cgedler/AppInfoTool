
package ve.com.cge.appinfotool.controllers;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author cge
 */
public class ExitAction extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    
}

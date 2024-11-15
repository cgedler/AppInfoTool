
package ve.com.cge.appinfotool.controllers;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author cge
 */
public class MenuAction extends AbstractAction {
    
    private String code;

    public MenuAction(String code) {
        this.code = code;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

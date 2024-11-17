
package ve.com.cge.appinfotool.controllers;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ve.com.cge.appinfotool.models.User;
import ve.com.cge.appinfotool.services.UserService;
import ve.com.cge.appinfotool.utils.PasswordHandler;
import ve.com.cge.appinfotool.views.Login;
import ve.com.cge.appinfotool.views.MDIApp;

/**
 *
 * @author cge
 */
public class LoginAction extends AbstractAction {
    
    private static final Logger logger = LogManager.getLogger(LoginAction.class);
    
    private String username;
    private String pwd;
    
    private Login login;


    public LoginAction(Login login) {
        this.login = login;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        User userDB = new User();
        userDB = UserService.getUserByUsername(this.login.getCmbUsers());
        if (PasswordHandler.checkPassword(this.login.getPwd(), userDB.getPassword())) {
            
            
        } else {
            
        }
        
        MDIApp app = new MDIApp(this.login.appInfo);
        
        this.login.close();

        //System.out.println("Boton pressed " + this.login.getCmbUsers() + " - " + this.login.getPwd());

    }
    
    
    
    
    
    
}

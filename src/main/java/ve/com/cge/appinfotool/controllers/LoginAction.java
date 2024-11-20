
package ve.com.cge.appinfotool.controllers;

import java.awt.event.ActionEvent;
import java.util.ResourceBundle;
import javax.swing.AbstractAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ve.com.cge.appinfotool.models.User;
import ve.com.cge.appinfotool.services.UserService;
import ve.com.cge.appinfotool.utils.MessageHandler;
import ve.com.cge.appinfotool.utils.PasswordHandler;
import ve.com.cge.appinfotool.views.Login;
import ve.com.cge.appinfotool.views.MDIApp;

/**
 * LoginAction : This is the action class that login into the application by validating the hash password.
 * 
 * @author Christopher Gedler <cgedler@gmail.com>
 * @version 1.0
 * @since Nov 19, 2024
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
            MDIApp app = new MDIApp(this.login.appInfo);
            this.login.close();
        } else {
            logger.info("Invalid hash provided for comparison");
            MessageHandler.Error(ResourceBundle.getBundle(this.login.appInfo.getLOCALE()).getString("PWDCHECK"), "Login");
        }
    }

}

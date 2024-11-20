package ve.com.cge.appinfotool.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ve.com.cge.appinfotool.controllers.ExitAction;
import ve.com.cge.appinfotool.controllers.LoginAction;
import ve.com.cge.appinfotool.models.User;
import ve.com.cge.appinfotool.services.UserService;
import ve.com.cge.appinfotool.utils.AppInfo;
import ve.com.cge.appinfotool.utils.MessageHandler;

/**
 * Login : This is the login screen class
 * 
 * @author Christopher Gedler <cgedler@gmail.com>
 * @version 1.0
 * @since Nov 19, 2024
 */
public class Login extends JFrame {
    
    private static final Logger logger = LogManager.getLogger(Login.class);
    
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JComboBox cmbUsers;
    private JPasswordField pwd;
    private JButton btnOk;
    private JButton btnCancel;
    public AppInfo appInfo;

    public Login(AppInfo appInfo) {
        this.appInfo = appInfo;
        initComponents();
    }

    private void initComponents() {
        lblUsername = new JLabel();
        lblPassword = new JLabel();
        cmbUsers = new JComboBox();
        pwd = new JPasswordField(15);
        btnOk = new JButton();
        btnCancel = new JButton();
        
        List<User> users = new ArrayList<User>();
        users = UserService.getUsers();
        for (User user : users) {
            cmbUsers.addItem(user.getUsername());
        }

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        
        ImageIcon icoLogin = new ImageIcon(this.getClass().getClassLoader().getResource("image/cryptography.png"));
        Icon icoUser = IconFontSwing.buildIcon(FontAwesome.USER_CIRCLE_O, 15, new Color(219, 20, 186));
        Icon icoPwd = IconFontSwing.buildIcon(FontAwesome.KEY, 15, new Color(219, 20, 186));
        Icon icoOk = IconFontSwing.buildIcon(FontAwesome.CHECK, 15, new Color(20, 219, 30));
        Icon icoCancel = IconFontSwing.buildIcon(FontAwesome.TIMES, 15, new Color(219, 113, 20));

        JPanel panMain = new JPanel();
        JPanel panLblUsername = new JPanel();
        JPanel panLblPwd = new JPanel();
        JPanel panCmbUsers = new JPanel();
        JPanel panPwd = new JPanel();
        JPanel panBtnOk = new JPanel();
        JPanel panBtnCancel = new JPanel();

        lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUsername.setIcon(icoUser);
        lblUsername.setText(ResourceBundle.getBundle(appInfo.getLOCALE()).getString("USERNAME"));
        //lblUsername.setBounds(10, 10, 80, 25);
        lblPassword.setIcon(icoPwd);
        lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPassword.setText(ResourceBundle.getBundle(appInfo.getLOCALE()).getString("PASSWORD"));
        btnOk.setIcon(icoOk);
        btnOk.setText(ResourceBundle.getBundle(appInfo.getLOCALE()).getString("BTNOK"));
        btnOk.addActionListener(new LoginAction(this));
        btnCancel.setIcon(icoCancel);
        btnCancel.setText(ResourceBundle.getBundle(appInfo.getLOCALE()).getString("BTNCANCEL"));
        btnCancel.addActionListener(new ExitAction());

        panMain.setLayout(new GridLayout(3, 2));
        panLblUsername.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panLblPwd.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panCmbUsers.setLayout(new FlowLayout(FlowLayout.LEFT));
        panPwd.setLayout(new FlowLayout(FlowLayout.LEFT));
        panBtnOk.setLayout(new FlowLayout(FlowLayout.CENTER));
        panBtnCancel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panLblUsername.add(lblUsername);
        panLblPwd.add(lblPassword);
        panCmbUsers.add(cmbUsers);
        panPwd.add(pwd);
        panBtnOk.add(btnOk);
        panBtnCancel.add(btnCancel);        
        panMain.add(panLblUsername);
        panMain.add(panCmbUsers);
        panMain.add(panLblPwd);
        panMain.add(panPwd);
        panMain.add(panBtnOk); 
        panMain.add(panBtnCancel);

        setContentPane(panMain);
        setTitle("Login");
        setBounds(((int) dimension.getWidth() / 2), ((int) dimension.getHeight() / 2), 400, 130);
        setResizable(false);
        setIconImage(icoLogin.getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Check----
        setVisible(true);
    }
    
    public String getCmbUsers() {
        String value = "";
        try {
            if (cmbUsers != null) {
                value = (String) cmbUsers.getSelectedItem();
            }
        } catch (NullPointerException ex) {
            logger.error("", ex);
            MessageHandler.Error(ResourceBundle.getBundle(appInfo.getLOCALE()).getString("GETUSER") + " " + ex, "Login");
        }
        return value;
    }

    public String getPwd() {
        String value = "";
        if(pwd.getPassword().length != 0) {
            value = String.valueOf(pwd.getPassword());
        } else {
            MessageHandler.Error(ResourceBundle.getBundle(appInfo.getLOCALE()).getString("GETPWD"), "Login");
        }
        return value;
    }
    
    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

}

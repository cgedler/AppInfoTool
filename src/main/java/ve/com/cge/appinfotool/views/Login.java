
package ve.com.cge.appinfotool.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ResourceBundle;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ve.com.cge.appinfotool.utils.AppInfo;
import ve.com.cge.appinfotool.utils.MessageHandler;

/**
 *
 * @author cge
 */
public class Login extends JFrame {
    
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JComboBox cmbUsers;
    private JPasswordField pwd;
    private JButton btnOk;
    private JButton btnCancel;
    
    private AppInfo appInfo;
    
    
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
        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        IconFontSwing.register(FontAwesome.getIconFont());
        Icon icoUser = IconFontSwing.buildIcon(FontAwesome.USER_CIRCLE_O, 15, new Color(219, 20, 186));
        Icon icoPwd = IconFontSwing.buildIcon(FontAwesome.KEY, 15, new Color(219, 20, 186));
        Icon icoOk = IconFontSwing.buildIcon(FontAwesome.CHECK, 15, new Color(20, 219, 30));
        Icon icoCancel = IconFontSwing.buildIcon(FontAwesome.TIMES, 15, new Color(219, 113, 20));
        
        JPanel panMain = new JPanel();
        JPanel panLeft = new JPanel();
        JPanel panRight = new JPanel();
        JPanel panBtnOk = new JPanel();
        JPanel panBtnCancel = new JPanel();
                
        lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUsername.setIcon(icoUser);
        lblUsername.setText(ResourceBundle.getBundle(appInfo.getLOCALE()).getString("USERNAME"));
        lblPassword.setIcon(icoPwd);
        lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPassword.setText(ResourceBundle.getBundle(appInfo.getLOCALE()).getString("PASSWORD"));
        btnOk.setIcon(icoOk);
        btnOk.setText(ResourceBundle.getBundle(appInfo.getLOCALE()).getString("BTNOK"));
 
        btnCancel.setIcon(icoCancel);
        btnCancel.setText(ResourceBundle.getBundle(appInfo.getLOCALE()).getString("BTNCANCEL"));
        
        
        panMain.setLayout(new GridLayout(2, 2));
        panLeft.setLayout(new GridLayout(2, 1));
        panRight.setLayout(new GridLayout(2, 1));
        panBtnOk.setLayout(new FlowLayout(FlowLayout.CENTER));
        panBtnCancel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panLeft.add(lblUsername);
        panLeft.add(lblPassword);
        panRight.add(cmbUsers);
        panRight.add(pwd);
        panMain.add(panLeft);
        panMain.add(panRight);
        panBtnOk.add(btnOk);
        panMain.add(panBtnOk);
        panBtnCancel.add(btnCancel);
        panMain.add(panBtnCancel);
        
        setContentPane(panMain);
        setTitle("Login");
        setBounds(((int)dimension.getWidth()/2), ((int)dimension.getHeight()/2), 400, 130);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }
    
}


package ve.com.cge.appinfotool.views;


import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ve.com.cge.appinfotool.controllers.ExitAction;
import ve.com.cge.appinfotool.utils.AppInfo;
import ve.com.cge.appinfotool.utils.MenuHandler;

/**
 *
 * @author cge
 */
public class MDIApp extends JFrame {
    
    private static final Logger logger = LogManager.getLogger(MDIApp.class);
    
    private AppInfo appInfo;
    private JMenuBar menuBar;
    private JMenu mnuFile;
    private JMenuItem mniSave;
    private JMenuItem mniExit;
    private JMenu mnuHelp;
    private JMenuItem mniAbout;
    private JMenuItem mniContent;

    private JDesktopPane desktopPane;


    public MDIApp(AppInfo appInfo) {
        this.appInfo = appInfo;
        initComponents();
    }
    
    private void initComponents() {
        desktopPane = new JDesktopPane();
        menuBar = new JMenuBar();
        mnuFile = new JMenu();
        mniSave = new JMenuItem();
        mniExit = new JMenuItem();
        mnuHelp = new JMenu();
        mniContent = new JMenuItem();
        mniAbout = new JMenuItem();
        
        Icon icoApp = IconFontSwing.buildIcon(FontAwesome.USER_CIRCLE_O, 15, new Color(219, 20, 186));
         
 
        mnuFile.setMnemonic('f');
        mnuFile.setText("File");
        
        mniSave.setMnemonic('s');
        mniSave.setText("Save");
        mnuFile.add(mniSave);
        
        mniExit.setMnemonic('x');
        mniExit.setText("Exit");
        mniExit.addActionListener(new ExitAction()); 
        mnuFile.add(mniExit);
        
        menuBar.add(mnuFile);
        
        mnuHelp.setMnemonic('h');
        mnuHelp.setText("Help");

        mniContent.setMnemonic('c');
        mniContent.setText("Contents");
        mnuHelp.add(mniContent);

        mniAbout.setMnemonic('a');
        mniAbout.setText("About");
        mnuHelp.add(mniAbout);
        
        MenuHandler menuHandler = new MenuHandler();
        ArrayList<JMenu> menus = new ArrayList<JMenu>();
        menus = menuHandler.menuList();
        for (JMenu men : menus) {
             menuBar.add(men);
        }

        menuBar.add(mnuHelp);
        
        setJMenuBar(menuBar);
         
        add(desktopPane);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setTitle(appInfo.getSYSTEM());
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
     
    }
      

    
}

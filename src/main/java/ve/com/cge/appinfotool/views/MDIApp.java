package ve.com.cge.appinfotool.views;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import ve.com.cge.appinfotool.controllers.AboutAction;
import ve.com.cge.appinfotool.controllers.ExitAction;
import ve.com.cge.appinfotool.controllers.JasperAction;
import ve.com.cge.appinfotool.utils.AppInfo;
import ve.com.cge.appinfotool.utils.ListHandler;
import ve.com.cge.appinfotool.utils.MenuHandler;
import ve.com.cge.appinfotool.utils.ViewerHandler;

/**
 * MDIApp : This is the class of the mdi screen
 * 
 * @author Christopher Gedler <cgedler@gmail.com>
 * @version 1.0
 * @since Nov 19, 2024
 */
public class MDIApp extends JFrame {

    public AppInfo appInfo;
    private JMenuBar menuBar;
    private JMenu mnuFile;
    private JMenuItem mniSave;
    private JMenuItem mniExit;
    private JMenu mnuHelp;
    private JMenuItem mniAbout;
    private JMenuItem mniContent;
    private JDesktopPane desktopPane;
    private JSplitPane splitPane;
    private JScrollPane scrollPane;
    private JScrollPane viewerScrollPane;
    private JEditorPane viewerPane;
    private JList<String> list;
    private DefaultListModel<String> listModel;
    private String code;

    public MDIApp(AppInfo appInfo) {
        this.appInfo = appInfo;
        initComponents();
    }

    private void initComponents() {
        desktopPane = new JDesktopPane();
        splitPane = new JSplitPane();
        viewerPane = new JEditorPane();
        viewerScrollPane = new JScrollPane(viewerPane);

        listModel = new DefaultListModel<>();
        listModel.addElement("Elemento");
        list = new JList<>(listModel);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String value = list.getSelectedValue();
                    ViewerHandler vh = new ViewerHandler();
                    String content = vh.getContent(code, value);
                    viewerPane.setText(content);
                }
            }
        });

        menuBar = new JMenuBar();
        mnuFile = new JMenu();
        mniSave = new JMenuItem();
        mniExit = new JMenuItem();
        mnuHelp = new JMenu();
        mniContent = new JMenuItem();
        mniAbout = new JMenuItem();

        ImageIcon icoApp = new ImageIcon(this.getClass().getClassLoader().getResource("image/terminal.png"));
        Icon icoFile = IconFontSwing.buildIcon(FontAwesome.FILE_O, 15, new Color(219, 20, 186));
        Icon icoSave = IconFontSwing.buildIcon(FontAwesome.FLOPPY_O, 15, new Color(219, 20, 186));
        Icon icoExit = IconFontSwing.buildIcon(FontAwesome.SIGN_OUT, 15, new Color(219, 20, 186));
        Icon icoHelp = IconFontSwing.buildIcon(FontAwesome.INFO, 15, new Color(219, 20, 186));
        //Icon icoContent = IconFontSwing.buildIcon(FontAwesome.INFO_CIRCLE, 15, new Color(219, 20, 186));
        ImageIcon icoContent = new ImageIcon(this.getClass().getClassLoader().getResource("image/contents.png"));
        Icon icoAbout = IconFontSwing.buildIcon(FontAwesome.QUESTION_CIRCLE_O, 15, new Color(219, 20, 186));

        mnuFile.setMnemonic('f');
        mnuFile.setText("File");
        mnuFile.setIcon(icoFile);

        mniSave.setMnemonic('s');
        mniSave.setText("Save");
        mniSave.setIcon(icoSave);
        mnuFile.add(mniSave);

        mniExit.setMnemonic('x');
        mniExit.setText("Exit");
        mniExit.setIcon(icoExit);
        mniExit.addActionListener(new ExitAction());
        mnuFile.add(mniExit);

        menuBar.add(mnuFile);

        mnuHelp.setMnemonic('h');
        mnuHelp.setText("Help");
        mnuHelp.setIcon(icoHelp);

        mniContent.setMnemonic('c');
        mniContent.setText("Contents");
        mniContent.setIcon(icoContent);
        mniContent.addActionListener(new JasperAction(this));
        mnuHelp.add(mniContent);

        mniAbout.setMnemonic('a');
        mniAbout.setText("About");
        mniAbout.setIcon(icoAbout);
        mniAbout.addActionListener(new AboutAction(this));
        mnuHelp.add(mniAbout);
        
        MenuHandler menuHandler = new MenuHandler();
        ArrayList<JMenu> menus = new ArrayList<JMenu>();
        menus = menuHandler.menuList(this);
        for (JMenu men : menus) {
            menuBar.add(men);
        }
        menuBar.add(mnuHelp);
        setJMenuBar(menuBar);
        
        viewerPane.setContentType("text/html");
        scrollPane = new JScrollPane(list);
        splitPane.setLeftComponent(scrollPane);
        splitPane.setRightComponent(viewerScrollPane);
        desktopPane.setLayout(new GridLayout(1, 1));
        desktopPane.add(splitPane);
        add(desktopPane);

        setExtendedState(Frame.MAXIMIZED_BOTH);
        setTitle(appInfo.getSYSTEM());
        setVisible(true);
        setIconImage(icoApp.getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void updateList(String code) {
        listModel.clear();
        this.code = code;
        ListHandler lh = new ListHandler();
        List<String> list = lh.getList(code);
        for (String item : list) {
            listModel.addElement(item);
        }
        String total = "Total: " + list.size();
        listModel.addElement(total);
    }

}

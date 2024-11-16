package ve.com.cge.appinfotool.views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    private JSplitPane splitPane;
    private JScrollPane scrollPane;
    private JEditorPane viewerPane;
    private JList<String> list;
    private DefaultListModel<String> listModel;

    public MDIApp(AppInfo appInfo) {
        this.appInfo = appInfo;
        initComponents();
    }

    private void initComponents() {
        desktopPane = new JDesktopPane();
        splitPane = new JSplitPane();
        viewerPane = new JEditorPane();

        listModel = new DefaultListModel<>();
        listModel.addElement("Elemento 1");
        listModel.addElement("Elemento 2");
        listModel.addElement("Elemento 3");
        list = new JList<>(listModel);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String value = list.getSelectedValue();
                    System.out.println("Valor: " + value);
                }

                viewerPane.setText(
                        "<b>hola</b><br>" + "<i>adios</i><br>"
                        + "<font face=\"arial\">fuente arial</font><br>"
                        + "<font face=\"courier\">fuente courier</font><br>"
                        + "<font size=\"24\">fuente grande</font><br>"
                        + "<font color=\"red\">color rojo</font><br>");

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
        mnuHelp.add(mniContent);

        mniAbout.setMnemonic('a');
        mniAbout.setText("About");
        mniAbout.setIcon(icoAbout);
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
        splitPane.setRightComponent(viewerPane);
        //scrollPane
        desktopPane.setLayout(new GridLayout(1, 1));

        desktopPane.add(splitPane);
        //desktopPane.add(sidebar);
        //desktopPane.add(viewerPane);

        add(desktopPane);

        setExtendedState(Frame.MAXIMIZED_BOTH);
        setTitle(appInfo.getSYSTEM());
        setVisible(true);
        setIconImage(icoApp.getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void actualizarLista() {
        listModel.clear();
        listModel.addElement("Nuevo Elemento 1");
        listModel.addElement("Nuevo Elemento 2");
        listModel.addElement("Nuevo Elemento 3"); // Añade aquí los nuevos elementos }

    }

}

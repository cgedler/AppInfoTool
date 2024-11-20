package ve.com.cge.appinfotool.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ve.com.cge.appinfotool.controllers.MenuAction;
import ve.com.cge.appinfotool.models.MainMenu;
import ve.com.cge.appinfotool.models.SubMenu;
import ve.com.cge.appinfotool.views.MDIApp;

/**
 * MenuHandler : This is the class in charge of handling the loading of the menu and submenu by reading from a json file.
 * 
 * @author Christopher Gedler <cgedler@gmail.com>
 * @version 1.0
 * @since Nov 19, 2024
 */
public class MenuHandler {
    
    private static final Logger logger = LogManager.getLogger(MenuHandler.class);
    private static final String LOOK = java.util.ResourceBundle.getBundle("app").getString("LOOK");

    public ArrayList<JMenu> menuList(MDIApp app) {
        ArrayList<JMenu> menus = new ArrayList<JMenu>();
        ArrayList<MainMenu> menu = readfile();
        Icon icoAngle= IconFontSwing.buildIcon(FontAwesome.ANGLE_RIGHT, 10, new Color(135, 33, 150));
        try {
            for (MainMenu mainmenu : menu) {
                JMenu mnuTemp = new JMenu();
                mnuTemp.setText(mainmenu.getName());
                if (!LOOK.equals("6")) {
                    ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource("image/" + mainmenu.getIcon() + ".png"));
                    mnuTemp.setIcon(imagen);
                }
                for (SubMenu submenu : mainmenu.getSub()) {
                    JMenuItem submTemp = new JMenuItem();
                    submTemp.setText(submenu.getName());
                    submTemp.setIcon(icoAngle);
                    submTemp.addActionListener(new MenuAction(submenu.getCode(), app));
                    mnuTemp.add(submTemp);
                }
                menus.add(mnuTemp);
            }
        } catch (Exception ex) {
            logger.error("Failed to get menu list", ex);;
        }
        return menus;
    }

    private ArrayList<MainMenu> readfile() {
        ArrayList<MainMenu> menu = new ArrayList<MainMenu>();
        try {
            File file = new File(this.getClass().getClassLoader().getResource("mainmenu.json").getFile());
            ObjectMapper mapper = new ObjectMapper();
            menu = mapper.readValue(file, new TypeReference<ArrayList<MainMenu>>(){});
        } catch (Exception ex) {
            logger.error("Failed to get file main menu", ex);
        }
        return menu;
    }

}

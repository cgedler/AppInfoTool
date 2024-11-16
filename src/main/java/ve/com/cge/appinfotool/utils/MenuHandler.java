package ve.com.cge.appinfotool.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import ve.com.cge.appinfotool.controllers.MenuAction;
import ve.com.cge.appinfotool.models.MainMenu;
import ve.com.cge.appinfotool.models.SubMenu;
import ve.com.cge.appinfotool.views.MDIApp;

/**
 *
 * @author cge
 */
public class MenuHandler {

    public ArrayList<JMenu> menuList(MDIApp app) {
        ArrayList<JMenu> menus = new ArrayList<JMenu>();
        ArrayList<MainMenu> menu = readfile();
        Icon icoAngle= IconFontSwing.buildIcon(FontAwesome.ANGLE_RIGHT, 10, new Color(135, 33, 150));
        try {
            for (MainMenu mainmenu : menu) {
                JMenu mnuTemp = new JMenu();
                mnuTemp.setText(mainmenu.getName());
                ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource("image/" + mainmenu.getIcon() + ".png"));
                mnuTemp.setIcon(imagen);
                for (SubMenu submenu : mainmenu.getSub()) {
                    JMenuItem submTemp = new JMenuItem();
                    submTemp.setText(submenu.getName());
                    submTemp.setIcon(icoAngle);
                    submTemp.addActionListener(new MenuAction(submenu.getCode(), app));
                    mnuTemp.add(submTemp);
                }
                menus.add(mnuTemp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menus;
    }

    private ArrayList<MainMenu> readfile() {
        ArrayList<MainMenu> menu = new ArrayList<MainMenu>();
        try {
            File file = new File(this.getClass().getClassLoader().getResource("mainmenu.json").getFile());
            ObjectMapper mapper = new ObjectMapper();
            menu = mapper.readValue(file, new TypeReference<ArrayList<MainMenu>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menu;
    }

}

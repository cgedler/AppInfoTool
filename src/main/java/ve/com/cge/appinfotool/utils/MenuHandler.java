package ve.com.cge.appinfotool.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import ve.com.cge.appinfotool.controllers.MenuAction;
import ve.com.cge.appinfotool.models.MainMenu;
import ve.com.cge.appinfotool.models.SubMenu;

/**
 *
 * @author cge
 */
public class MenuHandler {

    public ArrayList<JMenu> menuList() {
        ArrayList<JMenu> menus = new ArrayList<JMenu>();
        ArrayList<MainMenu> menu = readfile();
        try {
            for (MainMenu mainmenu : menu) {
                JMenu mnuTemp = new JMenu();
                mnuTemp.setText(mainmenu.getName());     
                for (SubMenu submenu : mainmenu.getSub()) {
                    JMenuItem submTemp = new JMenuItem();
                    submTemp.setText(submenu.getName());
                    submTemp.addActionListener(new MenuAction(submenu.getCode()));
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


package ve.com.cge.appinfotool.models;

import java.util.List;

/**
 * MainMenu : This is the main menu model class
 * 
 * @author Christopher Gedler <cgedler@gmail.com>
 * @version 1.0
 * @since Nov 19, 2024
 */
public class MainMenu {
    
    private String name;
    private String icon;
    private List<SubMenu> sub;

    public MainMenu() {
    }

    public MainMenu(String name, String icon, List<SubMenu> sub) {
        this.name = name;
        this.icon = icon;
        this.sub = sub;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<SubMenu> getSub() {
        return sub;
    }

    public void setSub(List<SubMenu> sub) {
        this.sub = sub;
    }
    
}

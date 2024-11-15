
package ve.com.cge.appinfotool.models;

import java.util.List;

/**
 *
 * @author cge
 */
public class MainMenu {
    
    private String name;
    private List<SubMenu> sub;

    public MainMenu() {
    }

    public MainMenu(String name, List<SubMenu> sub) {
        this.name = name;
        this.sub = sub;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubMenu> getSub() {
        return sub;
    }

    public void setSub(List<SubMenu> sub) {
        this.sub = sub;
    }
    
}


package ve.com.cge.appinfotool.models;

/**
 * SubMenu : This is the model class of the main sub menu
 * 
 * @author Christopher Gedler <cgedler@gmail.com>
 * @version 1.0
 * @since Nov 19, 2024
 */
public class SubMenu {
    
    private String name;
    private String code;

    public SubMenu() {
    }

    public SubMenu(String name, String code) {
        this.name = name;
        this.code = code;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
     
}

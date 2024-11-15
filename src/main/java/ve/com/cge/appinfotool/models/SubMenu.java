
package ve.com.cge.appinfotool.models;

/**
 *
 * @author cge
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


package ve.com.cge.appinfotool.models;

/**
 *
 * @author cge
 */
public class ListMenu {
    
    private String title;
    private String file;

    public ListMenu() {
    }

    public ListMenu(String title, String file) {
        this.title = title;
        this.file = file;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

}

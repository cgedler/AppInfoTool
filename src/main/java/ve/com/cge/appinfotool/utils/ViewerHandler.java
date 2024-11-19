package ve.com.cge.appinfotool.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ve.com.cge.appinfotool.models.ListMenu;

/**
 *
 * @author cge
 */
public class ViewerHandler {

    private static final Logger logger = LogManager.getLogger(ViewerHandler.class);

    public String getContent(String code, String title) {
        String fileName = getFileName(code, title);
        String content = null;
        try {
            StringBuilder str = new StringBuilder();
            String css = getFileStyle();
            str.append(css);
            File file = new File(this.getClass().getClassLoader().getResource("content/" + code + "/" + fileName + ".html").getFile());
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                str.append(data);
            }
            reader.close();
            content = str.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return content;
    }

    private String getFileName(String code, String title) {
        String fileName = "";
        ArrayList<ListMenu> listMenu = new ArrayList<ListMenu>();
        try {
            File file = new File(this.getClass().getClassLoader().getResource("topics/" + code + ".json").getFile());
            ObjectMapper mapper = new ObjectMapper();
            listMenu = mapper.readValue(file, new TypeReference<ArrayList<ListMenu>>() {
            });
            for (ListMenu item : listMenu) {
                if (title.equals(item.getTitle())) {
                    fileName = item.getFile();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }
    
    private String getFileStyle() {
        String content = "";
        try {
            StringBuilder str = new StringBuilder();
            File file = new File(this.getClass().getClassLoader().getResource("style/Style.html").getFile());
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                str.append(data);
            }
            reader.close();
            content = str.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return content;
    }

}

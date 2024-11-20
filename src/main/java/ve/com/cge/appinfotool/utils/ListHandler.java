
package ve.com.cge.appinfotool.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ve.com.cge.appinfotool.models.ListMenu;

/**
 * ListHandler : This is the class in charge of handling the loading of the menu list by reading from a json file.
 * 
 * @author Christopher Gedler <cgedler@gmail.com>
 * @version 1.0
 * @since Nov 19, 2024
 */
public class ListHandler {
    
    private static final Logger logger = LogManager.getLogger(ListHandler.class);
    
    public List<String> getList(String code) {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<ListMenu> listMenu = new ArrayList<ListMenu>();
        try {
            File file = new File(this.getClass().getClassLoader().getResource("topics/" + code + ".json").getFile());
            ObjectMapper mapper = new ObjectMapper();
            listMenu = mapper.readValue(file, new TypeReference<ArrayList<ListMenu>>(){});    
            for (ListMenu item : listMenu) {
                list.add(item.getTitle());
            }
        } catch (Exception ex) {
            logger.error("Failed to get list menu", ex);
        }
        return list;
    }
    
}

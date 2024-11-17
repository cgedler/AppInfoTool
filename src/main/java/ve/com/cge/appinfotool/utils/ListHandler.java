
package ve.com.cge.appinfotool.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

/**
 *
 * @author cge
 */
public class ListHandler {
    
    public String[] getList(String code) {
        String[] list = null;
        try {
            File file = new File(this.getClass().getClassLoader().getResource("topics/" + code + ".json").getFile());
            ObjectMapper mapper = new ObjectMapper();
            list = mapper.readValue(file, String[].class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}

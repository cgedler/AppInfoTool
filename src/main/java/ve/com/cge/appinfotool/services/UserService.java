
package ve.com.cge.appinfotool.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ve.com.cge.appinfotool.models.User;
import ve.com.cge.appinfotool.utils.DataBaseHandler;
import ve.com.cge.appinfotool.utils.MessageHandler;

/**
 *
 * @author cge
 */
public class UserService {
    
    private static final Logger logger = LogManager.getLogger(UserService.class);
    
    public static List<User> getUsers() {
        ArrayList<User> listUsers = new ArrayList<User>();
        try {
            DataBaseHandler db = new DataBaseHandler();
            Connection cn = db.conect();
            String query = "SELECT id, username FROM users";
            Statement s = cn.createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                Long id = rs.getLong("id");
                String username = rs.getString("username");
                User tempUser = new User(id, username);
                listUsers.add(tempUser);
            }
            rs.close();
        } catch (SQLException ex) {
            logger.error("Failed to get list of users", ex);
        }
        return listUsers;
    }
    
    public static User getUserByUsername(String username) {
        User user = new User();
        try {
            DataBaseHandler db = new DataBaseHandler();
            Connection cn = db.conect();
            String query = "SELECT pwd FROM users WHERE username=?";
            PreparedStatement p = cn.prepareStatement(query);
            p.setString(1, username);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                String pwd = rs.getString("pwd");
                user = new User(username, pwd);
            }
            rs.close();
        } catch (SQLException ex) {
            logger.error("Failed to get list of users", ex);
        }
        return user;
    }
    
}


package ve.com.cge.appinfotool.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author cge
 */
public class PasswordHandler {
    
    private static final Logger logger = LogManager.getLogger(PasswordHandler.class);
    
    private static int workload = 12;

    public static String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt(workload);
        String hashed_password = BCrypt.hashpw(password_plaintext, salt);
        return (hashed_password);
    }

    public static boolean checkPassword(String password_plaintext, String stored_hash) {
        boolean password_verified = false;
        if (null == stored_hash || !stored_hash.startsWith("$2a$")) {
            logger.error("Invalid hash provided for comparison");
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
        }
        password_verified = BCrypt.checkpw(password_plaintext, stored_hash);
        return (password_verified);
    }
    
}

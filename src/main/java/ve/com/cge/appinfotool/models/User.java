
package ve.com.cge.appinfotool.models;

import java.io.Serializable;
import java.util.Objects;

/**
 * User : This is the model class of the users
 * 
 * @author Christopher Gedler <cgedler@gmail.com>
 * @version 1.0
 * @since Nov 19, 2024
 */
public class User implements Serializable {
    
    private Long id;
    private String username;
    private String password;
    
    public User() {
        
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public User(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return Objects.equals(this.username, other.username);
    }

    @Override
    public String toString() {
        return "User {" + "id=" + id + ", username=" + username + ", password=" + password + '}';
    }

}

package code.with.me.auth;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * @author andong@xiaomalixing.com
 */
@Entity
public class User {
    @Id
    private String username;
    private String password;
}

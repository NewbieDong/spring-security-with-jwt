package code.with.me.auth;

import lombok.Data;

/**
 * @author andong@xiaomalixing.com
 */
@Data
public class User {
    private String username;
    private String password;
    private String code;
}

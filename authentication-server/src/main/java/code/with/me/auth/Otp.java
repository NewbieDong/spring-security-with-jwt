package code.with.me.auth;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * @author andong@xiaomalixing.com
 */
@Entity
@Data
public class Otp {

    @Id
    private String username;
    private String code;
}

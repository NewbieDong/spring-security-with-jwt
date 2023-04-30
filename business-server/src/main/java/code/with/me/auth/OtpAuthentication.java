package code.with.me.auth;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author andong@xiaomalixing.com
 */
public class OtpAuthentication extends UsernamePasswordAuthentication {
    public OtpAuthentication(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public OtpAuthentication(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}

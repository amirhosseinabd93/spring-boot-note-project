package ir.arcademy.notes.modules.user.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.Collection;

public class CustomUserDetails extends User {
    public CustomUserDetails(String email, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(email, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}

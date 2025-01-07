package app.bank.core.web.security;

import app.bank.common.domain.model.Client;
import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Data
public class SecurityUser implements UserDetails {

    private final UUID id;
    private final String phone;
    private final String password;
    private final Collection<SimpleGrantedAuthority> authorities;

    public SecurityUser(
            final Client user
    ) {
        this(
                user.getId(),
                user.getPhone(),
                user.getPassword()
        );
        this.authorities.add(
                mapToGrantedAuthorities("ROLE_USER")
        );
    }

    private static SimpleGrantedAuthority mapToGrantedAuthorities(
            final String role
    ) {
        return new SimpleGrantedAuthority(role);
    }

    private SecurityUser(
            final UUID id,
            final String phone,
            final String password
    ) {
        this.id = id;
        this.phone = phone;
        this.password = password;
        this.authorities = new ArrayList<>();
    }

    @Override
    public String getUsername() {
        return phone;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

package app.bank.core.web.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsBankService extends UserDetailsService {

    UserDetails loadUserByPhone(String phone) throws UsernameNotFoundException;

}

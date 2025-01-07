package app.bank.core.web.security;

import app.bank.common.domain.model.Client;
import app.bank.core.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityUserService implements UserDetailsBankService {

    private final ClientService clientService;

    @Override
    @SneakyThrows
    public UserDetails loadUserByUsername(String username) {
        return null;
    }

    @Override
    public UserDetails loadUserByPhone(String phone) throws UsernameNotFoundException {
        Client client = clientService.getByPhone(phone);
        return new SecurityUser(client);
    }
}

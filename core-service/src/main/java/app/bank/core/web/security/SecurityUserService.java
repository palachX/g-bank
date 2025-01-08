package app.bank.core.web.security;

import app.bank.common.domain.model.Client;
import app.bank.core.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SecurityUserService implements UserDetailsBankService {

    private final ClientService clientService;

    @Override
    @SneakyThrows
    public UserDetails loadUserByUsername(String username) {
        Client client = clientService.getByPhone(username);
        return new SecurityUser(client);
    }

    @Override
    public UserDetails loadUserByPhone(String phone) throws UsernameNotFoundException {
        Client client = clientService.getByPhone(phone);
        return new SecurityUser(client);
    }
}

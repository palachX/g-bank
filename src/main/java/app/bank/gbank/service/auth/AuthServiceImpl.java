package app.bank.gbank.service.auth;

import app.bank.gbank.domain.exception.ResourceAlreadyExistsException;
import app.bank.gbank.domain.model.Client;
import app.bank.gbank.service.client.ClientService;
import app.bank.gbank.web.dto.LoginRequestDto;
import app.bank.gbank.web.dto.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ClientService clientService;

    @Override
    public LoginResponseDto login(LoginRequestDto dto) {
        //TODO implement
        return null;
    }

    @Override
    public void register(Client client) {
        if (clientService.existsByPhone(client.getPhone())) {
            throw new ResourceAlreadyExistsException();
        }
        //TODO hash password
        client.setPassword(client.getPassword());
        clientService.create(client);
    }

}

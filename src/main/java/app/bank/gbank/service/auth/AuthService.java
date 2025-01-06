package app.bank.gbank.service.auth;

import app.bank.gbank.domain.model.Client;
import app.bank.gbank.web.dto.LoginRequestDto;
import app.bank.gbank.web.dto.LoginResponseDto;

public interface AuthService {

    LoginResponseDto login(LoginRequestDto dto);

    void register(Client client);

}

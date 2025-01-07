package app.bank.core.service.auth;

import app.bank.common.domain.model.Client;
import app.bank.core.web.dto.LoginRequestDto;
import app.bank.core.web.dto.LoginResponseDto;

public interface AuthService {

    LoginResponseDto login(LoginRequestDto dto);

    void register(Client client);

}

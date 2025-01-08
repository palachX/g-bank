package app.bank.core.service.auth;

import app.bank.common.domain.exception.ResourceAlreadyExistsException;
import app.bank.common.domain.model.Client;
import app.bank.core.service.client.ClientService;
import app.bank.core.web.dto.LoginRequestDto;
import app.bank.core.web.dto.LoginResponseDto;
import app.bank.core.web.security.jwt.JwtProperties;
import app.bank.core.web.security.jwt.TokenType;
import io.github.ilyalisov.jwt.config.TokenParameters;
import io.github.ilyalisov.jwt.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ClientService clientService;
    private final TokenService tokenService;
    private final JwtProperties jwtProperties;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponseDto login(LoginRequestDto requestDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestDto.getPhone(),
                        requestDto.getPassword()
                )
        );

        LoginResponseDto response = new LoginResponseDto();
        Client client = clientService.getByPhone(requestDto.getPhone());
        response.setId(client.getId());
        response.setAccessToken(
                tokenService.create(TokenParameters.builder(
                                        requestDto.getPhone(),
                                        TokenType.ACCESS.name(),
                                        jwtProperties.getAccess()
                                )
                                .build()
                )
        );


        response.setRefreshToken(
                tokenService.create(TokenParameters.builder(
                                        requestDto.getPhone(),
                                        TokenType.REFRESH.name(),
                                        jwtProperties.getRefresh()
                                )
                                .build()
                )
        );


        return response;
    }

    @Override
    public void register(Client client) {
        if (clientService.existsByPhone(client.getPhone())) {
            throw new ResourceAlreadyExistsException();
        }

        client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientService.create(client);
    }

}

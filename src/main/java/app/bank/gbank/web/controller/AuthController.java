package app.bank.gbank.web.controller;

import app.bank.gbank.domain.model.Client;
import app.bank.gbank.service.auth.AuthService;
import app.bank.gbank.web.dto.ClientDto;
import app.bank.gbank.web.dto.LoginRequestDto;
import app.bank.gbank.web.dto.LoginResponseDto;
import app.bank.gbank.web.dto.OnCreate;
import app.bank.gbank.web.dto.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    private final ClientMapper clientMapper;

    @PostMapping("/register")
    public void register(@RequestBody @Validated(OnCreate.class) final ClientDto clientDto) {
        Client client = clientMapper.toEntity(clientDto);
        authService.register(client);
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody @Validated final LoginRequestDto dto) {
        return authService.login(dto);
    }

}



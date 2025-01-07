package app.bank.core.web.controller;

import app.bank.common.domain.model.Client;
import app.bank.core.service.auth.AuthService;
import app.bank.core.web.dto.ClientDto;
import app.bank.core.web.dto.LoginRequestDto;
import app.bank.core.web.dto.LoginResponseDto;
import app.bank.core.web.dto.OnCreate;
import app.bank.core.web.dto.mapper.ClientMapper;
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



package app.bank.core.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class LoginResponseDto {

    private UUID id;
    private String accessToken;
    private String refreshToken;

}

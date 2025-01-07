package app.bank.core.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {

    @NotNull(
            message = "Phone cannot be null"
    )
    private String phone;

    @NotNull(
            message = "Password cannot be null"
    )
    private String password;

}

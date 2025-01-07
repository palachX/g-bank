package app.bank.core.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Getter
@Setter
public class ClientDto {

    @NotNull(
            message = "ID cannot be null",
            groups = OnUpdate.class
    )
    @Null(
            message = "ID must be null",
            groups = OnCreate.class
    )
    private UUID id;

    @NotNull(
            message = "Name cannot be null"
    )
    @Length(
            min = 2,
            max = 255,
            message = "Name must be between {min} and {max} characters"
    )
    private String name;

    @NotNull(
            message = "Phone cannot be null"
    )
    @Length(
            min = 11,
            max = 11,
            message = "Phone must be between {min} and {max} characters"
    )
    private String phone;

    @NotNull(
            message = "Password cannot be null"
    )
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


}

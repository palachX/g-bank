package app.bank.core.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class CardDto {

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
            message = "Number cannot be null",
            groups = OnCreate.class
    )
    @Null(
            message = "Number must be null"
    )
    private String number;

    @NotNull(
            message = "Date expiration cannot be null",
            groups = OnCreate.class
    )
    @Null(
            message = "Date expiration must be null"
    )
    private Date dateExpiration;

    @NotNull(
            message = "CVV cannot be null",
            groups = OnCreate.class
    )
    @Null(
            message = "CVV must be null"
    )
    private String cvv;

}

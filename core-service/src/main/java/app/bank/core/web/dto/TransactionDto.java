package app.bank.core.web.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class TransactionDto {

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
            message = "Sender card cannot be null",
            groups = OnCreate.class
    )
    @Null(
            message = "Sender card must be null"
    )
    @Valid
    private CardDto from;

    @NotNull(
            message = "Receiver card cannot be null",
            groups = OnCreate.class
    )
    @Null(
            message = "Receiver card must be null"
    )
    @Valid
    private CardDto to;

    @NotNull(
            message = "Amount cannot be null"
    )
    @Positive(
            message = "Amount must be positive"
    )
    private BigDecimal amount;

}

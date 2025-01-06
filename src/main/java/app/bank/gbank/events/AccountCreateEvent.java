package app.bank.gbank.events;

import app.bank.gbank.domain.aggregate.Aggregate;
import app.bank.gbank.domain.model.Account;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AccountCreateEvent extends AbstractEvent {

    public AccountCreateEvent(Account payload) {
        super(payload, EventType.ACCOUNT_CREATE, null);
    }

    @Override
    public void apply(Aggregate aggregate) {

    }

}

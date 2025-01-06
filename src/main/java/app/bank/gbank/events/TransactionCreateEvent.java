package app.bank.gbank.events;

import app.bank.gbank.domain.aggregate.Aggregate;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TransactionCreateEvent extends AbstractEvent {

    public TransactionCreateEvent(Object payload) {
        super(payload, EventType.TRANSACTION_CREATE, null);
    }

    @Override
    public void apply(Aggregate aggregate) {

    }

}

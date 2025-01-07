package app.bank.common.events;

import app.bank.common.domain.aggregate.Aggregate;
import app.bank.common.domain.model.Transaction;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TransactionCreateEvent extends AbstractEvent {

    public TransactionCreateEvent(Transaction payload) {
        super(payload, EventType.TRANSACTION_CREATE, null);
    }

    @Override
    public void apply(Aggregate aggregate) {

    }

}

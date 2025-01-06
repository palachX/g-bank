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
public class ClientCreateEvent extends AbstractEvent {

    public ClientCreateEvent(Object payload) {
        super(payload, EventType.CLIENT_CREATE, null);
    }

    @Override
    public void apply(Aggregate aggregate) {

    }

}

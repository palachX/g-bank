package app.bank.common.events;

import app.bank.common.domain.aggregate.Aggregate;
import app.bank.common.domain.model.Client;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ClientCreateEvent extends AbstractEvent {

    public ClientCreateEvent(Client payload) {
        super(payload, EventType.CLIENT_CREATE, null);
    }

    @Override
    public void apply(Aggregate aggregate) {

    }

}

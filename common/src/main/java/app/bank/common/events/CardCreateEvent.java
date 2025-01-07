package app.bank.common.events;

import app.bank.common.domain.aggregate.Aggregate;
import app.bank.common.domain.model.Card;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CardCreateEvent extends AbstractEvent {

    public CardCreateEvent(Card payload) {
        super(payload, EventType.CARD_CREATE, null);
    }

    @Override
    public void apply(Aggregate aggregate) {

    }

}

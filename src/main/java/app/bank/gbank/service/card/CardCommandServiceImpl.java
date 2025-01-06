package app.bank.gbank.service.card;

import app.bank.gbank.domain.model.Card;
import app.bank.gbank.events.CardCreateEvent;
import app.bank.gbank.service.card.CardCommandService;
import app.bank.gbank.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardCommandServiceImpl implements CardCommandService {

    private final EventService eventService;

    @Override
    public void create(Card object) {
        CardCreateEvent event = new CardCreateEvent(object);
        eventService.create(event);
    }
}

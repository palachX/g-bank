package app.bank.core.service.transaction;

import app.bank.common.domain.model.Card;
import app.bank.common.domain.model.Transaction;
import app.bank.common.events.TransactionCreateEvent;
import app.bank.common.service.event.EventService;
import app.bank.core.service.card.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionCommandServiceImpl implements TransactionCommandService {

    private final EventService eventService;
    private final CardService cardService;

    @Override
    public void create(Transaction object) {
        Card from = cardService.getByNumberAndDateAndCvv(
                object.getFrom().getNumber(),
                object.getFrom().getDateExpiration(),
                object.getFrom().getCvv()
        );
        Card to = cardService.getByNumberAndDate(
                object.getTo().getNumber(),
                object.getTo().getDateExpiration()
        );
        object.setFrom(from);
        object.setTo(to);
        TransactionCreateEvent event = new TransactionCreateEvent(object);
        eventService.create(event);
    }
}

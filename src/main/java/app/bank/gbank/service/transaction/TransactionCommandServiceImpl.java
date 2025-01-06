package app.bank.gbank.service.transaction;

import app.bank.gbank.domain.model.Transaction;
import app.bank.gbank.events.TransactionCreateEvent;
import app.bank.gbank.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionCommandServiceImpl implements TransactionCommandService {

    private final EventService eventService;

    @Override
    public void create(Transaction object) {
        TransactionCreateEvent event = new TransactionCreateEvent(object);
        eventService.create(event);
    }
}

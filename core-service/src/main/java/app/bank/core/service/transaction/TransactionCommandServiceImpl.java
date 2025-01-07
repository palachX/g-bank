package app.bank.core.service.transaction;

import app.bank.common.domain.model.Transaction;
import app.bank.common.events.TransactionCreateEvent;
import app.bank.core.service.event.EventService;
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

package app.bank.gbank.service.account;

import app.bank.gbank.domain.model.Account;
import app.bank.gbank.events.AccountCreateEvent;
import app.bank.gbank.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountCommandServiceImpl implements AccountCommandService {

    private final EventService eventService;

    @Override
    public void create(Account object) {
        AccountCreateEvent event = new AccountCreateEvent(object);
        eventService.create(event);
    }
}

package app.bank.gbank.service.client;

import app.bank.gbank.domain.model.Client;
import app.bank.gbank.events.ClientCreateEvent;
import app.bank.gbank.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientCommandServiceImpl implements ClientCommandService {

    private final EventService eventService;

    @Override
    public void create(Client object) {
        ClientCreateEvent event = new ClientCreateEvent(object);
        eventService.create(event);
    }
}

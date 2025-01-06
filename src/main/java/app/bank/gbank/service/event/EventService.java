package app.bank.gbank.service.event;

import app.bank.gbank.events.AbstractEvent;

public interface EventService {

    void create(AbstractEvent event);

}

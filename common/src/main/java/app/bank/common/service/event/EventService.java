package app.bank.common.service.event;

import app.bank.common.events.AbstractEvent;

public interface EventService {

    void create(AbstractEvent event);

}

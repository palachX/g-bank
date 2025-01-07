package app.bank.core.service.event;

import app.bank.common.events.AbstractEvent;
import app.bank.common.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository repository;

    @Override
    public void create(AbstractEvent event) {
        repository.save(event);
    }

}

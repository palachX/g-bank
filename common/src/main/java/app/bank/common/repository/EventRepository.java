package app.bank.common.repository;

import app.bank.common.events.AbstractEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<AbstractEvent, Long> {
}

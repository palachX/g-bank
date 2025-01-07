package app.bank.common.events;

import app.bank.common.domain.aggregate.Aggregate;

public interface Event {

    void apply(Aggregate aggregate);

}

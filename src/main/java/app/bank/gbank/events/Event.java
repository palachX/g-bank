package app.bank.gbank.events;

import app.bank.gbank.domain.aggregate.Aggregate;

public interface Event {

    void apply(Aggregate aggregate);

}

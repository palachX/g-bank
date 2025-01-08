package app.bank.eventhandler.handler;

import app.bank.common.domain.model.Card;
import app.bank.common.events.CardCreateEvent;
import app.bank.eventhandler.service.card.CardService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("CARD_CREATE")
@RequiredArgsConstructor
public class CardCreateEventHandler implements EventHandler {

    private final CardService cardService;
    private final Gson gson;

    @Override
    @Transactional
    public void handle(final JsonObject object, final Acknowledgment acknowledgment) {
        CardCreateEvent event = gson.fromJson(
                object,
                CardCreateEvent.class
        );

        Card card = gson.fromJson(
                (String) event.getPayload(),
                Card.class
        );

        cardService.create(card);
        acknowledgment.acknowledge();
    }
}

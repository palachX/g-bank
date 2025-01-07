package app.bank.eventhandler.handler;

import app.bank.common.domain.model.Client;
import app.bank.common.events.ClientCreateEvent;
import app.bank.eventhandler.service.client.ClientService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("CLIENT_CREATE")
@RequiredArgsConstructor
public class ClientCreateEventHandler implements EventHandler {

    private final ClientService clientService;
    private final Gson gson;

    @Override
    @Transactional
    public void handle(JsonObject object, Acknowledgment acknowledgment) {
        ClientCreateEvent event = gson.fromJson(
                object,
                ClientCreateEvent.class
        );

        Client client = gson.fromJson(
                (String) event.getPayload(),
                Client.class
        );

        clientService.create(client);
        acknowledgment.acknowledge();
    }
}

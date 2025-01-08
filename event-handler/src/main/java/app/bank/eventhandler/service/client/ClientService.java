package app.bank.eventhandler.service.client;

import app.bank.common.domain.model.Card;
import app.bank.common.domain.model.Client;

import java.util.UUID;

public interface ClientService {

    Client create(Client client);

    void addCard(UUID clientId, UUID cardId);

}

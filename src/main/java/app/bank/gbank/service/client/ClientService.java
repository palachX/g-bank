package app.bank.gbank.service.client;

import app.bank.gbank.domain.model.Client;
import app.bank.gbank.service.CommandService;
import app.bank.gbank.service.QueryService;

public interface ClientService extends QueryService<Client>, CommandService<Client> {
}

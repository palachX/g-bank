package app.bank.core.service.client;

import app.bank.common.domain.model.Client;
import app.bank.core.service.CommandService;
import app.bank.core.service.QueryService;

public interface ClientService extends QueryService<Client>, CommandService<Client> {

    boolean existsByPhone(String phone);

    Client getByPhone(String phone);

}

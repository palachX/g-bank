package app.bank.gbank.service.client;

import app.bank.gbank.domain.model.Client;
import app.bank.gbank.service.QueryService;

import java.util.Optional;

public interface ClientQueryService extends QueryService<Client> {

    boolean existsByPhone(String phone);
    Client getByPhone(String phone);

}

package app.bank.core.service.client;

import app.bank.common.domain.model.Client;
import app.bank.core.service.QueryService;

public interface ClientQueryService extends QueryService<Client> {

    boolean existsByPhone(String phone);

    Client getByPhone(String phone);

}

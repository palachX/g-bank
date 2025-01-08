package app.bank.common.service.client;

import app.bank.common.domain.model.Client;
import app.bank.common.service.QueryService;

import java.util.UUID;

public interface ClientQueryService extends QueryService<Client> {

    boolean existsByPhone(String phone);

    Client getByPhone(String phone);

    Client getByAccount(UUID accountId);

}

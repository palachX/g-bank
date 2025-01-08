package app.bank.eventhandler.service.client;

import app.bank.common.domain.model.Account;
import app.bank.common.domain.model.Client;
import app.bank.common.repository.ClientRepository;
import app.bank.eventhandler.service.account.AccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final AccountService accountService;
    private final ClientRepository repository;

    @Override
    @Transactional
    public Client create(Client client) {
        Account account = new Account();
        var accountCreate = accountService.create(account);
        client.setAccount(accountCreate);
        return repository.save(client);
    }

    @Override
    @Transactional
    public void addCard(
            final UUID clientId,
            final UUID cardId
    ) {
        repository.addCard(
                clientId,
                cardId
        );
    }


}

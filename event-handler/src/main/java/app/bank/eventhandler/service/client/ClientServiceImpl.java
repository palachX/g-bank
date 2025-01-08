package app.bank.eventhandler.service.client;

import app.bank.common.domain.model.Account;
import app.bank.common.domain.model.Client;
import app.bank.common.repository.ClientRepository;
import app.bank.eventhandler.service.account.AccountService;
import app.bank.eventhandler.service.client.ClientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;
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
        account = accountService.create(account);
        client.setAccount(account);
        return repository.save(client);
    }

    @Override
    @Transactional
    public void addCard(
            final UUID clientId,
            final UUID cardId
    ) {
        repository.addCard(
                clientId.toString(),
                cardId.toString()
        );
    }


}

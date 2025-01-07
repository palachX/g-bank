package app.bank.eventhandler.service.client;

import app.bank.common.domain.model.Account;
import app.bank.common.domain.model.Client;
import app.bank.common.repository.ClientRepository;
import app.bank.eventhandler.service.account.AccountService;
import app.bank.eventhandler.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final AccountService accountService;
    private final ClientRepository repository;

    @Override
    public Client create(Client client) {
        Account account = new Account();
        account = accountService.create(account);
        client.setAccount(account);
        return repository.save(client);
    }
}

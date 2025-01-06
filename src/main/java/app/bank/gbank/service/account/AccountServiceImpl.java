package app.bank.gbank.service.account;

import app.bank.gbank.domain.model.Account;
import app.bank.gbank.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountQueryService accountQueryService;
    private final AccountCommandService accountCommandService;

    @Override
    public void create(Account object) {
        accountCommandService.create(object);
    }

    @Override
    public Account getById(UUID id) {
        return accountQueryService.getById(id);
    }
}

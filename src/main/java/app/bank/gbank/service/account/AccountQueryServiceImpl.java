package app.bank.gbank.service.account;

import app.bank.gbank.domain.exception.ResourceNotFoundException;
import app.bank.gbank.domain.model.Account;
import app.bank.gbank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountQueryServiceImpl implements AccountQueryService {

    private final AccountRepository accountRepository;

    @Override
    public Account getById(UUID id) {
        return accountRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

}

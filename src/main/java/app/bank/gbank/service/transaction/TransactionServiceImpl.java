package app.bank.gbank.service.transaction;

import app.bank.gbank.domain.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private TransactionQueryService transactionQueryService;
    private TransactionCommandService transactionCommandService;

    @Override
    public void create(Transaction object) {
        transactionCommandService.create(object);
    }

    @Override
    public Transaction getById(UUID id) {
        return transactionQueryService.getById(id);
    }
}

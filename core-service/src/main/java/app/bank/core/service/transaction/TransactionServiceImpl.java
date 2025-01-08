package app.bank.core.service.transaction;

import app.bank.common.domain.model.Transaction;
import app.bank.common.service.transaction.TransactionQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionQueryService transactionQueryService;
    private final TransactionCommandService transactionCommandService;

    @Override
    public void create(Transaction object) {
        transactionCommandService.create(object);
    }

    @Override
    public Transaction getById(UUID id) {
        return transactionQueryService.getById(id);
    }
}

package app.bank.gbank.service.transaction;

import app.bank.gbank.domain.exception.ResourceNotFoundException;
import app.bank.gbank.domain.model.Transaction;
import app.bank.gbank.repository.TransactionRepository;
import app.bank.gbank.service.transaction.TransactionQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionQueryServiceImpl implements TransactionQueryService {

    private final TransactionRepository transactionRepository;

    @Override
    public Transaction getById(UUID id) {
        return transactionRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

}

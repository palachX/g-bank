package app.bank.core.service.transaction;

import app.bank.common.domain.exception.ResourceNotFoundException;
import app.bank.common.domain.model.Transaction;
import app.bank.common.repository.TransactionRepository;
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

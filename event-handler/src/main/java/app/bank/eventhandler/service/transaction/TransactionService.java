package app.bank.eventhandler.service.transaction;

import app.bank.common.domain.model.Transaction;

public interface TransactionService {

    Transaction create(Transaction transaction);

}

package app.bank.gbank.service.transaction;

import app.bank.gbank.domain.model.Transaction;
import app.bank.gbank.service.CommandService;
import app.bank.gbank.service.QueryService;

public interface TransactionService extends QueryService<Transaction>, CommandService<Transaction> {
}

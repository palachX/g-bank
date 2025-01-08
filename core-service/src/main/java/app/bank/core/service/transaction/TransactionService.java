package app.bank.core.service.transaction;

import app.bank.common.domain.model.Transaction;
import app.bank.common.service.CommandService;
import app.bank.common.service.QueryService;

public interface TransactionService extends QueryService<Transaction>, CommandService<Transaction> {
}

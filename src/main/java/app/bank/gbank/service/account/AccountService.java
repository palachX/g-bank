package app.bank.gbank.service.account;

import app.bank.gbank.domain.model.Account;
import app.bank.gbank.service.CommandService;
import app.bank.gbank.service.QueryService;

public interface AccountService extends QueryService<Account>, CommandService<Account> {
}

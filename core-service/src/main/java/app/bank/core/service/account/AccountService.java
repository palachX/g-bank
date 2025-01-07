package app.bank.core.service.account;

import app.bank.common.domain.model.Account;
import app.bank.core.service.CommandService;
import app.bank.core.service.QueryService;

public interface AccountService extends QueryService<Account>, CommandService<Account> {
}

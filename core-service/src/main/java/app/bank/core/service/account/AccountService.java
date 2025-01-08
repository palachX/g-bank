package app.bank.core.service.account;

import app.bank.common.domain.model.Account;
import app.bank.common.service.CommandService;
import app.bank.common.service.QueryService;

public interface AccountService extends QueryService<Account>, CommandService<Account> {
}

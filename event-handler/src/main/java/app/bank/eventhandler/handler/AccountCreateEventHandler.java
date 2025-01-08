package app.bank.eventhandler.handler;

import app.bank.common.domain.model.Account;
import app.bank.common.events.AccountCreateEvent;
import app.bank.eventhandler.service.account.AccountService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("ACCOUNT_CREATE")
@RequiredArgsConstructor
public class AccountCreateEventHandler implements EventHandler {

    private final AccountService accountService;
    private final Gson gson;

    @Override
    @Transactional
    public void handle(final JsonObject object, final Acknowledgment acknowledgment) {
        AccountCreateEvent event = gson.fromJson(
                object,
                AccountCreateEvent.class
        );

        Account account = gson.fromJson(
                (String) event.getPayload(),
                Account.class
        );

        accountService.create(account);
        acknowledgment.acknowledge();
    }
}

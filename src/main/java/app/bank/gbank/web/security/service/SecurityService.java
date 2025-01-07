package app.bank.gbank.web.security.service;

import app.bank.gbank.domain.model.Card;
import app.bank.gbank.web.security.SecurityUser;

import java.util.UUID;

public interface SecurityService {

    SecurityUser getUserFromRequest();

    boolean canAccessClient(UUID clientId);

    boolean canAccessCard(UUID cardId);

    boolean canAccessCard(Card card);

    boolean canAccessTransaction(UUID transactionId);

}

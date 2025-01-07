package app.bank.core.web.security.service;

import app.bank.common.domain.model.Card;
import app.bank.core.web.security.SecurityUser;

import java.util.UUID;

public interface SecurityService {

    SecurityUser getUserFromRequest();

    boolean canAccessClient(UUID clientId);

    boolean canAccessCard(UUID cardId);

    boolean canAccessCard(Card card);

    boolean canAccessTransaction(UUID transactionId);

}

package app.bank.core.web.security.service;

import app.bank.common.domain.exception.ResourceNotFoundException;
import app.bank.common.domain.model.Card;
import app.bank.common.domain.model.Client;
import app.bank.common.domain.model.Transaction;
import app.bank.core.service.card.CardService;
import app.bank.core.service.client.ClientService;
import app.bank.core.service.transaction.TransactionService;
import app.bank.core.web.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("ssi")
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final ClientService clientService;
    private final CardService cardService;
    private final TransactionService transactionService;

    @Override
    public SecurityUser getUserFromRequest() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.isAuthenticated()) {
            return null;
        }
        if (authentication.getPrincipal().equals("anonymousUser")) {
            return null;
        }

        return (SecurityUser) authentication.getPrincipal();
    }

    @Override
    public boolean canAccessClient(UUID clientId) {
        SecurityUser user = getUserFromRequest();
        UUID id = user.getId();
        return clientId.equals(id);
    }

    @Override
    public boolean canAccessCard(UUID cardId) {
        SecurityUser user = getUserFromRequest();
        UUID id = user.getId();
        Client client = clientService.getById(id);
        //TODO refactor to use repository
        return client.getCards().stream().allMatch(card -> card.getId().equals(cardId));
    }

    @Override
    public boolean canAccessCard(Card card) {
        try {
            Card foundCard = cardService.getByNumberAndDateAndCvv(card.getNumber(), card.getDateExpiration(), card.getCvv());
            return canAccessCard(foundCard.getId());
        } catch (ResourceNotFoundException e) {
            return false;
        }
    }

    @Override
    public boolean canAccessTransaction(UUID transactionId) {
        SecurityUser user = getUserFromRequest();
        UUID id = user.getId();
        Client client = clientService.getById(id);
        Transaction transaction = transactionService.getById(transactionId);
        //TODO refactor to use repository
        return client.getCards().contains(transaction.getFrom()) || client.getCards().contains(transaction.getTo());
    }
}

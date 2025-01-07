package app.bank.eventhandler.service.card;

import app.bank.common.domain.model.Card;

import java.math.BigDecimal;
import java.util.UUID;

public interface CardService {

    Card create(Card card);

    Card getById(UUID cardId);

    void add(Card card, BigDecimal bigDecimal);

    void addTransaction(UUID cardId, UUID transactionId);
}

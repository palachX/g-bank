package app.bank.gbank.service.card;

import app.bank.gbank.domain.model.Card;
import app.bank.gbank.service.CommandService;
import app.bank.gbank.service.QueryService;

import java.util.Date;
import java.util.UUID;

public interface CardService extends QueryService<Card>, CommandService<Card> {

    void createByClientId(UUID id);

    boolean existsByNumberAndDate(String number, Date dateExpiration);
}

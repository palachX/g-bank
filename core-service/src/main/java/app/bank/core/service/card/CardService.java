package app.bank.core.service.card;

import app.bank.common.domain.model.Card;
import app.bank.common.service.CommandService;
import app.bank.common.service.QueryService;

import java.util.Date;
import java.util.UUID;

public interface CardService extends QueryService<Card>, CommandService<Card> {

    void createByClientId(UUID id);

    boolean existsByNumberAndDate(String number, Date dateExpiration);

    Card getByNumberAndDateAndCvv(
            String number,
            Date date,
            String cvv
    );

    Card getByNumberAndDate(
            String number,
            Date date
    );
}

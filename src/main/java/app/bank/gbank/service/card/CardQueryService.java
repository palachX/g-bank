package app.bank.gbank.service.card;

import app.bank.gbank.domain.model.Card;
import app.bank.gbank.service.QueryService;

import java.util.Date;

public interface CardQueryService extends QueryService<Card> {

    boolean existsByNumberAndDate(String number, Date dateExpiration);

    Card getByNumberAndDateAndCvv(String number, Date date, String cvv);

}

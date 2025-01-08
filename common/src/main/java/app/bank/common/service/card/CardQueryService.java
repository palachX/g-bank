package app.bank.common.service.card;

import app.bank.common.domain.model.Card;
import app.bank.common.service.QueryService;

import java.util.Date;

public interface CardQueryService extends QueryService<Card> {

    boolean existsByNumberAndDate(String number, Date dateExpiration);

    Card getByNumberAndDateAndCvv(String number, Date date, String cvv);

    Card getByNumberAndDate(String number, Date date);

}

package app.bank.core.service.card;

import app.bank.common.domain.model.Card;
import app.bank.core.service.QueryService;

import java.util.Date;

public interface CardQueryService extends QueryService<Card> {

    boolean existsByNumberAndDate(String number, Date dateExpiration);

    Card getByNumberAndDateAndCvv(String number, Date date, String cvv);

}

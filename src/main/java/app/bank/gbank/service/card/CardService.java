package app.bank.gbank.service.card;

import app.bank.gbank.domain.model.Card;
import app.bank.gbank.service.CommandService;
import app.bank.gbank.service.QueryService;

public interface CardService extends QueryService<Card>, CommandService<Card> {
}

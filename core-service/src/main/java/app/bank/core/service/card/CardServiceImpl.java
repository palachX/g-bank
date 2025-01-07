package app.bank.core.service.card;

import app.bank.common.domain.model.Card;
import app.bank.common.domain.model.Client;
import app.bank.core.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final ClientService clientService;
    private final CardQueryService cardQueryService;
    private final CardCommandService cardCommandService;

    @Override
    public void create(Card object) {
        cardCommandService.create(object);
    }

    @Override
    public Card getById(UUID id) {
        return cardQueryService.getById(id);
    }

    @Override
    public void createByClientId(UUID id) {
        Client client = clientService.getById(id);
        Card card = new Card(client.getAccount());
        cardCommandService.create(card);
    }

    @Override
    public boolean existsByNumberAndDate(String number, Date dateExpiration) {
        return cardQueryService.existsByNumberAndDate(number, dateExpiration);
    }

    @Override
    public Card getByNumberAndDateAndCvv(String number, Date date, String cvv) {
        return cardQueryService.getByNumberAndDateAndCvv(number, date, cvv);
    }
}

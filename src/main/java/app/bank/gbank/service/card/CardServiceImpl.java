package app.bank.gbank.service.card;

import app.bank.gbank.domain.model.Card;
import app.bank.gbank.domain.model.Client;
import app.bank.gbank.service.client.ClientService;
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
}

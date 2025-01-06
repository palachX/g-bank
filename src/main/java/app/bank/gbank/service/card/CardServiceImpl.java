package app.bank.gbank.service.card;

import app.bank.gbank.domain.model.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private CardQueryService cardQueryService;
    private CardCommandService cardCommandService;

    @Override
    public void create(Card object) {
        cardCommandService.create(object);
    }

    @Override
    public Card getById(UUID id) {
        return cardQueryService.getById(id);
    }
}

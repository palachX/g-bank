package app.bank.gbank.service.card;

import app.bank.gbank.domain.exception.ResourceNotFoundException;
import app.bank.gbank.domain.model.Card;
import app.bank.gbank.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardQueryServiceImpl implements CardQueryService {

    private final CardRepository cardRepository;

    @Override
    public Card getById(UUID id) {
        return cardRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public boolean existsByNumberAndDate(String number, Date dateExpiration) {
        return cardRepository.existsByNumberAndDate(number, dateExpiration);
    }

    @Override
    public Card getByNumberAndDateAndCvv(String number, Date date, String cvv) {
        return cardRepository.getByNumberAndDateAndCvv(number, date, cvv).orElseThrow(ResourceNotFoundException::new);
    }
}

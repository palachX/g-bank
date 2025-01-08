package app.bank.eventhandler.service.card;

import app.bank.common.domain.exception.ResourceNotFoundException;
import app.bank.common.domain.model.Card;
import app.bank.common.domain.model.Client;
import app.bank.common.repository.CardRepository;
import app.bank.common.service.client.ClientQueryService;
import app.bank.eventhandler.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository repository;
    private final ClientQueryService clientQueryService;
    private final ClientService clientService;

    @Override
    public Card create(Card card) {

        card.setDateExpiration(getUtilDate());
        card.setNumber(generateNumber());
        card.setCvv(generateCvv());
        repository.save(card);

        Client client = clientQueryService.getByAccount(
                card.getAccount().getId()
        );
        clientService.addCard(client.getId(), card.getId());
        return card;
    }

    private String generateCvv() {
        return String.format("%03d", new Random().nextInt(1000));
    }

    private String generateNumber() {
        Random random = new Random();
        return String.format("%04d %04d %04d %04d",
                random.nextInt(10000),
                random.nextInt(10000),
                random.nextInt(10000),
                random.nextInt(10000));
    }

    private Date getUtilDate() {
        LocalDate now = LocalDate.now();
        var dateExpiration = now.plusYears(5);
        return Date.from(dateExpiration.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public Card getById(
            final UUID id
    ) {
        return repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    @Transactional
    public void add(
            final Card card,
            final BigDecimal amount
    ) {
        card.getAccount().setBalance(
                card.getAccount().getBalance().add(amount)
        );
        repository.save(card);
    }

    @Override
    @Transactional
    public void addTransaction(
            final UUID cardId,
            final UUID transactionId
    ) {
        repository.addTransaction(
                cardId.toString(),
                transactionId.toString()
        );
    }

}

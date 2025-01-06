package app.bank.gbank.web.controller;

import app.bank.gbank.domain.model.Card;
import app.bank.gbank.domain.model.Transaction;
import app.bank.gbank.service.card.CardService;
import app.bank.gbank.web.dto.CardDto;
import app.bank.gbank.web.dto.TransactionDto;
import app.bank.gbank.web.dto.mapper.CardMapper;
import app.bank.gbank.web.dto.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cards")
public class CardController {

    private final CardService cardService;
    private final CardMapper cardMapper;
    private final TransactionMapper transactionMapper;

    @PostMapping
    public void create() {
        //TODO implement
        UUID id = UUID.randomUUID();
        cardService.createByClientId(id);
    }

    @GetMapping("/{id}")
    public CardDto getId(@PathVariable final UUID id) {
        Card card = cardService.getById(id);
        return cardMapper.toDto(card);
    }

    @GetMapping("/{id}/transactions")
    public List<TransactionDto> getTransactions(@PathVariable final UUID id) {
        Card card = cardService.getById(id);
        return transactionMapper.toDto(card.getTransactions());
    }

}

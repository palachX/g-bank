package app.bank.core.web.controller;

import app.bank.common.domain.model.Card;
import app.bank.core.service.card.CardService;
import app.bank.core.web.dto.CardDto;
import app.bank.core.web.dto.TransactionDto;
import app.bank.core.web.dto.mapper.CardMapper;
import app.bank.core.web.dto.mapper.TransactionMapper;
import app.bank.core.web.security.SecurityUser;
import app.bank.core.web.security.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cards")
public class CardController {

    private final CardService cardService;
    private final SecurityService securityService;
    private final CardMapper cardMapper;
    private final TransactionMapper transactionMapper;

    @PostMapping
    public void create() {
        SecurityUser user = securityService.getUserFromRequest();
        cardService.createByClientId(user.getId());
    }

    @GetMapping("/{id}")
    @PreAuthorize("@ssi.canAccessCard(#id)")
    public CardDto getId(@PathVariable final UUID id) {
        Card card = cardService.getById(id);
        return cardMapper.toDto(card);
    }

    @GetMapping("/{id}/transactions")
    @PreAuthorize("@ssi.canAccessCard(#id)")
    public List<TransactionDto> getTransactions(@PathVariable final UUID id) {
        Card card = cardService.getById(id);
        return transactionMapper.toDto(card.getTransactions());
    }

}

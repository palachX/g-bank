package app.bank.core.web.controller;

import app.bank.common.domain.model.Transaction;
import app.bank.core.service.card.CardService;
import app.bank.core.service.transaction.TransactionService;
import app.bank.core.web.dto.OnCreate;
import app.bank.core.web.dto.TransactionDto;
import app.bank.core.web.dto.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final CardService cardService;
    private final TransactionMapper transactionMapper;

    @PostMapping
    @PreAuthorize("@ssi.canAccessCard(#transactionDto.from)")
    public void create(@RequestBody @Validated(OnCreate.class) final TransactionDto transactionDto) {
        if (!cardService.existsByNumberAndDate(
                transactionDto.getTo().getNumber(),
                transactionDto.getTo().getDateExpiration()
        )) {
            throw new IllegalStateException("Card not found");
        }

        Transaction transaction = transactionMapper.toEntity(transactionDto);
        transactionService.create(transaction);
    }

    @GetMapping("/{id}")
    @PreAuthorize("@ssi.canAccessTransaction(#id)")
    public TransactionDto getById(@PathVariable final UUID id) {
        Transaction transaction = transactionService.getById(id);
        return transactionMapper.toDto(transaction);
    }

}

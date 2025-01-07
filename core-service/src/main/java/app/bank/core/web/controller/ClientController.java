package app.bank.core.web.controller;

import app.bank.common.domain.model.Client;
import app.bank.core.service.client.ClientService;
import app.bank.core.web.dto.AccountDto;
import app.bank.core.web.dto.CardDto;
import app.bank.core.web.dto.ClientDto;
import app.bank.core.web.dto.mapper.AccountMapper;
import app.bank.core.web.dto.mapper.CardMapper;
import app.bank.core.web.dto.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;
    private final CardMapper cardMapper;
    public final AccountMapper accountMapper;

    @GetMapping("/{id}")
    @PreAuthorize("@ssi.canAccessClient(#id)")
    public ClientDto getById(@PathVariable final UUID id) {
        Client client = clientService.getById(id);
        return clientMapper.toDto(client);
    }

    @GetMapping("/{id}/cards")
    @PreAuthorize("@ssi.canAccessClient(#id)")
    public List<CardDto> getCards(@PathVariable final UUID id) {
        Client client = clientService.getById(id);
        return cardMapper.toDto(client.getCards());
    }

    @GetMapping("/{id}/account")
    @PreAuthorize("@ssi.canAccessClient(#id)")
    public AccountDto getAccount(@PathVariable final UUID id) {
        Client client = clientService.getById(id);
        return accountMapper.toDto(client.getAccount());
    }

}

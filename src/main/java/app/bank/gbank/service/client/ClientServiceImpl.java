package app.bank.gbank.service.client;

import app.bank.gbank.domain.model.Client;
import app.bank.gbank.service.client.ClientCommandService;
import app.bank.gbank.service.client.ClientQueryService;
import app.bank.gbank.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientQueryService clientQueryService;
    private final ClientCommandService clientCommandService;

    @Override
    public void create(Client object) {
        clientCommandService.create(object);
    }

    @Override
    public Client getById(UUID id) {
        return clientQueryService.getById(id);
    }

    @Override
    public boolean existsByPhone(String phone) {
        return clientQueryService.existsByPhone(phone);
    }
}

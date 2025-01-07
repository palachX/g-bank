package app.bank.core.service.client;

import app.bank.common.domain.model.Client;
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

    @Override
    public Client getByPhone(String phone) {
        return clientQueryService.getByPhone(phone);
    }
}

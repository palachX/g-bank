package app.bank.core.service.client;

import app.bank.common.domain.exception.ResourceNotFoundException;
import app.bank.common.domain.model.Client;
import app.bank.common.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientQueryServiceImpl implements ClientQueryService {

    private final ClientRepository clientRepository;

    @Override
    public Client getById(UUID id) {
        return clientRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public boolean existsByPhone(String phone) {
        return clientRepository.existsByPhone(phone);
    }

    @Override
    public Client getByPhone(String phone) {
        return clientRepository.findByPhone(phone).orElseThrow(ResourceNotFoundException::new);
    }
}

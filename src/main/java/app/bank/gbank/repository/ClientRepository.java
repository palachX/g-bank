package app.bank.gbank.repository;

import app.bank.gbank.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

    boolean existsByPhone(String phone);

    Optional<Client> findByPhone(String phone);
}

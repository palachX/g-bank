package app.bank.common.repository;

import app.bank.common.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

    boolean existsByPhone(String phone);

    Optional<Client> findByPhone(String phone);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = """
            INSERT INTO clients_cards
            VALUES (:clientId, :cardId)
            """, nativeQuery = true
    )
    void addCard(@Param("clientId") UUID clientId, @Param("cardId") UUID cardId);

    Optional<Client> findByAccountId(UUID accountId);
}

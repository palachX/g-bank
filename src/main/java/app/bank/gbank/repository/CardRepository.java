package app.bank.gbank.repository;

import app.bank.gbank.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {

    @Query("SELECT c FROM Card c WHERE c.number = ?1 AND c.dateExpiration = ?2")
    boolean existsByNumberAndDate(String number, Date dateExpiration);

}

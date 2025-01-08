package app.bank.common.repository;

import app.bank.common.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {

    @Query(value ="SELECT c FROM Card c WHERE c.number = :number AND c.dateExpiration = :dateExpiration")
    boolean existsByNumberAndDate(String number, Date dateExpiration);

    @Query(value ="SELECT c FROM Card c WHERE c.number = :number AND c.dateExpiration = :date AND c.cvv = :cvv")
    Optional<Card> getByNumberAndDateAndCvv(String number, Date date, String cvv);

    @Query(value ="SELECT c FROM Card c WHERE c.number = :number AND c.dateExpiration = :date")
    Optional<Card> getByNumberAndDate(String number, Date date);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = """
            INSERT INTO cards_transactions
            VALUES (:cardId, :transactionId)
            """, nativeQuery = true)
    void addTransaction(
            @Param("cardId") String cardId,
            @Param("transactionId") String transactionId
    );

}

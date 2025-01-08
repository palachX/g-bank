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
    boolean existsByNumberAndDate(@Param("number") String number, @Param("dateExpiration") Date dateExpiration);

    @Query(value ="SELECT c FROM Card c WHERE c.number = :number AND c.dateExpiration = :date AND c.cvv = :cvv")
    Optional<Card> getByNumberAndDateAndCvv(@Param("number") String number, @Param("date") Date date, @Param("cvv") String cvv);

    @Query(value ="SELECT c FROM Card c WHERE c.number = :number AND c.dateExpiration = :date")
    Optional<Card> getByNumberAndDate(@Param("number")  String number, @Param("date") Date date);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = """
            INSERT INTO cards_transactions
            VALUES (:cardId, :transactionId)
            """, nativeQuery = true)
    void addTransaction(
            @Param("cardId") UUID cardId,
            @Param("transactionId") UUID transactionId
    );

}

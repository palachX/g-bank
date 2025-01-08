package app.bank.common.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Table(name = "cards")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue
    private UUID id;

    private String number;

    @Column(name = "date_expiration")
    private Date dateExpiration;

    private String cvv;

    @OneToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "transaction_id")
    )
    private List<Transaction> transactions;

    @ManyToOne
    private Account account;

    public Card(Account account) {
        this.account = account;
    }
}

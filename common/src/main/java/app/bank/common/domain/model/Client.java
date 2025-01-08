package app.bank.common.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Table(name = "clients")
@Entity
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String phone;
    private String password;

    @OneToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id")
    )
    private List<Card> cards;

    @OneToOne
    private Account account;

}

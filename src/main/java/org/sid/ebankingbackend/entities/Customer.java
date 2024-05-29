package org.sid.ebankingbackend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Stocke l'identifiant unique du client.
    private String name; // Stocke le nom du client.
    private String email; // Stocke l'adresse e-mail du client.
    @OneToMany(mappedBy = "customer") // quand vous avez une relation beredictionnelle dans vous allez utilise mappedBy
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<BankAccount> bankAccounts;
}
/*
*@OneToMany(mappedBy = "customer") :
Indique une relation One-to-Many entre Customer et BankAccount.
* Cela signifie qu'un client peut avoir plusieurs comptes bancaires.
*  L'attribut mappedBy = "customer" spécifie que la relation
* est gérée par l'attribut customer dans la classe
* BankAccount.
*
*
*
* @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
*
* Ce paramètre spécifie l'accès à la propriété pendant la sérialisation et la désérialisation.
* Dans ce cas, WRITE_ONLY indique que la propriété sera incluse lors de la sérialisation (écriture),
*  mais pas lors de la désérialisation (lecture).
*
*
* mappedBy = "customer"
* : Ce paramètre indique le nom de l'attribut dans l'entité BankAccount qui est utilisé pour mapper cette relation.
*  Dans notre cas, l'attribut customer dans la classe BankAccount est
* utilisé pour indiquer le client auquel appartient le compte bancaire.
*
* */
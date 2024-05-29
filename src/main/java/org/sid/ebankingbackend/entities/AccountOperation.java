package org.sid.ebankingbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.sid.ebankingbackend.enums.OperationType;


import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class AccountOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //  La génération de la clé primaire se fera à partir d’une identité propre au SGBD. Il utilise un type de colonne spéciale à la base de données.
    private Long id; // La génération de la clé primaire se fera à partir d’une identité propre au SGBD.
    private Date operationDate; // Date de l'opération bancaire.
    private double amount; // Montant de l'opération bancaire
    @Enumerated(EnumType.STRING) // Le type d'opération sera stocké sous forme de chaîne dans la base de données.
    private OperationType type;
    @ManyToOne // Indique une relation Many-to-One entre AccountOperation et BankAccount. Cela signifie qu'une opération bancaire est associée à un compte bancaire unique, mais un compte bancaire peut avoir plusieurs opérations bancaires.
    private BankAccount bankAccount;
    private String description;  // Description de l'opération bancaire.
}


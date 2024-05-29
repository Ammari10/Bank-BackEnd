package org.sid.ebankingbackend.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;



@Entity
@DiscriminatorValue("CA") // pour spécifier les valeurs discriminantes  current and saving
@Data @NoArgsConstructor @AllArgsConstructor
public class CurrentAccount extends BankAccount {
    private double overDraft;
}
/*
*@DiscriminatorValue("CA") :
     Spécifie la valeur discriminante pour cette sous-classe dans
*  la colonne discriminante définie dans la classe de base BankAccount
*  (@DiscriminatorColumn(name = "TYPE", length = 4)). Ici, "CA" est utilisé pour indiquer que
*  l'enregistrement est un CurrentAccount.
*
* private double overDraft :
Stocke le montant du découvert autorisé pour ce compte courant.
*  Le découvert est un crédit accordé par la banque,
*  permettant au titulaire du compte de dépenser plus que le solde disponible.
*

* Grâce à l'utilisation de @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
* dans la classe BankAccount, toutes les sous-classes (comme CurrentAccount)
* partagent une seule table dans la base de données. La colonne discriminante
*  (définie par @DiscriminatorColumn(name = "TYPE", length = 4))
*  stocke le type de chaque enregistrement en utilisant les valeurs spécifiées par
*  @DiscriminatorValue dans chaque sous-classe. Pour CurrentAccount, cette valeur est "CA".
*
* La classe CurrentAccount est une extension de BankAccount avec des fonctionnalités spécifiques
* aux comptes courants, comme le découvert autorisé. Les annotations JPA et Lombok utilisées
*  simplifient la définition de l'entité et son comportement, tout en intégrant cette classe
*  dans une stratégie d'héritage par table unique pour une gestion efficace des données
*
* */
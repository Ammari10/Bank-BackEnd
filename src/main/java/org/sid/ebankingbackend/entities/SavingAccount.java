package org.sid.ebankingbackend.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@DiscriminatorValue("SA")
@Data @NoArgsConstructor @AllArgsConstructor
public class SavingAccount extends BankAccount { // Cette classe SavingAccount étend la classe BankAccount, ce qui signifie qu'elle hérite de toutes ses propriétés et méthodes.
    private double interestRate; // Ce champ stocke le taux d'intérêt associé au compte d'épargne
    // C'est une caractéristique spécifique aux comptes d'épargne, qui peut être utilisée pour calculer les intérêts gagnés sur le solde du compte
}


 /*
@Entity :
Cette annotation indique que la classe SavingAccount est une entité JPA,
 ce qui signifie qu'elle sera mappée à une table dans la base de données


@DiscriminatorValue("SA") :

Utilisé en conjonction avec @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
dans la classe de base BankAccount, cette annotation spécifie la valeur discriminante
 pour les instances de SavingAccount dans la colonne discriminante définie dans la table. Ici,
  "SA" est utilisé pour identifier les comptes d'épargne.


La classe SavingAccount est utilisée pour représenter
 des comptes d'épargne dans le système bancaire.
  Elle hérite des caractéristiques générales des comptes bancaires de la classe BankAccount,
   tout en ajoutant la spécificité des comptes d'épargne avec le champ interestRate.
    Cette conception permet de modéliser différentes types de comptes bancaires de manière efficace dans une
     application de gestion bancaire.

  */
package org.sid.ebankingbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.ebankingbackend.enums.AccountStatus;


import java.util.Date;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // mais juste pour lui single table per class sil nest pas abstraite et lui creer une table    La classe BankAccount est l'entité de base et est annotée avec @Inheritance(strategy = InheritanceType.SINGLE_TABLE) pour indiquer que l'héritage utilise une table unique.
@DiscriminatorColumn(name = "TYPE",length = 4) //  Spécifie la colonne discriminatrice qui stocke le type d'entité.

@Data @NoArgsConstructor @AllArgsConstructor
public abstract class BankAccount { // si la class bankAcount n est pas abstract ca veut dire pourlui il faut egalement une table en realite dans notre cas quand vous tilise l heritage de la classe abstract,,,, le fait d ajouter abstract ici la il va comprendre qu il ne devrait pas cree une table pour les classe derive
    @Id
    private String id;
    private double balance;
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    @ManyToOne // un compte concerne plusiuer client mais un client par avoir plusiuer compte ... plusiuer compte pour un client
    private Customer customer; // un compte appartient un client

    @OneToMany(mappedBy = "bankAccount",fetch = FetchType.LAZY) // un compte vous avoir plusiuer operation
    private List<AccountOperation> accountOperations; // un compte appartient plusieur operation
}


/* ...
'entité BankAccount définie dans le package org.sid.ebankingbackend.
entities représente un compte bancaire dans une application de gestion bancaire.
Elle utilise diverses annotations JPA et Lombok pour définir les propriétés et le comportement de l'entité.
Voici une explication détaillée de chaque élément de cette classe :

Annotations de classe
@Entity :
Indique que cette classe est une entité JPA et qu'elle doit être mappée à une table dans la base de données.

@Inheritance(strategy = InheritanceType.SINGLE_TABLE) :
Spécifie que cette classe utilise une stratégie d'héritage par table unique.
 Cela signifie que toutes les classes dérivées de BankAccount seront stockées dans une seule table dans la base de données.
  La classe BankAccount est la classe de base de cette hiérarchie d'héritage.

@DiscriminatorColumn(name = "TYPE", length = 4) :
Indique la colonne discriminatrice TYPE qui stocke le type d'entité.
La longueur de cette colonne est définie à 4 caractères.
Cette colonne permet de différencier les sous-types de BankAccount dans la table unique.

Annotations de Lombok :
@Data : Génère automatiquement les méthodes getter et setter pour tous les champs, ainsi que les méthodes equals(), hashCode(), toString(), et les constructeurs requis.
@NoArgsConstructor : Génère un constructeur sans arguments.
@AllArgsConstructor : Génère un constructeur avec un argument pour chaque champ de la classe.
Champs de la classe et annotations JPA

Identifiant primaire :
@Id : Indique que le champ id est la clé primaire de l'entité.
private String id : Stocke l'identifiant unique du compte bancaire.

Solde du compte :
private double balance : Stocke le solde actuel du compte bancaire.
Date de création :
private Date createdAt : Stocke la date de création du compte bancaire.
Statut du compte :

@Enumerated(EnumType.STRING) : Indique que le champ status est un énumérateur (enum) et qu'il doit être stocké sous forme
 de chaîne de caractères dans la base de données. L'énumération AccountStatus est utilisée pour définir les différents statuts
 du compte (par exemple, CREATED, ACTIVATED, SUSPENDED).

Relation avec Customer :
@ManyToOne : Indique une relation Many-to-One entre BankAccount et Customer. Cela signifie qu'un
 compte bancaire appartient à un client unique, mais un client peut avoir plusieurs comptes bancaires.
Liste des opérations du compte :
@OneToMany(mappedBy = "bankAccount", fetch = FetchType.LAZY) : Indique une relation
One-to-Many entre BankAccount et AccountOperation. Cela signifie qu'un compte bancaire peut avoir plusieurs opérations bancaires.
 Le champ mappedBy spécifie que le côté inverse de cette relation est géré par l'attribut bankAccount de
 la classe AccountOperation. fetch = FetchType.LAZY signifie que les opérations bancaires associées ne sont chargées
 que lorsqu'elles sont explicitement demandées.




*  */

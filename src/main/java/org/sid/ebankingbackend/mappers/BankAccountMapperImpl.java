package org.sid.ebankingbackend.mappers;

import org.sid.ebankingbackend.dtos.AccountOperationDTO;
import org.sid.ebankingbackend.dtos.CurrentBankAccountDTO;
import org.sid.ebankingbackend.dtos.CustomerDTO;
import org.sid.ebankingbackend.dtos.SavingBankAccountDTO;
import org.sid.ebankingbackend.entities.AccountOperation;
import org.sid.ebankingbackend.entities.CurrentAccount;
import org.sid.ebankingbackend.entities.Customer;
import org.sid.ebankingbackend.entities.SavingAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
@Service
public class BankAccountMapperImpl {
    public CustomerDTO fromCustomer(Customer customer){ // L'entité de domaine Customer qui doit être mappée vers un DTO.
        CustomerDTO customerDTO=new CustomerDTO(); // Crée une nouvelle instance de CustomerDTO
        BeanUtils.copyProperties(customer,customerDTO);
        /*
        BeanUtils.copyProperties(customer, customerDTO); :
         Utilise la méthode statique copyProperties de la classe BeanUtils pour copier les propriétés de l'objet customer
          vers l'objet customerDTO. Cette méthode copie les valeurs des
          attributs ayant les mêmes noms et types entre les deux  objets.
         */
        return  customerDTO; // : Retourne le CustomerDTO nouvellement créé avec les propriétés copiées.
    }
/*
La classe BankAccountMapperImpl est un composant Spring qui fournit des méthodes pour mapper
 des entités de domaine (comme Customer, CurrentAccount, SavingAccount, etc.)
  à leurs objets de transfert de données (DTOs) correspondants et vice versa.
  Les DTOs sont souvent utilisés pour transférer des données entre différentes couches d'une application sans exposer
  les entités de domaine directement.

  Annotations :
@Service : Cette annotation indique que la classe BankAccountMapperImpl est un service Spring.
 Elle est détectée par le conteneur Spring lors de l'analyse des composants,
  ce qui permet à cette classe d'être gérée par Spring comme un service singleton.


  Imports :
Les différents imports incluent les classes DTO (CustomerDTO, CurrentBankAccountDTO, SavingBankAccountDTO, AccountOperationDTO)
et les entités (Customer, CurrentAccount, SavingAccount, AccountOperation). Ces classes sont utilisées pour
 les opérations de mappage entre les entités et les DTOs.
 */

    public Customer fromCustomerDTO(CustomerDTO customerDTO){ // Paramètre de la méthode de type CustomerDTO, qui est l'objet DTO à partir duquel nous voulons mapper les données.
        Customer customer=new Customer(); // Crée une nouvelle instance de la classe Customer, qui est l'objet de domaine vers lequel nous mapperons les données du DTO.
        BeanUtils.copyProperties(customerDTO,customer);
        return  customer; // Retourne l'objet customer, qui contient maintenant les données mappées à partir de l'objet DTO customerDTO.
    }
/*
BeanUtils.copyProperties(customerDTO, customer); : Utilise la méthode statique copyProperties de la classe BeanUtils pour copier
 les propriétés de l'objet customerDTO (DTO) vers l'objet customer (domaine).
  Cette méthode copie les valeurs des attributs ayant
  les mêmes noms et types entre les deux objets.

  En résumé, la méthode fromCustomerDTO est utilisée pour mapper un objet CustomerDTO vers un objet
   Customer en copiant les propriétés correspondantes
 */


    public SavingBankAccountDTO fromSavingBankAccount(SavingAccount savingAccount){
     /*
        La méthode fromSavingBankAccount est utilisée pour mapper un objet de domaine de type SavingAccount vers un objet DTO (Data Transfer Object)
        de type SavingBankAccountDTO
      */
        SavingBankAccountDTO savingBankAccountDTO=new SavingBankAccountDTO();
        /*
         Crée une nouvelle instance de la classe SavingBankAccountDTO,
         qui est l'objet DTO vers lequel nous mapperons les données du compte d'épargne.

         */
        BeanUtils.copyProperties(savingAccount,savingBankAccountDTO);
        /*
        pour copier les propriétés de l'objet savingAccount (domaine) vers l'objet savingBankAccountDTO (DTO)
         */
        savingBankAccountDTO.setCustomerDTO(fromCustomer(savingAccount.getCustomer()));
        /*
         Appelle la méthode fromCustomer (probablement définie ailleurs) pour mapper l'objet
          Customer associé à l'objet savingAccount vers un objet CustomerDTO. Ensuite,
           définissez cet objet CustomerDTO dans l'objet SavingBankAccountDTO.
         */
        savingBankAccountDTO.setType(savingAccount.getClass().getSimpleName());
        /*
         Définit le type de compte en utilisant le nom simplifié de la classe SavingAccount.
         Cela peut être utile pour identifier le type de compte dans l'objet DTO.
         */
        return savingBankAccountDTO; // Retourne l'objet savingBankAccountDTO, qui contient maintenant les données mappées à partir de l'objet savingAccount.
    }


    public SavingAccount fromSavingBankAccountDTO(SavingBankAccountDTO savingBankAccountDTO){ // La méthode fromSavingBankAccountDTO est utilisée pour mapper un objet DTO  de type SavingBankAccountDTO vers un objet de domaine de type SavingAccount
        SavingAccount savingAccount=new SavingAccount(); //Crée une nouvelle instance de la classe SavingAccount, qui est l'objet de domaine vers lequel nous mapperons les données du DTO.
        BeanUtils.copyProperties(savingBankAccountDTO,savingAccount); //pier les propriétés de l'objet savingBankAccountDTO (DTO) vers l'objet savingAccount
        savingAccount.setCustomer(fromCustomerDTO(savingBankAccountDTO.getCustomerDTO())); //Appelle la méthode fromCustomerDTO pour mapper l'objet CustomerDTO associé à l'objet savingBankAccountDTO vers un objet Customer. Ensuite, définissez cet objet Customer dans l'objet SavingAccount.
        return savingAccount; // Retourne l'objet savingAccount, qui contient maintenant les données mappées à partir de l'objet savingBankAccountDTO.
    }

    public CurrentBankAccountDTO fromCurrentBankAccount(CurrentAccount currentAccount){
        CurrentBankAccountDTO currentBankAccountDTO=new CurrentBankAccountDTO();
        BeanUtils.copyProperties(currentAccount,currentBankAccountDTO);
        currentBankAccountDTO.setCustomerDTO(fromCustomer(currentAccount.getCustomer()));
        currentBankAccountDTO.setType(currentAccount.getClass().getSimpleName());
        return currentBankAccountDTO;
    }

    public CurrentAccount fromCurrentBankAccountDTO(CurrentBankAccountDTO currentBankAccountDTO){
        CurrentAccount currentAccount=new CurrentAccount();
        BeanUtils.copyProperties(currentBankAccountDTO,currentAccount);
        currentAccount.setCustomer(fromCustomerDTO(currentBankAccountDTO.getCustomerDTO()));
        return currentAccount;
    }

    public AccountOperationDTO fromAccountOperation(AccountOperation accountOperation){
        AccountOperationDTO accountOperationDTO=new AccountOperationDTO();
        BeanUtils.copyProperties(accountOperation,accountOperationDTO);
        return accountOperationDTO;
    }

}

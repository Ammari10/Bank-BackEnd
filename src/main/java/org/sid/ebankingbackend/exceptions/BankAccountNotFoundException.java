package org.sid.ebankingbackend.exceptions;

public class BankAccountNotFoundException extends Exception {
    public BankAccountNotFoundException(String message) {
        super(message);
    }
}

/*
La classe BankAccountNotFoundException est une exception personnalisée en Java qui est utilisée pour signaler que le compte bancaire recherché n'a pas été trouvé.
 Cette classe hérite de Exception, ce qui en fait une exception vérifiée (checked exception).


 Cette exception peut être utilisée dans des méthodes qui effectuent des opérations
 financières pour indiquer qu'une opération ne peut pas être
 effectuée en raison d'un solde insuffisant.
 */
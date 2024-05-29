package org.sid.ebankingbackend.exceptions;
public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
/*
Cette exception peut être utilisée dans des méthodes qui recherchent des clients.
Si un client avec l'identifiant donné n'est pas trouvé, l'exception est levée
 */
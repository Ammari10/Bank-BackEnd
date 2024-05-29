package org.sid.ebankingbackend.exceptions;

public class BalanceNotSufficientException extends Exception {
    public BalanceNotSufficientException(String message) {
        super(message);
    }
}

/*

La classe BalanceNotSufficientException est une classe personnalisée qui étend la classe Exception en Java.
 Cette classe est conçue pour être utilisée lorsque le solde d'un compte n'est pas suffisant pour effectuer une certaine opération,
  comme un retrait ou un paiement.


  BalanceNotSufficientException est une classe d'exception personnalisée.
   En héritant de la classe Exception, elle peut être utilisée comme une exception standard en Java,
    mais avec une sémantique spécifique à votre application.

    public BalanceNotSufficientException(String message) :
     Ce constructeur permet de créer une instance de BalanceNotSufficientException
      avec un message d'erreur spécifique.
      Ce message peut être utilisé pour fournir des détails sur la cause de l'exception.

      super(message) : L'appel à super(message) dans le constructeur transmet le message d'erreur à la classe parente
       Exception, qui gère le stockage et la récupération du message d'erreur.

       Cette exception peut être utilisée dans des méthodes qui effectuent des opérations financières
        pour indiquer qu'une opération ne peut pas être effectuée en raison d'un solde insuffisant
 */
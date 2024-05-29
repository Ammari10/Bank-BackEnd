package org.sid.ebankingbackend.enums;

public enum AccountStatus {
    CREATED, ACTIVATED, SUSPENDED
}
 /*
  L'énumération AccountStatus est utilisée pour définir les différents états possibles d'un compte.

  Voici les trois états définis dans cette énumération :
CREATED : Cet état indique que le compte a été créé mais n'est pas encore activé.
Il peut être en attente de vérification ou de configuration initiale.
ACTIVATED : Cet état signifie que le compte est complètement activé et que l'utilisateur peut l'utiliser sans restrictions.
SUSPENDED : Cet état signifie que le compte est suspendu, peut-être en raison d'une violation de politique,
 de non-paiement, ou pour d'autres raisons administratives. L'utilisateur ne peut généralement
 pas utiliser le compte tant que la suspension n'est pas levée.

 La classe Account utilise l'énumération AccountStatus pour gérer l'état d'un compte.

 accountId : Une chaîne de caractères qui identifie de manière unique le compte.
status : Une instance de AccountStatus qui représente l'état actuel du compte.
  */
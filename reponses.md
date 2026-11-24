\# TP1 — SOAP et WSDL



\## Partie B — Contract-first



\### Étape 5 — Générer le code depuis le WSDL



\*\*1. Dans ce WSDL, retrouvez l'opération, son message de fault et l'action SOAP à envoyer.\*\*



\- Opération : `emprunterLivre`

\- Message de fault : `LivreIndisponibleFault`

\- SOAPAction : `http://supnum.mr/bib/emprunterLivre`



\*\*2. Quelle est la signature de `emprunterLivre` dans `EmpruntPortType` ?\*\*



```java

EmpruntType emprunterLivre(String idAdherent, String isbn)

&#x20;   throws LivreIndisponibleFault;

```



\*\*3. Quel type Java a été généré pour `dateRetour` ? Comparez avec la partie A.\*\*



Le type Java généré est `XMLGregorianCalendar`, correspondant au type XML `xs:date`. Dans la partie A, la date était manipulée avec `LocalDate`.



\*\*4. Quel est le nom de la classe d'exception générée, et d'où vient ce nom dans le WSDL ?\*\*



La classe générée est `LivreIndisponibleFault`. Ce nom provient du fault défini dans le WSDL.



\### Étape 6 — Implémenter et comparer



\*\*1. Le WSDL publié est-il celui que vous avez fourni ? Contient-il le motif de l'ISBN et le type `xs:date` ?\*\*



Le WSDL publié est généré à partir du contrat fourni. Il contient le type `xs:date` et le motif de validation de l'ISBN défini dans le WSDL.



\*\*2. Avez-vous dû modifier `01-emprunter.xml` pour qu'il fonctionne ici ? Pourquoi ?\*\*



Oui, il faut adapter la requête SOAP au nouveau contrat, notamment l'adresse du service, le SOAPAction et la structure des données attendues.



\*\*3. Sans `@SchemaValidation`, ISBN `978-2-10` est-il refusé ? Et avec ? Quelle Fault obtenez-vous ?\*\*



Sans `@SchemaValidation`, la validation du schéma n'est pas automatiquement appliquée. Avec `@SchemaValidation`, l'ISBN ne respectant pas le motif défini dans le WSDL est refusé et provoque une erreur de validation SOAP.



\*\*4. Retirez `wsdlLocation` de l'annotation et redémarrez : qu'est-ce qui change dans le WSDL publié ?\*\*



Le WSDL publié est généré à partir des annotations Java. Il peut donc être différent du WSDL contractuel fourni initialement.



\## Conclusion — Choisir et rendre



\*\*1. Citez deux différences que vous avez observées entre le WSDL de la partie A et celui de la partie B.\*\*



\- En Code-first, le WSDL est généré à partir du code Java, tandis qu'en Contract-first, le WSDL est défini avant le code Java.

\- En Contract-first, les opérations et les types sont définis dans le contrat. En Code-first, ils dépendent principalement des classes et annotations Java.



\*\*2. Si on renomme le champ `dateRetour` dans le code, quel projet voit son contrat changer ? Quel risque pour les clients ?\*\*



En Code-first, le WSDL peut changer automatiquement si le champ est renommé dans le code Java. Cela peut rendre les clients utilisant l'ancien contrat incompatibles avec le service.



En Contract-first, le contrat reste stable tant que le WSDL n'est pas modifié, ce qui limite le risque d'incompatibilité pour les clients.



\*\*3. Quelle approche choisiriez-vous pour le service Paiement, appelé par Scolarité (.NET), Bibliothèque (PHP) et le portail (Node.js) ? Et pour un prototype interne de deux jours ?\*\*



Pour le service Paiement, je choisirais Contract-first, car plusieurs systèmes utilisant des langages différents doivent communiquer avec le même service. Le WSDL permet de définir un contrat commun.



Pour un prototype interne de deux jours, je choisirais Code-first, car cette approche est plus rapide et simple à mettre en place.




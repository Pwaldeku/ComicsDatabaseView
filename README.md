# Application "Simpsons Quotes"

### Auteur (3A 34) - Biau Alexandre

## Présentation

Simple projet démontrant l'utilisation d'une  structuration MVVM dans une application android codé en Java.

Cette application affiche des citations issues des "Simpsons"  et utilise l'API Rest de "SimpsonQuotes" permettant de recuperer sous format JSON une liste de citations aléatoires.
 
## Prérequis

 - Posséder android Studio
 - Une connection internet

##  Consignes respectées :

-   Clean Architecture & MVVM
-   Appels REST 
-   Ecrans : 2 activités, 2 fragments
-   Affichage d'une liste dans un RecyclerView
-   Affichage du détail d'un item de la liste
-   Animation RecyclerView

-   Fonctions supplémentaires :
    -   Barre de recherche
    -   Notifications Push
    -   Filtrage de la liste en fonction des noms des personnages 
    -   Filtrage de la liste en fonction des citations 
    -   Données Cache
    -  Gitflow propre (branche distante par souci de clareté)
```
https://github.com/Pwaldeku/DistantRepositoryForESIEAproject
```
##  Fonctionnalités:


### Ecran principal

 - Affiche la liste des citations avec une barre de recherche.
 - Animations lors du scroll de la liste.
 
![enter image description here](https://lh3.googleusercontent.com/4VLXFOgK7E2FB-MPM1HLml_975wwocDeCjT0eQwt8BHCpXPDzlk3-r1QZBZ3WXaOUP6T-JTmAyw4=s400)

![enter image description here](https://lh3.googleusercontent.com/GRLCFDhasQsw8klgW8etzYqBYgM2TqxbnSWeT7dp-jDDYiJq51cZ1-lR1kKK5BvXevRpjzU9td1g=s400)

### Ecran du détail de la citation

-   Affiche les différentes informations sur la citation
- Scrollview de la description
- Possibilité de faire disparaître l'image du personnage.

![enter image description here](https://lh3.googleusercontent.com/N8iuCvtERMzBv4k0PoKujY-wYerrCONYLsjNOVRwkHziZ0G_YFF0qE9yBzompGVeqfMH8XkojDz3=s400)


![enter image description here](https://lh3.googleusercontent.com/U233tc4eEu0UUu3wBBkkbJABqbHyxoJR9rL1fRrW30wCFF-rCSnOEjTPJd8EctPkrDfdTIEeMT-T=s400)


### Filtrage

 - Affiche la liste des citations : le mot saisie peut apparaître dans la citation tout comme dans le nom du personnage.

![
](https://lh3.googleusercontent.com/7sHvyrylZtII9-XTvRJFUmZ4AuGtyoxl25TXdAlrilHfVyl-pzR1cR5oh2addCVOcrkx0gR2I9jJ=s400)
 
![enter image description here](https://lh3.googleusercontent.com/PNAZpljbB6_e5WSKynxouOktlzgsClX1GgJuuRrz0zTfDCd-er0tMSSNNqeu3hjwXQpiv-_r_K_3=s400)


### Cache

 - Affichage des données de l'application même hors ligne.
 
 ![enter image description here](https://lh3.googleusercontent.com/4VLXFOgK7E2FB-MPM1HLml_975wwocDeCjT0eQwt8BHCpXPDzlk3-r1QZBZ3WXaOUP6T-JTmAyw4=s400) 
 
### Notifications push

 - Envoi de notifications push via Firebase.
 
![enter image description here](https://lh3.googleusercontent.com/O2xxXXutJlruHqYCH0SD2rXL1k__Y46cTQ5Yj5R4wV5NyaG563U6QjKzujyRBlNLzDQC-JK2xq8e=s400)

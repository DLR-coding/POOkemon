#### Ne pas prendre en compte le package Joueur (ainsi que son contenu) car il n'est pas encore terminé.

## Choix de conception actuels
- Utilisation d'interface "EnsemblePokemon" et "Elements" pour respecter le principe Ouvert/Fermé des Principes SOLID : une
  classe doit être fermée à la modification de son comportement mais ouvert à l’extension.
- Pour le moment mettre la liste des noms de Pokemon dans une classe ListePokemon avec l'attribut de la liste des noms ainsi que la méthode "genererPokemon" en static pour pouvoir les utiliser sans créer d'instance de la classe ListePokemon. 



## Quelles fonctionnalités ont été implémentées 
- Pioche 
- MainDuJoueur
- Terrain
- Defausse
- Affinités

## Les difficultés rencontrées 
Le choix de conception : 
- dans la génération aléatoire de Pokemon ( faire dans le calsse Pokemon ? faire une classe à part ? )
- gestion de l'affichage
-( faire une classe Jeu pour gérer l'affichage et le potentiel reste ?)

## ce que nous planifions de faire pour le rendu suivant
coder : 
- l'affichage
- finaliser joueurs (et robots)
- déroulement de la partie
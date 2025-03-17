# Pokémon Battle Arena 🎮

Jeu de combat Pokémon en tour par tour pour deux joueurs, où les dresseurs déploient stratégiquement des Pokémon sur leur terrain. Le but est d'éliminer tous les Pokémon adverses en exploitant les affinités élémentaires et des tactiques de combat.

---

## 🎮 Fonctionnalités Principales

- **Combat stratégique** : Mécanique de type élémentaire (Feu, Eau, Terre, Air) avec avantages/désavantages et pouvoirs spéciaux (bonus) sur les Pokémon
- **Bot intelligent** : L'ordinateur priorise les cibles vulnérables
- **Génération procédurale** : Création aléatoire de Pokémons avec noms uniques, stats , affinités et 1 pouvoir ou pas
- **Interface console** : Affichage clair de l'état du jeu (terrains, mains, pioches)
- **Système de jeu complet** : 
  - Gestion des tours de jeu
  - Mécanique de placement stratégique
  - Système de victoire/défaite basé sur l'élimination

---

## 🔍 Aperçu du Jeu

### Écran de Jeu Typique
```console
********************************************************************************
Tour 3:
                                    Joueur 2

********************************************************************************

                                    Joueur 1

pioche: 15 pokemons
defausse: 0 pokemons
  *--------------------*    *--------------------*    *--------------------*
  | Attaque: 20        |    | Attaque: 40        |    | Attaque: 20        |
  | Vie: 50/120        |    | Vie: 50/150        |    | Vie: 50/130        |
  | Affinite : Air     |    | Affinite : Air     |    | Affinite : Feu     |
  |     Herbizarre     |    |     Florizarre     |    |     Salamèche      |
  *--------------------*    *--------------------*    *--------------------*

----------------------------------------------------------------------------------------------------

  *--------------------*    *--------------------*    *--------------------*
  |     Dracaufeu      |    |     Bulbizarre     |    |      Pikachu       |
  | Affinite : Feu     |    | Affinite : Eau     |    | Affinite : Terre   |
  | Vie: 50/180        |    | Vie: 50/150        |    | Vie: 50/100        |
  | Attaque: 40        |    | Attaque: 30        |    | Attaque: 10        |
  *--------------------*    *--------------------*    *--------------------*

En main:
- Reptincel, Feu, Vie: 160, Attaque: 20
- Carapuce, Eau, Vie: 100, Attaque: 40
- Tortank, Eau, Vie: 200, Attaque: 20
- Papilusion, Air, Vie: 120, Attaque: 20
- Roucool, Air, Vie: 150, Attaque: 30

Quel pokemon souhaitez-vous jouer? (Dracaufeu/Bulbizarre/Pikachu):
```

---

## 🎮 Règles du Jeu

### Mise en Place
1. Choix aléatoire du premier joueur
2. Pioches asymétriques (20 vs 21 cartes)
3. Tirage initial de 5 cartes
4. Placement de 3 Pokémon visibles sur le terrain

### Déroulement d'un Tour
1. **Pioche :** Remplir la main à 5 cartes
2. **Déploiement :** Compléter les emplacements vides
3. **Attaques :**
   - Joueur humain choisit les cibles
   - IA utilise une stratégie priorisant :
     1. Les affinités favorables
     2. Les Pokémon les plus faibles
     3. Choix aléatoire en cas d'égalité

### Mécaniques de Combat
- **Calcul des dégâts :**
  - Attaque de base ±10 selon les affinités
  - Pokémon KO envoyés à la défausse adverse

---

## 🛠️ Technologies Utilisées

- Java
- Génération aléatoire avec `java.util.Random`
- Gestion des entrées/sorties console
- POO : Héritage, Interfaces, Design Patterns

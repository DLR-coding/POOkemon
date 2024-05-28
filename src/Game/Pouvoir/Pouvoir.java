package Game.Pouvoir;

import Game.Pokemon;

public interface Pouvoir {
    void activatePouvoir(Pokemon p);

    /*
    2. Berserk, à utilisation unique : le Pokémon choisit un Pokémon de son camp (éventuellement lui-même). Pour le tour en cours, l'attaque de ce Pokémon est doublée.
    5. Régénération, à utilisation unique : le Pokémon choisit un Pokémon de son camp. Si le Pokémon a déjà utilisé un pouvoir à utilisation unique, il peut alors l'utiliser une seconde fois.
    6. Intimidation, à utilisation unique : le Pokémon choisit un Pokémon du camp adverse. Pour le prochain tour de l'adversaire, les dégats infligés par le Pokémon choisi sont réduits de moitié.
    7. Soin de zone, utilisable à chaque tour : chaque Pokémon de son camp regagne 10 points de vie.
    8. Extension du territoire, à utilisation unique : le terrain du joueur gagne un quatrième emplacement sur lequel il peut placer immédiatement un Pokémon de sa main. Lorsque le Pokémon qui a utilisé ce pouvoir meurt, son emplacement est perdu et le terrain possède de nouveau trois emplacements.

     */

}

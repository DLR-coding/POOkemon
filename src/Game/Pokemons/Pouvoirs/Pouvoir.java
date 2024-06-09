package Game.Pokemons.Pouvoirs;

import Game.Joueur.Player;
import Game.Pokemons.Pokemon;

public interface Pouvoir {

    void activatePouvoir(Pokemon p,Player j1, Player Robot,Player joueur);
    void RetourALanormal(Pokemon p,Player joueur);
    String getNomPouvoir();
    String description();

}

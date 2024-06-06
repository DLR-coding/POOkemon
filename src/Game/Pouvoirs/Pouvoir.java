package Game.Pouvoirs;

import Game.EnsemblePokemon.Terrain;
import Game.Joueur.Player;
import Game.Pokemon;

public interface Pouvoir {

    void activatePouvoir(Pokemon p,Player j1, Player Robot,Player joueur);
    void RetourALanormal(Pokemon p);
    String getNomPouvoir();

}

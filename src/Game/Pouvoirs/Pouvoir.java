package Game.Pouvoirs;

import Game.EnsemblePokemon.Terrain;
import Game.Joueur.Player;
import Game.Pokemon;

/**
 * L'interface Pouvoir définit le contrat pour tous les types de pouvoirs
 * pouvant être appliqués aux Pokémon dans le jeu.
 */
public interface Pouvoir {

    /**
     * Active le pouvoir sur un Pokémon spécifié.
     *
     * @param p le Pokémon sur lequel activer le pouvoir
     * @param j1 le joueur humain
     * @param Robot le joueur robot
     * @param joueur le joueur actuel
     */
    void activatePouvoir(Pokemon p,Player j1, Player Robot,Player joueur);

    /**
     * Ramène le Pokémon à son état normal après l'utilisation du pouvoir.
     *
     * @param p le Pokémon sur lequel le pouvoir a été activé
     * @param joueur le joueur actuel
     */
    void RetourALanormal(Pokemon p,Player joueur);

    /**
     * Obtient le nom du pouvoir.
     *
     * @return le nom du pouvoir
     */
    String getNomPouvoir();

    /**
     * Fournit une description détaillée du pouvoir.
     *
     * @return la description du pouvoir
     */
    String description();

}

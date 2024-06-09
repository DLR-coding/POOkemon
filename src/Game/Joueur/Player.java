package Game.Joueur;

import Game.EnsemblePokemon.Defausse;
import Game.EnsemblePokemon.MainDuJoueur;
import Game.EnsemblePokemon.Terrain;
import Game.Pokemon;

/**
 * L'interface Player représente un joueur dans le jeu.
 */
public interface Player {

    /**
     * Vérifie si le joueur est le joueur 1.
     *
     * @return vrai si le joueur est le joueur 1, sinon faux
     */
    boolean isJoueur1();

    /**
     * Définit si le joueur est le joueur 1.
     *
     * @param bool vrai si le joueur est le joueur 1, sinon faux
     */
    void setJoueur1(Boolean bool);

    /**
     * Pioche un Pokémon et l'ajoute à la main du joueur.
     *
     * @param pokemon le Pokémon à piocher
     */
    void piocherPokemon(Pokemon pokemon);

    /**
     * Obtient un Pokémon de la pioche à un index spécifié.
     *
     * @param index l'index du Pokémon
     * @return le Pokémon à l'index spécifié dans la pioche
     */
    Pokemon getPokemonFromPioche(int index);

    /**
     * Obtient un Pokémon de la main à un index spécifié.
     *
     * @param i l'index du Pokémon
     * @return le Pokémon à l'index spécifié dans la main
     */
    Pokemon getPokemonFromMain(int i);

    /**
     * Place un Pokémon sur le terrain.
     *
     * @param pokemon le Pokémon à placer sur le terrain
     */
    void placeSurTerrain(Pokemon pokemon);

    /**
     * Obtient la défausse du joueur.
     *
     * @return la défausse du joueur
     */
    Defausse getM_defausse();

    /**
     * Obtient la main du joueur.
     *
     * @return la main du joueur
     */
    MainDuJoueur getM_main();

    /**
     * Obtient le nom du joueur.
     *
     * @return le nom du joueur
     */
    String getM_nom();

    /**
     * Obtient le terrain du joueur.
     *
     * @return le terrain du joueur
     */
    Terrain getM_terrain();

    /**
     * Effectue un tour de jeu pour le joueur.
     *
     * @param adversaire le joueur adversaire
     * @return vrai si le tour est réussi, sinon faux
     */
    Boolean joue(Player adversaire);

    /**
     * Utilise le pouvoir d'un Pokémon à un index spécifié.
     *
     * @param index l'index du Pokémon dans le terrain
     * @return vrai si le pouvoir est utilisé, sinon faux
     */
    Boolean UtilisePouvoir(int index);
}
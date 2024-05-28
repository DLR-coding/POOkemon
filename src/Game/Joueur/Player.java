package Game.Joueur;

import Game.EnsemblePokemon.Defausse;
import Game.EnsemblePokemon.MainDuJoueur;
import Game.EnsemblePokemon.Terrain;
import Game.Pokemon;

public interface Player {
    boolean isJoueur1();

    void setJoueur1(Boolean bool);

    void piocherPokemon(Pokemon pokemon);

    Pokemon getPokemonFromPioche(int index);
    void placeSurTerrain(Pokemon pokemon);
    Defausse getM_defausse();
    MainDuJoueur getM_main();
    String getM_nom();
    Terrain getM_terrain();

    void joue(Player adversaire);




}

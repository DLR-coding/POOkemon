package Game.Joueur;

import Game.Pokemons.EnsemblePokemon.Defausse;
import Game.Pokemons.EnsemblePokemon.MainDuJoueur;
import Game.Pokemons.EnsemblePokemon.Terrain;
import Game.Pokemons.Pokemon;

public interface Player {
    boolean isJoueur1();

    void setJoueur1(Boolean bool);

    void piocherPokemon(Pokemon pokemon);

    Pokemon getPokemonFromPioche(int index);
    Pokemon getPokemonFromMain(int i);
    void placeSurTerrain(Pokemon pokemon);
    Defausse getM_defausse();
    MainDuJoueur getM_main();
    String getM_nom();
    Terrain getM_terrain();

    Boolean joue(Player adversaire);
    Boolean UtilisePouvoir(int index);




}

package Game.Joueur;

import Game.Pokemon;

public interface Player {
    boolean isJoueur1();

    void setJoueur1(Boolean bool);

    void piocherPokemon(Pokemon pokemon);

    Pokemon getPokemonFromPioche(int index);
    void placeSurTerrain(Pokemon pokemon);
}

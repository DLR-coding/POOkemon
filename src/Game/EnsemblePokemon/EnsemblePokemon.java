package Game.EnsemblePokemon;

import Game.Pokemon;

public interface EnsemblePokemon
{
        void ajouterPokemon(Pokemon pokemon);

        Pokemon getPokemon(int index);


        void retirerPokemon(Pokemon pokemon) ;
        //void transferPokemon(EnsemblePokemon destionation,Pokemon pokemon);
        Pokemon getPokemonByName(String name);
        int getNbPokemon();

}

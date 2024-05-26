package Game.EnsemblePokemon;

import Game.Pokemon;

import java.util.List;

public interface EnsemblePokemon
{
        Pokemon getPokemon(int index);

        void transferPokemon(Pokemon pokemon , EnsemblePokemon destination);
        Pokemon getPokemonByName(String name);
        int getNbPokemon();
        List<Pokemon> getEnsemble();

}

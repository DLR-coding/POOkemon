package Game.EnsemblePokemon;

import Game.Pokemon;

import java.util.List;

public abstract class EnsemblePokemon
{
        public abstract Pokemon getPokemon(int index);

        public abstract void transferPokemon(Pokemon pokemon, EnsemblePokemon destination);

        public abstract Pokemon getPokemonByName(String name);

        public abstract int getNbPokemon();

        public abstract List<Pokemon> getEnsemble();

}

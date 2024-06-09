package Game.Pokemons.EnsemblePokemon;

import Game.Pokemons.Pokemon;

import java.util.List;

public abstract class EnsemblePokemon
{
        public abstract Pokemon getPokemon(int index);

        public void transferPokemon(Pokemon pokemon, EnsemblePokemon destination)
        {
                if (!destination.getEnsemble().contains(pokemon) && this.getEnsemble().contains(pokemon)) {
                        destination.getEnsemble().add(pokemon);
                        this.getEnsemble().remove(pokemon);
                } else {
                        System.out.println("Le Pokémon invalide : déjà dans destination/pas dans source.");
                }
        }

        public abstract Pokemon getPokemonByName(String name);

        public abstract int getNbPokemon();

        public abstract List<Pokemon> getEnsemble();

}

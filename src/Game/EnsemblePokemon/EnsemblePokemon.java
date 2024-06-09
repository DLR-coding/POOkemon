package Game.EnsemblePokemon;

import Game.Pokemon;

import java.util.List;

/**
 * Classe abstraite représentant un ensemble de Pokémon. Cette classe définit les méthodes
 * essentielles pour manipuler une collection de Pokémon.
 */
public abstract class EnsemblePokemon
{
        /**
         * Récupère un Pokémon de l'ensemble en fonction de son index.
         *
         * @param index l'index du Pokémon à récupérer
         * @return le Pokémon à l'index spécifié
         */
        public abstract Pokemon getPokemon(int index);

        /**
         * Transfère un Pokémon de cet ensemble vers un autre ensemble.
         *
         * @param pokemon le Pokémon à transférer
         * @param destination l'ensemble de destination où le Pokémon sera transféré
         */
        public abstract void transferPokemon(Pokemon pokemon, EnsemblePokemon destination);

        /**
         * Récupère un Pokémon de l'ensemble en fonction de son nom.
         *
         * @param name le nom du Pokémon à récupérer
         * @return le Pokémon avec le nom spécifié, ou null s'il n'est pas trouvé
         */
        public abstract Pokemon getPokemonByName(String name);

        /**
         * Retourne le nombre de Pokémon dans l'ensemble.
         *
         * @return le nombre de Pokémon dans l'ensemble
         */
        public abstract int getNbPokemon();

        /**
         * Retourne la liste de tous les Pokémon dans l'ensemble.
         *
         * @return la liste de tous les Pokémon dans l'ensemble
         */
        public abstract List<Pokemon> getEnsemble();

}

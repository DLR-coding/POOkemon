package Game.EnsemblePokemon;

import Game.Pokemon;

public interface EnsemblePokemon
{
        void ajouterPokemon(Pokemon pokemon);

        Pokemon getPokemon(int index);

        void afficher();

        void retirerPokemon(Pokemon pokemon) ;
}

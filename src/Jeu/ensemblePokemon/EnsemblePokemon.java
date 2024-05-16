package Jeu.ensemblePokemon;
import Jeu.Pokemon;

public interface EnsemblePokemon
{
        void ajouterPokemon(int index, Pokemon pokemon);
        Pokemon getPokemon(int index);
        void afficher();

}

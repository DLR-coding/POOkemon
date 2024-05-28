package Game.EnsemblePokemon;

import Game.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class MainDuJoueur implements EnsemblePokemon
{
    private List<Pokemon> m_mainJoueur;

    public MainDuJoueur()
    {
        List<Pokemon> main = new ArrayList<>(3);
        m_mainJoueur = main;
    }



    @Override
    public Pokemon getPokemon(int index) {
        if (index >= 0 && index < m_mainJoueur.size()) {
            return m_mainJoueur.get(index);
        } else
        {
            System.out.println("Index invalide.");
            return null;
        }
    }


    @Override
    public void transferPokemon(Pokemon pokemon, EnsemblePokemon destination) {
        if (!destination.getEnsemble().contains(pokemon) && this.getEnsemble().contains(pokemon)) {
            destination.getEnsemble().add(pokemon);
            this.getEnsemble().remove(pokemon);
        } else {
            System.out.println("Le Pokémon invalide : déjà dans destination/pas dans source.");
        }

    }

    @Override
    public Pokemon getPokemonByName(String name) {
        return null;
    }

    @Override
    public int getNbPokemon() {
        return m_mainJoueur.size();
    }

    @Override
    public List<Pokemon> getEnsemble() {
        return m_mainJoueur;
    }

}

package Game.Pokemons.EnsemblePokemon;

import Game.Pokemons.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class MainDuJoueur extends EnsemblePokemon
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

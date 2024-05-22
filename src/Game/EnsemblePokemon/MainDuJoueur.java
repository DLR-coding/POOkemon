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
    public void ajouterPokemon(Pokemon pokemon)
    {
            m_mainJoueur.add(pokemon);

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
    public void afficher() {
        for (int i = 0; i < m_mainJoueur.size(); i++) {
            m_mainJoueur.get(i).presenter();
        }


    }

    @Override
    public void retirerPokemon(Pokemon pokemon) {
        m_mainJoueur.remove(pokemon);
    }

    @Override
    public Pokemon getPokemonByName(String name) {
        return null;
    }

    @Override
    public int getNbPokemon() {
        return m_mainJoueur.size();
    }

}

package Game.EnsemblePokemon;
import Game.Joueur.JoueurHumain;
import Game.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Pioche implements EnsemblePokemon {

    private List<Pokemon> m_pioche;

    public Pioche()
    {
        List<Pokemon> pioche = new ArrayList<>();
        m_pioche = pioche;
    }

    public Pioche(int nombreDePokemons)
    {
        List<Pokemon> pioche = new ArrayList<>();
        for (int i = 0; i < nombreDePokemons; i++) {
            pioche.add(ListePokemon.genererPokemon());
        }

        m_pioche = pioche;
    }


    @Override
    public void ajouterPokemon(Pokemon p)
    {
        m_pioche.add(p);
    }

    public void retirerPokemon(Pokemon p) {
        m_pioche.remove(p);
    }

    @Override
    public Pokemon getPokemon(int index) {
        if (index >= 0 && index < m_pioche.size()) {
            return m_pioche.get(index);
        } else {
            System.out.println("Index invalide.");
            return null;
        }
    }

    @Override
    public void afficher() {
        for (int i = 0; i < m_pioche.size(); i++) {
            if (m_pioche.get(i) != null) {
                m_pioche.get(i).presenter();
            } else {
                System.out.println("Pokemon à l'index " + (i+1) + ": vide");
            }
        }
    }
}



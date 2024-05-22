package Game.EnsemblePokemon;

import Game.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Defausse implements EnsemblePokemon{
    private List<Pokemon> m_defausse;

    public Defausse() {
        this.m_defausse = new ArrayList<>();
    }


    public int getNombreDePokemons() {
        return m_defausse.size();
    }

    /*
        public List<Pokemon> getM_pokemons() {
            return m_pokemons;
        }
    */
    @Override
    public void ajouterPokemon(Pokemon p)
    {
        m_defausse.add(p);
    }

    @Override
    public Pokemon getPokemon(int index) {
        return m_defausse.get(index);
    }


    @Override
    public void retirerPokemon(Pokemon pokemon) {
        // je ne sais pas trop quel serait l'utilité de cette méthode ici (potentiel REVIVE SKILL ?)
        m_defausse.remove(pokemon);
    }

    @Override
    public Pokemon getPokemonByName(String name) {
        return null;
    }

    @Override
    public int getNbPokemon() {
        return m_defausse.size();
    }
}


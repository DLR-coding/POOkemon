package Game.Pokemons.EnsemblePokemon;

import Game.Pokemons.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Defausse extends EnsemblePokemon{
    private List<Pokemon> m_defausse;

    public Defausse() {
        this.m_defausse = new ArrayList<>();
    }


    @Override
    public Pokemon getPokemon(int index) {
        return m_defausse.get(index);
    }




    @Override
    public Pokemon getPokemonByName(String name) {
        return null;
    }

    @Override
    public int getNbPokemon() {
        return m_defausse.size();
    }

    @Override
    public List<Pokemon> getEnsemble() {
        return m_defausse;
    }
}


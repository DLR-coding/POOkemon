package Game.Pokemons.EnsemblePokemon;

import Game.Pokemons.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Terrain extends EnsemblePokemon {
    private List<Pokemon> m_terrain;

    public Terrain() {
        this.m_terrain = new ArrayList<>();
    }

    public void ajouterPokemon(Pokemon p)
    {
        m_terrain.add(p);
    }

    @Override
    public Pokemon getPokemon(int index) {
        return m_terrain.get(index);
    }





    @Override
    public Pokemon getPokemonByName(String name) {
        for (Pokemon pokemon : m_terrain) {
            if (pokemon.getM_nom().equalsIgnoreCase(name)) {
                return pokemon;
            }
        }
        return null;
    }

    @Override
    public int getNbPokemon() {
        return m_terrain.size();
    }

    @Override
    public List<Pokemon> getEnsemble() {
        return m_terrain;
    }



    public Pokemon getPokemonAvecLeMoinsDeVie() {
        Pokemon cible = null;
        for (Pokemon p : m_terrain) {
            if (cible == null || p.getVie() < cible.getVie()) {
                cible = p;
            }
        }
        return cible;
    }


}

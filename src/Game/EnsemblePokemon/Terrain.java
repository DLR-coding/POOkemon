package Game.EnsemblePokemon;

import Game.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Terrain implements EnsemblePokemon {
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

    public List<Pokemon> getM_terrain()
    {
        return new ArrayList<>(m_terrain);
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

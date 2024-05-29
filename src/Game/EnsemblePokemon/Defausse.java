package Game.EnsemblePokemon;

import Game.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Defausse implements EnsemblePokemon{
    private List<Pokemon> m_defausse;

    public Defausse() {
        this.m_defausse = new ArrayList<>();
    }




    @Override
    public Pokemon getPokemon(int index) {
        return m_defausse.get(index);
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
        return m_defausse.size();
    }

    @Override
    public List<Pokemon> getEnsemble() {
        return m_defausse;
    }
}


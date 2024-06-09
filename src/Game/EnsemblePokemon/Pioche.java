package Game.EnsemblePokemon;
import Game.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Pioche extends EnsemblePokemon {

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
            pioche.add(PokemonGenerateur.genererPokemon());

        }

        m_pioche = pioche;
    }





    @Override
    public Pokemon getPokemonByName(String name) {
        return null;
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
    public void transferPokemon(Pokemon pokemon, EnsemblePokemon destination) {
        if (!destination.getEnsemble().contains(pokemon) && this.getEnsemble().contains(pokemon)) {
            destination.getEnsemble().add(pokemon);
            this.getEnsemble().remove(pokemon);
        } else {
            System.out.println("Le Pokémon invalide : déjà dans destination/pas dans source.");
        }
    }


    public int getNbPokemon()
    {
        return m_pioche.size();
    }

    @Override
    public List<Pokemon> getEnsemble() {
        return m_pioche;
    }
}



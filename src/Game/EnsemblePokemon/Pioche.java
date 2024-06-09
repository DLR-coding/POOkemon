package Game.EnsemblePokemon;
import Game.Pokemon;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant une pioche dans le jeu, qui est un type d'ensemble de Pokémon.
 * Hérite de la classe abstraite {@link EnsemblePokemon}.
 */
public class Pioche extends EnsemblePokemon {

    private List<Pokemon> m_pioche;

    /**
     * Constructeur par défaut de la pioche.
     * Initialise une liste vide de Pokémon.
     */
    public Pioche()
    {
        List<Pokemon> pioche = new ArrayList<>();
        m_pioche = pioche;
    }

    /**
     * Constructeur de la pioche avec un nombre spécifié de Pokémon.
     * Génère une pioche avec le nombre de Pokémon spécifié en utilisant le générateur de Pokémon.
     *
     * @param nombreDePokemons Le nombre de Pokémon à inclure dans la pioche.
     */
    public Pioche(int nombreDePokemons)
    {
        List<Pokemon> pioche = new ArrayList<>();
        for (int i = 0; i < nombreDePokemons; i++) {
            pioche.add(PokemonGenerateur.genererPokemon());
        }
        m_pioche = pioche;
    }


    /**
     * Obtient le Pokémon avec le nom spécifié dans la main du joueur.
     *
     * @param name Le nom du Pokémon à rechercher.
     * @return null.
     */
    @Override
    public Pokemon getPokemonByName(String name) {
        return null;
    }

    /**
     * Obtient le Pokémon à l'index spécifié dans la pioche.
     *
     * @param index L'index du Pokémon à récupérer.
     * @return Le Pokémon à l'index spécifié, ou null si l'index est invalide.
     */
    @Override
    public Pokemon getPokemon(int index) {
        if (index >= 0 && index < m_pioche.size()) {
            return m_pioche.get(index);
        } else {
            System.out.println("Index invalide.");
            return null;
        }
    }

    /**
     * Transfère un Pokémon de cette pioche vers une destination donnée.
     *
     * @param pokemon     Le Pokémon à transférer.
     * @param destination L'ensemble de destination du Pokémon.
     */
    @Override
    public void transferPokemon(Pokemon pokemon, EnsemblePokemon destination) {
        if (!destination.getEnsemble().contains(pokemon) && this.getEnsemble().contains(pokemon)) {
            destination.getEnsemble().add(pokemon);
            this.getEnsemble().remove(pokemon);
        } else {
            System.out.println("Le Pokémon invalide : déjà dans destination/pas dans source.");
        }
    }

    /**
     * Obtient le nombre de Pokémon dans la pioche.
     *
     * @return Le nombre de Pokémon dans la pioche.
     */
    public int getNbPokemon()
    {
        return m_pioche.size();
    }


    /**
     * Obtient la liste des Pokémon dans la pioche.
     *
     * @return La liste des Pokémon dans la pioche.
     */
    @Override
    public List<Pokemon> getEnsemble() {
        return m_pioche;
    }
}



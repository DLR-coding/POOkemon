package Game.EnsemblePokemon;

import Game.Pokemon;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant une défause dans le jeu, qui est un type d'ensemble de Pokémon.
 * Hérite de la classe abstraite {@link EnsemblePokemon}.
 */
public class Defausse extends EnsemblePokemon{
    private List<Pokemon> m_defausse;

    /**
     * Constructeur de la défause.
     * Initialise une liste vide de Pokémon.
     */
    public Defausse() {
        this.m_defausse = new ArrayList<>();
    }


    /**
     * Obtient le Pokémon à l'index spécifié dans la défause.
     *
     * @param index L'index du Pokémon à récupérer.
     * @return Le Pokémon à l'index spécifié.
     */
    @Override
    public Pokemon getPokemon(int index) {
        return m_defausse.get(index);
    }

    /**
     * Transfère un Pokémon de cette défause vers une destination donnée.
     *
     * @param pokemon      Le Pokémon à transférer.
     * @param destination  L'ensemble de destination du Pokémon.
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
     * Obtient le Pokémon avec le nom spécifié dans la défause.
     *
     * @param name Le nom du Pokémon à rechercher.
     * @return null.
     */
    @Override
    public Pokemon getPokemonByName(String name) {
        return null;
    }

    /**
     * Obtient le nombre de Pokémon dans la défause.
     *
     * @return Le nombre de Pokémon dans la défause.
     */
    @Override
    public int getNbPokemon() {
        return m_defausse.size();
    }

    /**
     * Obtient la liste des Pokémon dans la défause.
     *
     * @return La liste des Pokémon dans la défause.
     */
    @Override
    public List<Pokemon> getEnsemble() {
        return m_defausse;
    }
}


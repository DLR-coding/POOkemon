package Game.EnsemblePokemon;

import Game.Pokemon;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant la main d'un joueur dans le jeu, qui est un type d'ensemble de Pokémon.
 * Hérite de la classe abstraite {@link EnsemblePokemon}.
 */
public class MainDuJoueur extends EnsemblePokemon
{
    private List<Pokemon> m_mainJoueur;

    /**
     * Constructeur de la main du joueur.
     * Initialise une liste vide de Pokémon avec une capacité initiale de 3.
     */
    public MainDuJoueur()
    {
        List<Pokemon> main = new ArrayList<>(3);
        m_mainJoueur = main;
    }


    /**
     * Obtient le Pokémon à l'index spécifié dans la main du joueur.
     *
     * @param index L'index du Pokémon à récupérer.
     * @return Le Pokémon à l'index spécifié, ou null si l'index est invalide.
     */
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

    /**
     * Transfère un Pokémon de cette main du joueur vers une destination donnée.
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
     * Obtient le nombre de Pokémon dans la main du joueur.
     *
     * @return Le nombre de Pokémon dans la main du joueur.
     */
    @Override
    public int getNbPokemon() {
        return m_mainJoueur.size();
    }

    /**
     * Obtient la liste des Pokémon dans la main du joueur.
     *
     * @return La liste des Pokémon dans la main du joueur.
     */
    @Override
    public List<Pokemon> getEnsemble() {
        return m_mainJoueur;
    }

}

package Game.EnsemblePokemon;

import Game.Pokemon;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant le terrain de jeu où les Pokémons sont placés.
 */
public class Terrain extends EnsemblePokemon {
    private List<Pokemon> m_terrain;

    /**
     * Constructeur de la classe Terrain.
     * Initialise une nouvelle liste de Pokémons sur le terrain.
     */
    public Terrain() {
        this.m_terrain = new ArrayList<>();
    }

    /**
     * Ajoute un Pokémon au terrain.
     *
     * @param p Le Pokémon à ajouter.
     */
    public void ajouterPokemon(Pokemon p)
    {
        m_terrain.add(p);
    }

    /**
     * Obtient le Pokémon à un index donné sur le terrain.
     *
     * @param index L'index du Pokémon à obtenir.
     * @return Le Pokémon à l'index spécifié.
     */
    @Override
    public Pokemon getPokemon(int index) {
        return m_terrain.get(index);
    }

    /**
     * Transfère un Pokémon de ce terrain vers un autre ensemble de Pokémons.
     *
     * @param pokemon Le Pokémon à transférer.
     * @param destination L'ensemble de Pokémons de destination.
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
     * Obtient un Pokémon par son nom.
     *
     * @param name Le nom du Pokémon à obtenir.
     * @return le nom du pokemon, ou null s'il n'est pas trouvé.
     */
    @Override
    public Pokemon getPokemonByName(String name) {
        for (Pokemon pokemon : m_terrain) {
            if (pokemon.getM_nom().equalsIgnoreCase(name)) {
                return pokemon;
            }
        }
        return null;
    }


    /**
     * Obtient le nombre de Pokémons sur le terrain.
     *
     * @return Le nombre de Pokémons sur le terrain.
     */
    @Override
    public int getNbPokemon() {
        return m_terrain.size();
    }

    /**
     * Obtient la liste des Pokémons sur le terrain.
     *
     * @return la liste contenant les Pokémons sur le terrain.
     */
    @Override
    public List<Pokemon> getEnsemble() {
        return m_terrain;
    }

    /**
     * Obtient une copie de la liste des Pokémons sur le terrain.
     *
     * @return Une nouvelle liste contenant les Pokémons sur le terrain.
     */
    public List<Pokemon> getM_terrain()
    {
        return new ArrayList<>(m_terrain);
    }

    /**
     * Obtient le Pokémon ayant le moins de points de vie sur le terrain.
     *
     * @return Le Pokémon ayant le moins de points de vie, ou null si le terrain est vide.
     */
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
